package org.explorer.core.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("execution(* org.explorer..*.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
		Object returnVal=joinPoint.proceed();
		StringBuffer logMsg=new StringBuffer();
		logMsg.append(joinPoint.getTarget().getClass().getName());
		logMsg.append(".");
		logMsg.append(joinPoint.getSignature().getName());
		log.info(logMsg.toString());
		return returnVal;
	} 
	
}
