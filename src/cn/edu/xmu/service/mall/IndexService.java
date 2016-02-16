package cn.edu.xmu.service.mall;

import java.util.List;

import cn.edu.xmu.entity.Article;
import cn.edu.xmu.entity.Block;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file IndexService.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 首页接口
 */
public interface IndexService {
	
	/**
	 * 
	 * @Method getArticleList
	 * @exception TODO
	 * @param block_id
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public List<Article> getArticleList(Integer block_id);
	
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
	
	/**
	 * 
	 * @Method getBlockList
	 * @exception TODO
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public List<Block> getBlockList();
}
