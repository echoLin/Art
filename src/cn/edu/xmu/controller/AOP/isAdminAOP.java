/**
 * @Title {filename}
 * @Package cn.edu.xmu.controller.AOP
 * @exception TODO
 * @author echo
 * @date 2015年12月18日 上午111020
 * @version V1.0
 */
package cn.edu.xmu.controller.AOP;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file isAdminAOP.java
 * @package cn.edu.xmu.controller.AOP
 * @project Art
 * @version 实现isAdmin接口
 */
@Aspect
@Component
public class isAdminAOP {
	/**
	 * 
	 * @Method aroundExec
	 * @exception 验证是否是管理员，是否有权限进行操作
	 * @param joinPoint ProceedingJoinPoint 切入点
	 * @return 
	 * @throws Throwable
	 * @author echo
	 * @time 2016年1月17日
	 */
	@Around("@annotation(cn.edu.xmu.controller.AOP.isAdmin)")
	public Object aroundExec(ProceedingJoinPoint joinPoint) throws Throwable{
		Object[] args = joinPoint.getArgs();
		HttpServletRequest request=(HttpServletRequest) args[args.length-2];
		HttpServletResponse response=(HttpServletResponse) args[args.length-1];
		HttpSession session=request.getSession();
		try{	
			if(session.getAttribute("admin") == null){
				//未登录
				throw new Exception();
			}
			//检查权限(数组)
			MethodSignature ms=(MethodSignature) joinPoint.getSignature();
			Method method=ms.getMethod();
			String role = method.getAnnotation(isAdmin.class).role();
			if(!role.equals("")){
				String[] roleList = role.split("\\|");
				boolean ret = false;
				for(int i = 0; i<roleList.length;) {
					role = "is" + roleList[i];
					if(session.getAttribute(role) != null && (boolean)session.getAttribute(role)){
						ret = true;
						break;
					}
					i++;
				}
				if(!ret){
					//权限不够
					throw new Exception();
				}
			}
		}catch(Exception e){
			try {
				request.getRequestDispatcher("/cms/login").forward(request, response);
			} catch (ServletException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return joinPoint.proceed();
	}
}
