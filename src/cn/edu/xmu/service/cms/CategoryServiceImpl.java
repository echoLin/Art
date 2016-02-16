package cn.edu.xmu.service.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xmu.dao.cms.CategoryDAO;
import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;

/**
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file CategoryServiceImpl.java
 * @package cn.edu.xmu.service.cms
 * @project Art
 * @version TODO
 */
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDAO categoryDAO;

	/**
	 * @Override
	 * @author letitia
	 * @time 2015年12月30日 下午82820
	 */
	@Override
	public List<Category> getCategoryList(String page) {
		return categoryDAO.getCategoryList(page);
	}

	@Override
	public int getCategoryPageNum() {
		return categoryDAO.getPageNumOfCategory();
	}

	/**
	 * 
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月30日 下午93210
	 */
	@Override
	public JSON addCategory(String category) {
		boolean ret = categoryDAO.addCategory(category);
		if(ret)
			return new JSON(INFO.Success,INFO.SaveSuccess);
		else 
		    return new JSON(INFO.Error,INFO.SaveError);
	}
	
	

}
