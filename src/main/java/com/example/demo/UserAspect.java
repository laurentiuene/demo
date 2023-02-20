package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Slf4j
@Configuration
public class UserAspect {

    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
    @Before("execution(* com.example.demo.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        //Advice
        log.info(" Check for user access ");
        log.info(" Allowed execution for {}", joinPoint);
    }
}
