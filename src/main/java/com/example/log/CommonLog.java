package com.example.log;

import com.example.common.CommonInfoHolder;
import com.example.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 公共日志
 *
 * @Author zhangdj
 * @Date 2021/6/9:17:16
 */
public class CommonLog {
    private static Logger logger = LoggerFactory.getLogger(CommonLog.class);

    public static void error(Throwable throwable, String marker, Object... objects) {
        logger.error(processLogMarker(marker, throwable), objects);
    }

    public static void error(String marker, Object... objects) {
        logger.error(processLogMarker(marker, null), objects);
    }

    public static void warn(String marker, Object... objects) {
        logger.warn(processLogMarker(marker, null), objects);
    }

    public static void info(String marker, Object... objects) {
        logger.info(processLogMarker(marker, null), objects);
    }

    public static void debug(String marker, Object... objects) {
        logger.debug(processLogMarker(marker, null), objects);
    }

    private static String processLogMarker(String marker, Throwable throwable) {
        StringBuilder builder = new StringBuilder();
        builder.append("[traceId: ").append(CommonInfoHolder.getTraceId()).append("] ").append("[user_id: ")
                .append(CommonInfoHolder.getUserId()).append("] ")
                .append(marker).append(ExceptionUtil.getFullStackTrace(throwable, 5));
        return builder.toString();
    }
}