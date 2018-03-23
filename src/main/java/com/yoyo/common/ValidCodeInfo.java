package com.yoyo.common;

/**
 * 验证码信息
 *
 * Created by fbin on 2018/3/23.
 */
public class ValidCodeInfo {

    private String validCode;

    private String sessionId;

    private long timestamp;

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

}
