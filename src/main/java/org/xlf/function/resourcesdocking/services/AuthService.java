package org.xlf.function.resourcesdocking.services;

import org.xlf.function.resourcesdocking.common.util.BaseResponse;
import org.xlf.function.resourcesdocking.model.entity.AuthLoginEntity;

/**
 * <h1>AuthService 认证服务接口</h1>
 * <hr/>
 * 用于处理认证相关请求
 *
 * @version v1.0.0
 * @see org.xlf.function.resourcesdocking.services.impl.AuthServiceImpl
 * @since v1.0.0
 */
public interface AuthService {
    /**
     * <h2>userSignIn 用户登录</h2>
     * <hr/>
     * 用于处理用户登录请求
     *
     * @param loginEntity 登录实体
     * @return BaseResponse
     */
    BaseResponse userSignIn(AuthLoginEntity loginEntity);
}
