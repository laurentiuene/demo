package com.example.demo.openId_connect;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HelloEndpoint {

    @GetMapping("/demo")
    public ResponseEntity demo() throws UnknownHostException {
        return ResponseEntity.ok().build();
    }
}
