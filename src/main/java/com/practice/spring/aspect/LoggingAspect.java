package com.practice.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	@Before("execution(public String toString())")
	public void loggingAdvice() {
		System.out.println("Advice running!!");
	}

}
