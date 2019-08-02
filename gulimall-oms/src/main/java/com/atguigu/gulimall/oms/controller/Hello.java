package com.atguigu.gulimall.oms.controller;

import com.atguigu.gulimall.oms.feign.worldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope//可以从配置中自动刷新
@RestController
public class Hello {

    @Autowired
    private worldService WorldService;

    @Value("${my.content}")
    private String content = "";

    @GetMapping("hello")
    public String hello(){
        String str = "";
        str = WorldService.worldController();
        return "hello" + str + content;
    }
}
