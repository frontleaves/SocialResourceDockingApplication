package org.xlf.function.resourcesdocking.common.util;

import org.jetbrains.annotations.NotNull;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;

/**
 * <h1>Processing 处理工具类</h1>
 * <hr/>
 * 用于处理数据
 *
 * @version v1.0.0
 * @since v1.0.0
 */
public class Processing {
    /**
     * <h2>getValidatedErrorList 获取验证错误信息列表</h2>
     * <hr/>
     * 用于获取验证错误信息列表
     *
     * @param bindingResult 错误信息
     * @return {@link ArrayList<String>}
     */
    public static @NotNull ArrayList<String> getValidatedErrorList(BindingResult bindingResult) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (ObjectError objectError : bindingResult.getAllErrors()) {
            arrayList.add(objectError.getDefaultMessage());
        }
        return arrayList;
    }
}
