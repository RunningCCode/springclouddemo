package com.czc.springclouddemo.eurekaconsumer.controller;

import com.czc.springclouddemo.eurekaconsumer.service.feignservice.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.EnumSet;

/**
 * @author chenzhicong
 * @time 2019/7/17 15:41
 * @description
 */
@RequestMapping("/hello")
@RestController
public class HelloController {

    @Autowired
    private LoadBalancerClient client;

    @Autowired
    @Qualifier("LoadBalancerClient")
    private RestTemplate restTemplate1LoadBalancerClient;

    @Autowired
    @Qualifier("ribbon")
    private RestTemplate restTemplateRibbon;

    @Autowired
    private HelloRemote helloRemote;



    /**
      * LoadBalancerClient 方式调用
      */
    @GetMapping("/loadBalancerClient")
    public String helloLoadBalancerClient(@RequestParam String name) {
        name += "!";
        ServiceInstance instance = client.choose("eureka-producer");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/hello/?name=" + name;
        return restTemplate1LoadBalancerClient.getForObject(url, String.class);
    }


    /**
     * ribbon 方式调用
     */
    @GetMapping("/ribbon")
    public String helloRibbon(@RequestParam String name) {
        name += "!";
        String url = "http://eureka-producer/hello/?name=" + name;
        return restTemplateRibbon.getForObject(url, String.class);
    }

    /**
      * feign方式调用（最常用）
      */
    @GetMapping("/feign/{name}")
    public String index(@PathVariable("name") String name) {
        return helloRemote.hello(name + "!");
    }

}
