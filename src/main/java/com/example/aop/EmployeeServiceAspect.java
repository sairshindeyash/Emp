package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {
	@Before(value="execution(* com.example.service.EmployeeService.*(..))")
	public void beforeAdvice(JoinPoint joinPoint){
		System.out.println("beforse service method got called");
	}
	
	@After(value="execution(* com.example.service.EmployeeService.*(..))")
	public void afterAdvice(JoinPoint joinPoint){
		System.out.println("after service method got called");
	}
	
	@AfterReturning(value="execution(* com.example.service.EmployeeService.*(..))")
	public void afterReturningAdvice(JoinPoint joinPoint){
		System.out.println("AfterReturning service method got called");
	}
}
