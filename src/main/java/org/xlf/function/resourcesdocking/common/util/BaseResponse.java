package org.xlf.function.resourcesdocking.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

/**
 * <h1>BaseResponse 基础响应类</h1>
 * <hr/>
 * 用于封装响应数据
 *
 * @since v1.0.0
 * @version v1.0.0
 * @author 筱锋xiao_lfeng
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

    private final String output;
    private final Integer code;
    private final String message;
    private final Object data;

    public BaseResponse(String output, Integer code, String message, Object data) {
        this.output = output;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(String output, Integer code, String message) {
        this.output = output;
        this.code = code;
        this.message = message;
        this.data = null;
    }
}
