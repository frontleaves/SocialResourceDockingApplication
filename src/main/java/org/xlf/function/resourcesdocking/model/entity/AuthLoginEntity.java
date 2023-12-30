package org.xlf.function.resourcesdocking.model.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>AuthLoginEntity 登录实体类</h1>
 * <hr/>
 * 用于封装登录信息
 *
 * @since v1.0.0
 * @version v1.0.0
 * @author 筱锋xiao_lfeng
 */
@Getter
@Setter
public class AuthLoginEntity {
    @NotBlank(message = "用户名不能为空")
    private String user;
    @NotBlank(message = "密码不能为空")
    private String password;
}
