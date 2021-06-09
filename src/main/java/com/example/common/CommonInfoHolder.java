package com.example.common;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.example.domain.CommonInfo;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zhangdj
 * @Date 2021/6/3:10:08
 * @Description
 */
public class CommonInfoHolder {
    private static TransmittableThreadLocal<CommonInfo> dataHolder = new TransmittableThreadLocal<CommonInfo>() {
        protected CommonInfo initialValue() {
            return new CommonInfo();
        }
    };

    static AtomicInteger index = new AtomicInteger(0);

    public static String getTraceId() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        // incrementAndGet():返回的是加1后的值
        if (index.incrementAndGet() > 1000) {
            index.set(1);
        }
        return uuid + index;
    }

    public static void setUserId(Integer userId) {
        dataHolder.get().setUserId(userId);
    }

    public static void setToken(String token) {
        dataHolder.get().setToken(token);
    }

    public static Integer getUserId() {
        return dataHolder.get().getUserId();
    }

    public static String getToken() {
        return dataHolder.get().getToken();
    }

    public static void clean() {
        dataHolder.remove();
    }
}