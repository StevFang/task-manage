package com.yoyo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * Created by fbin on 2018/3/15.
 */
@SpringBootApplication
@MapperScan("com.yoyo.dao")
public class Application {

    /**
     * 项目启动
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
