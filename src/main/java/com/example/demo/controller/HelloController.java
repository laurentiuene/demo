package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HelloController {

    @GetMapping
    public String baseUrl() throws UnknownHostException {
        return "Version 2 is hosted by the pod " + InetAddress.getLocalHost() + " !";
    }

    @GetMapping("/health")
    public ResponseEntity health() throws UnknownHostException {
        return ResponseEntity.ok().build();
    }
}
