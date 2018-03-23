package com.yoyo.rest;

import com.alibaba.druid.support.json.JSONUtils;
import com.yoyo.common.LoginInfo;
import com.yoyo.common.SysEnum;
import com.yoyo.model.SysUser;
import com.yoyo.service.IUserService;
import com.yoyo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 系统服务统一入口
 *
 * Created by fbin on 2018/3/23.
 */
@RestController
@Scope("prototype")
@RequestMapping("/sys")
public class SystemController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private IUserService userService;

    /**
     * 登录校验
     * @param request
     * @param response
     * @param loginInfo
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam("loginInfo") LoginInfo loginInfo){
        if("admin".equals(loginInfo.getAccount())){
            if("admin@123".equals(loginInfo.getPassword())){
                HttpSession session = request.getSession();
                String sessionId = session.getId();

                if(redisService.getSessionInfo(sessionId) == null){
                    SysUser sysUser = new SysUser();
                    sysUser.setName(loginInfo.getAccount());
                    sysUser.setPassword(loginInfo.getPassword());
                    // 加入缓存
                    redisService.addSessionInfo(sessionId, sysUser);
                }
                return JSONUtils.toJSONString(SysEnum.LOGIN_SUCCESS);
            }
        }
        return JSONUtils.toJSONString(SysEnum.LOGIN_FAILED);
    }

    @ResponseBody
    @RequestMapping(value="/findAll",method = RequestMethod.GET)
    public List<SysUser> findAll(){
        return userService.findAll();
    }
}
