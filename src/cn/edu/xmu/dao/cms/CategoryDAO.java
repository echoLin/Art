package cn.edu.xmu.dao.cms;

import java.util.List;

import cn.edu.xmu.entity.Category;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file CategoryDAO.java
 * @package cn.edu.xmu.dao.cms
 * @project Art
 * @exception TODO
 */
public interface CategoryDAO{
	/**
	 * 
	 * @Method saveOrUpdateCategory
	 * @exception TODO
	 * @param category
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public boolean saveOrUpdateCategory(Category category);
	
	/**
	 * 
	 * @Method getCategoryList
	 * @exception TODO
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public List<Category> getCategoryList(String page);
	
	/**
	 * 
	 * @Method getPageNumOfCategory
	 * @exception TODO
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public Integer getPageNumOfCategory();
	
	/**
	 * 
	 * 
	 * @Method addCategory
	 * @exception 添加一个标签
	 * @param category
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */
	public boolean addCategory(String category);
}
