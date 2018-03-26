package com.yoyo.controller;

import com.yoyo.common.SessionInfo;
import com.yoyo.model.SysUser;
import com.yoyo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by fbin on 2018/3/25.
 */
public class BaseController {

    @Autowired
    protected RedisService redisService;

    protected SysUser getSysUser(HttpServletRequest request, RedisService redisService){
        HttpSession session = request.getSession();
        String sessionID = session.getId();
        SessionInfo sessionInfo = redisService.getSessionInfo(sessionID);
        if(sessionInfo != null){
            return sessionInfo.getSysUser();
        }
        return null;
    }

}
