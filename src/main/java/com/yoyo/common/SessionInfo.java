package com.yoyo.common;

import com.yoyo.model.SysUser;

/**
 * session信息存储类
 *
 * Created by fbin on 2018/3/23.
 */
public class SessionInfo {

    private String sessionId;

    private SysUser sysUser;

    private long timestamp;

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

}
