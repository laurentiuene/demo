package com.example.demo.url;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/urlShortener")
@RequiredArgsConstructor
public class UrlShortenerController {
    private final UrlManager urlManager;

    @PostMapping(value = "/{url}")
    public ResponseEntity shortenUrl(@PathVariable("url") String url) {
        String shortUrlEntry = urlManager.shortenUrl(url);
        return ResponseEntity.ok(shortUrlEntry);
    }

    @GetMapping(value = "/{key}")
    public ResponseEntity getUrl(@PathVariable("key") String key) {
        String url = urlManager.getUrlByKey(key);
        return ResponseEntity.ok(url);
    }

}
