package com.practice.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.practice.spring.shapes.Point;

@Aspect
public class LoggingAspect {

	@Before("execution(public String com.practice.spring.shapes.Circle.toString())")
	public void loggingAdvice() {
		System.out.println("loggingAdvice running!!");
	}

	@Before("execution(* get*())")
	public void secondAdvice() {
		System.out.println("secondAdvice running");
	}

	@Before("allDrawMethods()")
	public void thirdAdvice() {
		System.out.println("thirdAdvice running using Pointcut");
	}

	@After("allLineSegmentMethods()")
	public void fourthAdvice(JoinPoint jp) {
		System.out.println("JoinPoint is: " + jp.toString());
		System.out.println("JoinPoint object is: " + jp.getTarget());
		System.out.println("fourthAdvice running!!");
	}
	
	@Pointcut("execution(* draw*(..))")
	public void allDrawMethods() {}
	
//	@Pointcut("execution(* com.practice.spring.shapes.LineSegment.*(..))")
	@Pointcut("within(com.practice.spring.shapes.LineSegment)")	//Same expression as above that reads better
	public void allLineSegmentMethods() {}

	@Before("args(paramName, paramName1)")
	public void fifthAdvice(float paramName, float paramName1) {
		System.out.println("argument passed is: " + paramName);
	}
	
	@AfterReturning("execution(public String com.practice.spring.shapes.Circle.toString())")
	public void sixthAdvice() {
		System.out.println("sixth advice is running after method execution!!");
	}
	
	@Pointcut("execution(public void com.practice.spring.shapes.Circle.aopDemoMethod())")
	public void aopDemoMethodAdvice() {}
	
	//@Around("execution(public void com.practice.spring.shapes.Circle.aopDemoMethod())")
	@Around("aopDemoMethodAdvice()")
	public void seventhAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("seventh advice is running before(around) target method execution!!");
		proceedingJoinPoint.proceed();
		System.out.println("seventh advice is running after(around) target method execution!!");
	}
}
