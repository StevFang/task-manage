package com.yoyo.service;

import com.yoyo.common.SessionInfo;
import com.yoyo.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Redis服务类
 *
 * Created by fbin on 2018/3/23.
 */
@Service("redisService")
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private Set<SessionInfo> sessionInfoSet = new HashSet<SessionInfo>();

    @CachePut(value = "sessionInfo", key = "'SessionInfo:'+#sessionInfo.sessionId")
    public SessionInfo addSessionInfo(SessionInfo sessionInfo) {
        sessionInfoSet.add(sessionInfo);
        return sessionInfo;
    }

    @Cacheable(value = "sessionInfo", key = "'SessionInfo:'+#sessionId")
    public SessionInfo addSessionInfo(String sessionId, SysUser sysUser) {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.setSessionId(sessionId);
        sessionInfo.setSysUser(sysUser);
        sessionInfo.setTimestamp(System.currentTimeMillis());
        sessionInfoSet.add(sessionInfo);
        return sessionInfo;
    }

    @Cacheable(value = "sessionInfo", key = "'SessionInfo:'+#sessionId")
    public SessionInfo getSessionInfo(String sessionId) {
        Iterator<SessionInfo> iterator = sessionInfoSet.iterator();
        while(iterator.hasNext()){
            SessionInfo sessionInfo = iterator.next();
            if(sessionInfo.getSessionId().equals(sessionId)){
                return sessionInfo;
            }
        }
        return null;
    }

}
