package org.xlf.function.resourcesdocking.common.util;

import lombok.Getter;

@Getter
public enum ErrorCode {

    /*
     * 通用错误码
     */
    WRONG_PASSWORD("WrongPassword", 40000, "密码错误"),
    USER_NOT_FOUND("UserNotFound", 40001, "用户不存在"),
    USER_EXIST("UserExist", 40002, "用户已存在"),
    USER_BAN("UserBan", 40003, "用户已被封禁"),
    USER_VERIFY("UserVerify", 40004, "用户未通过验证"),
    USER_NOT_LOGIN("UserNotLogin", 40005, "用户未登录"),
    USER_NOT_PERMISSION("UserNotPermission", 40006, "用户无权限"),
    USER_NOT_ACTIVE("UserNotActive", 40007, "用户未激活");

    private final String output;
    private final Integer code;
    private final String message;

    ErrorCode(String output, Integer code, String message) {
        this.output = output;
        this.code = code;
        this.message = message;
    }
}
