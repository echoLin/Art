package cn.edu.xmu.dao.mall;

import java.util.List;

import cn.edu.xmu.entity.Category;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file CategoryDAO.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public interface CategoryDAO {
	/**
	 * 
	 * @Method getCategoryList
	 * @exception TODO
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public List<Category> getCategoryList();

	/** 
	 * @Method getCategoryById
	 * @exception TODO
	 * @param category_id
	 * @return
	 * @author Qing
	 * @time 2015年12月24日
	 */
	public Category getCategoryById(Long category_id);
}
