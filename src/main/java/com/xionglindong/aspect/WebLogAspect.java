package com.xionglindong.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * <p>使用AOP统一处理Web请求日志</p>
 * <p>--@Order(i)注解来标识切面的优先级。i的值越小，优先级越高。</p>
 * @author xld 
 *
 */
@Aspect  //将该java类定义为切面类
@Component
public class WebLogAspect {
	
	private Logger log = Logger.getLogger(WebLogAspect.class);
	
	ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	
	//定义的切入点为com.xionglindong.web包下所有函数
	@Pointcut("execution(public * com.xionglindong.web..*.*(..))")
	public void webLog(){
		
	}
	
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable{
		startTime.set(System.currentTimeMillis());
		//接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		//记录请求内容
		log.info("URL:"+request.getRequestURI().toString());
		log.info("HTTP_METHOD:"+request.getMethod());
		log.info("IP:"+request.getRemoteAddr());
		log.info("CLASS_METHOD:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		log.info("ARGS:"+Arrays.toString(joinPoint.getArgs()));
	}
	
	@AfterReturning(returning="ret",pointcut="webLog()")
	public void doAfterReturning(Object ret) throws Throwable{
		//处理完请求，返回内容
		log.info("RESPONSE:"+ ret);
		log.info("SPEND TIME:"+(System.currentTimeMillis()-startTime.get()));
	}

}
