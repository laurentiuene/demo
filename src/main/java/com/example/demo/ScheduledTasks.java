package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
@Slf4j
public class ScheduledTasks {

    @Scheduled(fixedRate = 5000000)
    public void reportCurrentTime() {
        log.info("PING");
    }
}
