package com.example.library.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LibraryAop {
    private static int count = 0;

    @Pointcut("execution(* com.example.library.controller.PersonalCodeController.borrowBook(..))")
    public void doBorrowBook() {
    }

    @After("doBorrowBook()")
    public void beforeController(JoinPoint joinPoint) {
        System.err.println("Có sách đã được mượn " + joinPoint.getSignature().getName() + "___vào lúc : " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.example.library.controller.PersonalCodeController.returnBook(..))")
    public void doReturnBook() {
    }

    @After("doReturnBook()")
    public void afterController(JoinPoint joinPoint) {
        System.err.println("Có sách đã hoàn trả " + joinPoint.getSignature().getName() + "___vào lúc : " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.example.library.controller.PersonalCodeController.*(..))")
    public void checkCountLog() {
    }

    @Before("checkCountLog()")
    public void count(JoinPoint joinPoint) {

        System.err.println("Số thao tác " + ++count + "___vào lúc : " + LocalDateTime.now());

    }
}
