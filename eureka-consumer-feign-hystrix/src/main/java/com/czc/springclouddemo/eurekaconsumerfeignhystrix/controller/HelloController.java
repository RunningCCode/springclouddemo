package com.czc.springclouddemo.eurekaconsumerfeignhystrix.controller;

import com.czc.springclouddemo.eurekaconsumerfeignhystrix.service.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenzhicong
 * @time 2019/7/22 10:50
 * @description
 */
@RequestMapping("/hello")
@RestController
public class HelloController {
    @Autowired
    private HelloRemote helloRemote;
    /**
     * feign方式调用（最常用）
     */
    @GetMapping("/feign/{name}")
    public String index(@PathVariable("name") String name) {
        return helloRemote.hello(name + "!");
    }

}
