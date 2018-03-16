package com.yoyo.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fbin on 2018/3/16.
 */
@Controller
@Scope("prototype")
@RequestMapping("/")
public class ViewController {

    @RequestMapping("/template")
    public String templateInit(){
        return "template";
    }

}
