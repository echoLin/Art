/**
 * @Title {filename}
 * @Package cn.edu.xmu.controller.AOP
 * @exception TODO
 * @author echo
 * @date 2015年12月18日 上午111259
 * @version V1.0
 */
package cn.edu.xmu.controller.AOP;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file isUserAOP.java
 * @package cn.edu.xmu.controller.AOP
 * @project Art
 * @version 检查用户是否登录
 */
@Aspect
@Component
public class isUserAOP {
	/**
	 * 
	 * @Method aroundExec
	 * @exception 检查用户是否已登录
	 * @param joinPoint ProceedingJoinPoint 切入点
	 * @return
	 * @throws Throwable
	 * @author echo
	 * @time 2016年1月17日
	 */
	@Around("@annotation(cn.edu.xmu.controller.AOP.isUser)")
	public Object aroundExec(ProceedingJoinPoint joinPoint) throws Throwable{
		Object[] args = joinPoint.getArgs();
		HttpServletRequest request=(HttpServletRequest) args[args.length-2];
		HttpServletResponse response=(HttpServletResponse) args[args.length-1];
		HttpSession session=request.getSession();
		try{	
			if(session.getAttribute("user") == null){
				//未登录
				throw new Exception();
			}
		}catch(Exception e){
			try {
				request.getRequestDispatcher("/mall/login").forward(request, response);
			} catch (ServletException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return joinPoint.proceed();
	}
}
