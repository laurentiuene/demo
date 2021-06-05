package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HelloController {

    @GetMapping("/example")
    public String test() throws UnknownHostException {
        return "Version 1 is hosted by the pod " + InetAddress.getLocalHost() + " !";
    }
}
