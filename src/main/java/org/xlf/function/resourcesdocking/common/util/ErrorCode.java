package org.xlf.function.resourcesdocking.common.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    /*
     * 通用错误码
     */
    WRONG_PASSWORD("WrongPassword", 40000, "密码错误"),
    USER_NOT_FOUND("UserNotFound", 40001, "用户不存在"),
    USER_EXIST("UserExist", 40002, "用户已存在"),
    REQUEST_BODY_ERROR("RequestBodyError", 40003, "请求体错误"),
    USER_VERIFY("UserVerify", 40100, "用户未通过验证"),
    USER_BAN("UserBan", 40101, "用户已被封禁"),
    USER_NOT_LOGIN("UserNotLogin", 40102, "用户未登录"),
    USER_NOT_PERMISSION("UserNotPermission", 40103, "用户无权限"),
    USER_NOT_ACTIVE("UserNotActive", 40104, "用户未激活"),
    TIMESTAMP_IS_NOT_IN_TIME("TimestampIsNotInTime", 40300, "时间戳不在合法时间内");

    private final String output;
    private final Integer code;
    private final String message;
}
