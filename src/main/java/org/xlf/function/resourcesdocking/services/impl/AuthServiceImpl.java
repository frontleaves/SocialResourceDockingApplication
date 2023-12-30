package org.xlf.function.resourcesdocking.services.impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.xlf.function.resourcesdocking.common.util.BaseResponse;
import org.xlf.function.resourcesdocking.common.util.ErrorCode;
import org.xlf.function.resourcesdocking.common.util.ResultUtil;
import org.xlf.function.resourcesdocking.model.UserDO;
import org.xlf.function.resourcesdocking.model.entity.AuthLoginEntity;
import org.xlf.function.resourcesdocking.repositories.AuthDAO;
import org.xlf.function.resourcesdocking.services.AuthService;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * <h1>AuthServiceImpl 认证服务实现类</h1>
 * <hr/>
 * 用于处理认证相关请求
 *
 * @since v1.0.0
 * @version v1.0.0
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    /**
     * 认证数据访问对象
     */
    private final AuthDAO authDAO;

    @Override
    public BaseResponse userSignIn(@NotNull AuthLoginEntity loginEntity) {
        // 正则表达式检查用户数据
        UserDO userDO;
        if (Pattern.matches("^[a-zA-Z0-9_-]{3,40}$", loginEntity.getUser())) {
            userDO = authDAO.getUserByUsername(loginEntity.getUser());
        } else if (Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", loginEntity.getUser())) {
            userDO = authDAO.getUserByEmail(loginEntity.getUser());
        } else if (Pattern.matches("^\\+[0-9]+ [0-9]+$", loginEntity.getUser())) {
            // 拆分国区与手机号
            String[] split = loginEntity.getUser().split(" ");
            split[0] = new StringBuilder(split[0]).deleteCharAt(0).toString();
            userDO = authDAO.getUserByTelephone(split);
        } else {
            return ResultUtil.error(ErrorCode.REQUEST_BODY_ERROR, new ArrayList<String>().add("用户名或邮箱或手机号格式错误"));
        }
        // 验证用户是否存在
        if (userDO == null) {
            return ResultUtil.error(ErrorCode.USER_NOT_FOUND);
        }
        // 验证密码是否正确
        if (BCrypt.checkpw(loginEntity.getPassword(), userDO.getPassword())) {
            return ResultUtil.success("Success", "登陆成功",userDO);
        } else {
            return ResultUtil.error(ErrorCode.WRONG_PASSWORD);
        }
    }
}
