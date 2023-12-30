package org.xlf.function.resourcesdocking.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.xlf.function.resourcesdocking.common.util.ErrorCode;
import org.xlf.function.resourcesdocking.common.util.ResultUtil;

import java.util.Objects;

/**
 * <h1>TimestampAspect 时间戳切面</h1>
 * <hr/>
 * 用于处理时间戳相关逻辑
 *
 * @since v1.0.0
 * @version v1.0.0
 */
@Aspect
@Component
public class TimestampAspect {
    /**
     * <h2>authControllerAround 认证控制器切面</h2>
     * <hr/>
     * 用于认证控制器的切面
     *
     * @param pjp ProceedingJoinPoint对象
     * @return {@link Object}
     */
    @Around("execution(* org.xlf.function.resourcesdocking.controllers.AuthController.*(..))")
    public Object authControllerAround(ProceedingJoinPoint pjp) throws Throwable {
        // 获取HttpServletRequest对象
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        // 时间戳检查
        if (checkTimestamp(request)) {
            // TODO: 2023/12/30 0001 后期固定业务（如：日志处理）
            return pjp.proceed();
        } else {
            return ResultUtil.error(ErrorCode.TIMESTAMP_IS_NOT_IN_TIME);
        }
    }

    /**
     * <h2>checkTimestamp 检查时间戳</h2>
     * <hr/>
     * 用于检查时间戳是否合法，合法时间范围正负 1 秒
     *
     * @param request HttpServletRequest对象
     * @return {@link Boolean}
     */
    public Boolean checkTimestamp(@NotNull HttpServletRequest request) {
        // 获取请求头中的时间戳
        String getTimestamp = request.getHeader("Timestamp");
        // 判断是否为空
        if (getTimestamp == null || getTimestamp.isEmpty()) {
            return false;
        } else {
            if (getTimestamp.length() == 10) {
                getTimestamp += "000";
            }
        }
        // 获取当前时间戳
        long nowTimestamp = System.currentTimeMillis();
        // 时间误差允许前后五秒钟
        return nowTimestamp - Long.parseLong(getTimestamp) <= 1000 && nowTimestamp - Long.parseLong(getTimestamp) >= -1000;
    }
}
