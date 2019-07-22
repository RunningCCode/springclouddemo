package com.czc.springclouddemo.eurekaconsumerfeignhystrix.service.hystrix;

import com.czc.springclouddemo.eurekaconsumerfeignhystrix.service.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chenzhicong
 * @time 2019/7/22 10:48
 * @description
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "Hello World!";
    }

}
