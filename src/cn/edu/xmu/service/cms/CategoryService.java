package cn.edu.xmu.service.cms;

import java.util.List;

import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.JSON;

/**
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file CategoryService.java
 * @package cn.edu.xmu.service.cms
 * @project Art
 * @version TODO
 */
public interface CategoryService {
	
	/**
	 * 
	 * 
	 * @Method getCategoryList
	 * @exception 通过页码获取标签列表
	 * @param page
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */
	public List<Category> getCategoryList(String page);
	
	/**
	 * 
	 * 
	 * @Method getCategoryPageNum
	 * @exception TODO
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */
	public int getCategoryPageNum();
	
	/**
	 * 
	 * 
	 * @Method addCategory
	 * @exception 新增一个类别
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */
	public JSON addCategory(String category);

}
