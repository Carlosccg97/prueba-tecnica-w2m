package com.w2m.starshipdb.aspect;

import java.io.IOException;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExceptionControllerAspect {

	@AfterThrowing(pointcut = "execution(* com.w2m.starshipdb.controller.*.*(..)) *", throwing = "ex")
	public void handleExceptions(Exception ex) {
		if (ex instanceof IOException) {
			System.out.println("IOException");
		}
	}
}

