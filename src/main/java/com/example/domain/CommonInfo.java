package com.example.domain;

/**
 * @Author zhangdj
 * @Date 2021/6/3:10:06
 * @Description
 */
public class CommonInfo {
    private Integer userId;
    private String token;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CommonInfo{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                '}';
    }
}