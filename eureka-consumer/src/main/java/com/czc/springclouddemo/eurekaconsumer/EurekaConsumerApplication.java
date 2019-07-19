package com.czc.springclouddemo.eurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class EurekaConsumerApplication {
    /**
      * LoadBalancerClient 方式调用
      */
    @Bean("LoadBalancerClient")
    public RestTemplate restTemplateLoadBalancerClient() {
        return new RestTemplate();
    }

    /**
     *  ribbon方式调用
     *
     */
    @LoadBalanced
    @Bean("ribbon")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }





    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

}
