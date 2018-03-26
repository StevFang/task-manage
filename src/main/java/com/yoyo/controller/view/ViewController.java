package com.yoyo.controller.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 界面渲染层
 *
 * Created by fbin on 2018/3/16.
 */
@Controller
@Scope("prototype")
@RequestMapping("/")
public class ViewController {

    /**
     * 登录页
     * @return
     */
    @RequestMapping("/login")
    public String loginInit(){
        return "login";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public String indexInit(){
        return "index";
    }

    /**
     * 任务中心
     * @return
     */
    @RequestMapping("/task/list")
    public String taskList(){
        return "taskList";
    }

}
