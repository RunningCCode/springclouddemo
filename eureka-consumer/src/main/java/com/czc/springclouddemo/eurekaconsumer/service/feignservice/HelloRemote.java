package com.czc.springclouddemo.eurekaconsumer.service.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chenzhicong
 * @time 2019/7/19 10:37
 * @description
 */
@FeignClient(name = "eureka-producer")
public interface HelloRemote {
    @GetMapping("/hello/")
    String hello(@RequestParam(value = "name") String name);
}
