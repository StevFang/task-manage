package com.yoyo.controller;

import com.yoyo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主页面控制类
 *
 * Created by fbin on 2018/3/15.
 */
@RestController
@Scope("prototype")
@RequestMapping("/")
public class IndexController {

    @Autowired
    private Book book;

    @RequestMapping("/index")
    public String indexInit(){
        return "书名："+book.getName()+"，作者："+book.getAuthor()+"，版本："+book.getVersion();
    }

}
