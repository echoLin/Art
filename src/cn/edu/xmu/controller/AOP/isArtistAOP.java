/**
 * @Title {filename}
 * @Package cn.edu.xmu.controller.AOP
 * @exception TODO
 * @author echo
 * @date 2015骞�2鏈�8鏃�涓婂崍111427
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

import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file isArtistAOP.java
 * @package cn.edu.xmu.controller.AOP
 * @project Art
 * @version 实现检查是否是艺术家
 */
@Aspect
@Component
public class isArtistAOP {
	/**
	 * 
	 * @Method aroundExec
	 * @exception 验证是否是艺术家，是否有权限进行操作
	 * @param joinPoint ProceedingJoinPoint 切入点
	 * @return
	 * @throws Throwable
	 * @author echo
	 * @time 2016年1月17日
	 */
	@Around("@annotation(cn.edu.xmu.controller.AOP.isArtist)")
	public Object aroundExec(ProceedingJoinPoint joinPoint) throws Throwable{
		Object[] args = joinPoint.getArgs();
		HttpServletRequest request=(HttpServletRequest) args[args.length-2];
		HttpServletResponse response=(HttpServletResponse) args[args.length-1];
		HttpSession session=request.getSession();
		try{	
			User user = (User) session.getAttribute("user");
			if(user == null){			
				throw new Exception();
			}
			/*if(user.getArtist() == null || user.getArtist().getStatus()!=1){
				request.getRequestDispatcher("/mall/jsp/artist/apply").forward(request, response);
			}*/
			if(user.getArtist()==null){
				request.getRequestDispatcher("/mall/jsp/artist/apply").forward(request, response);
			}
			else if(user.getArtist().getStatus()==0){
				request.getRequestDispatcher("/mall/jsp/artist/applying").forward(request, response);
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
