/**
 * @Title {filename}
 * @Package cn.edu.xmu.controller.AOP
 * @exception TODO
 * @author echo
 * @date 2015年12月18日 上午111201
 * @version V1.0
 */
package cn.edu.xmu.controller.AOP;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file isUser.java
 * @package cn.edu.xmu.controller.AOP
 * @project Art
 * @version 检查是否是普通用户,不是跳转到登录界面
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface isUser {
}
