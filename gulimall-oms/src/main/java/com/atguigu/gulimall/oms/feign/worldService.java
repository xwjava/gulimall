package com.atguigu.gulimall.oms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gulimall-pms")
public interface worldService {

    @GetMapping("world")
    public String worldController();

}
