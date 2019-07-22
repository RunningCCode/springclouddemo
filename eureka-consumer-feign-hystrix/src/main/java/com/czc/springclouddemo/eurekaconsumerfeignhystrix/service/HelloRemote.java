package com.czc.springclouddemo.eurekaconsumerfeignhystrix.service;

import com.czc.springclouddemo.eurekaconsumerfeignhystrix.service.hystrix.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chenzhicong
 * @time 2019/7/22 10:47
 * @description
 */
@FeignClient(name = "eureka-producer", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @GetMapping("/hello/")
    String hello(@RequestParam(value = "name") String name);

}
