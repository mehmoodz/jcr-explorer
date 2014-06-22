package org.explorer.core.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Around("execution(* org.explorer..*.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
		Object returnVal=joinPoint.proceed();
		StringBuffer logMsg=new StringBuffer();
		logMsg.append(joinPoint.getTarget().getClass().getName());
		logMsg.append(".");
		logMsg.append(joinPoint.getSignature().getName());
		return returnVal;
	} 
	
}
