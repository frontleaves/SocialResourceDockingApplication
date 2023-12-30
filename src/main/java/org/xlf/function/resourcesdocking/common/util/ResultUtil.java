package org.xlf.function.resourcesdocking.common.util;

import org.jetbrains.annotations.NotNull;

/**
 * <h1>ResultUtil 响应结果工具类</h1>
 * <hr/>
 * 用于封装响应结果
 *
 * @author 筱锋xiao_lfeng
 * @version v1.0.0
 * @see BaseResponse
 * @since v1.0.0
 */
public class ResultUtil {

    /**
     * <h2>Success 成功响应结果</h2>
     * <hr/>
     * 用于封装成功响应结果
     *
     * @return BaseResponse
     */
    public static @NotNull BaseResponse success() {
        return new BaseResponse("Success", 200, "操作成功");
    }

    /**
     * <h2>Success 成功响应结果</h2>
     * <hr/>
     * 用于封装成功响应结果
     *
     * @param data 响应数据
     * @return BaseResponse
     */
    public static @NotNull BaseResponse success(Object data) {
        return new BaseResponse("Success", 200, "操作成功", data);
    }

    /**
     * <h2>Success 成功响应结果</h2>
     * <hr/>
     * 用于封装成功响应结果
     *
     * @param output 输出信息
     * @param message 响应信息
     * @return BaseResponse
     */
    public static @NotNull BaseResponse success(String output, String message) {
        return new BaseResponse(output, 200, message);
    }

    /**
     * <h2>Success 成功响应结果</h2>
     * <hr/>
     * 用于封装成功响应结果
     *
     * @param output 输出信息
     * @param message 响应信息
     * @param data 响应数据
     * @return BaseResponse
     */
    public static @NotNull BaseResponse success(String output, String message, Object data) {
        return new BaseResponse(output, 200, message, data);
    }

    /**
     * <h2>Error 错误响应结果</h2>
     * <hr/>
     * 用于封装错误响应结果
     *
     * @param errorCode 错误码
     * @return BaseResponse
     */
    public static @NotNull BaseResponse error(@NotNull ErrorCode errorCode) {
        return new BaseResponse(errorCode.getOutput(), errorCode.getCode(), errorCode.getMessage());
    }

    /**
     * <h2>Error 错误响应结果</h2>
     * <hr/>
     * 用于封装错误响应结果
     *
     * @param output 输出信息
     * @param code 业务错误码
     * @param message 响应信息
     * @return BaseResponse
     */
    public static @NotNull BaseResponse error(String output, Integer code, String message) {
        return new BaseResponse(output, code, message);
    }
}
