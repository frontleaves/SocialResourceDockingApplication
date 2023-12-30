package org.xlf.function.resourcesdocking.controllers;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xlf.function.resourcesdocking.common.util.BaseResponse;
import org.xlf.function.resourcesdocking.common.util.ErrorCode;
import org.xlf.function.resourcesdocking.common.util.Processing;
import org.xlf.function.resourcesdocking.common.util.ResultUtil;
import org.xlf.function.resourcesdocking.model.entity.AuthLoginEntity;
import org.xlf.function.resourcesdocking.services.AuthService;

/**
 * <h1>AuthController 认证控制器</h1>
 * <hr/>
 * 用于处理认证相关请求
 *
 * @version v1.0.0
 * @since v1.0.0
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AuthController {
    /**
     * 认证服务
     */
    private final AuthService authService;

    /**
     * <h2>userSignIn 用户登录</h2>
     * <hr/>
     * 用于处理用户登录请求
     *
     * @return BaseResponse
     */
    @GetMapping("/sign/in")
    public BaseResponse userSignIn(@RequestBody @Validated AuthLoginEntity loginEntity, @NotNull BindingResult bindingResult) {
        // 验证请求体
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(ErrorCode.REQUEST_BODY_ERROR, Processing.getValidatedErrorList(bindingResult));
        }
        // 处理用户登录
        return authService.userSignIn(loginEntity);
    }
}
