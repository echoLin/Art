/**
 * @Title {filename}
 * @Package cn.edu.xmu.controller.AOP
 * @exception TODO
 * @author echo
 * @date 2015年12月18日 上午110838
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
 * @file isAdmin.java
 * @package cn.edu.xmu.controller.AOP
 * @project Art
 * @version 检查是否是后台管理人员
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface isAdmin {
	String role() default "";
}
