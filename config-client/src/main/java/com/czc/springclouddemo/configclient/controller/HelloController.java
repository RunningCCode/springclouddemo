package com.czc.springclouddemo.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author chenzhicong
 * @time 2019/7/22 23:01
 * @description
 */
@RestController
@RefreshScope //刷新从config-server里面更新而来的变量
public class HelloController {

    @Value("${info.profile:error}")
    private String profile;
    @Value("${neo.hello:error}")
    private String hello;
    @Value("${spring.cloud:error}")
    private String uri;

    @GetMapping("/info")
    public Mono<String> hello() {
        System.out.println(hello);
        System.out.println(profile);
        System.out.println(uri);

        return Mono.justOrEmpty(profile+":"+hello+":"+uri);
    }
}
