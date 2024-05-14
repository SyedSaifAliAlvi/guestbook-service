package com.guestbook.guestbookservice.logging;

import lombok.extern.log4j.Log4j2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class ControllerLoggingAspect {

    @Before("execution(* com.guestbook.guestbookservice.controller.GuestBookController.*(..))")
    public void logMethodStart(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Method {} started...", methodName);
    }

    @After("execution(* com.guestbook.guestbookservice.controller.GuestBookController.*(..))")
    public void logMethodEnd(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Method {} ended...", methodName);
    }
}

