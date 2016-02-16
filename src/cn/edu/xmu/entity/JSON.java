/**
 * @Title {filename}
 * @Package cn.edu.xmu.entity
 * @Description TODO
 * @author echo
 * @date 2015年12月18日 上午11:43:41
 * @version V1.0
 */
package cn.edu.xmu.entity;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file: JSON.java
 * @package: cn.edu.xmu.entity
 * @project: Art
 * @description: json数据返回的类
 */
public class JSON {
	private Integer Errno;
	private Object Data;
	public JSON(Integer errno, Object data) {
		super();
		Errno = errno;
		Data = data;
	}
	public Integer getErrno() {
		return Errno;
	}
	public void setErrno(Integer errno) {
		Errno = errno;
	}
	public Object getData() {
		return Data;
	}
	public void setData(Object data) {
		Data = data;
	}	
}
