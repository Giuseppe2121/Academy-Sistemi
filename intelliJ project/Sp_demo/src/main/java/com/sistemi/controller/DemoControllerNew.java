package com.sistemi.controller;

import com.sistemi.Bean.MessageBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo-service")
public class DemoControllerNew {

    @GetMapping("/welcome")
    public MessageBean getMessage(){

        return new MessageBean("welcome1");
    }
}
