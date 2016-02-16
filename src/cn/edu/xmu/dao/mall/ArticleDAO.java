package cn.edu.xmu.dao.mall;

import java.util.List;

import cn.edu.xmu.entity.Article;
import cn.edu.xmu.entity.Block;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArticleDAO.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public interface ArticleDAO {
	/**
	 * 
	 * @Method getArticleListByBlock
	 * @exception TODO
	 * @param block
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public List<Article> getArticleListByBlock(Block block);
	
	/**
	 * 
	 * @Method getArticleById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public Article getArticleById(String id);
}
