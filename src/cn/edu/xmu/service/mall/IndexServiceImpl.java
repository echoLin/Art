package cn.edu.xmu.service.mall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xmu.dao.mall.ArticleDAO;
import cn.edu.xmu.dao.mall.BlockDAO;
import cn.edu.xmu.entity.Article;
import cn.edu.xmu.entity.Block;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file IndexServiceImpl.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 实现首页接口
 */
public class IndexServiceImpl implements IndexService{
	
	@Autowired
	private ArticleDAO articleDAO;
	@Autowired
	private BlockDAO blockDAO;

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午100106
	 */
	@Override
	public List<Article> getArticleList(Integer id) {
		Block block = blockDAO.getBlockById(id);
		return articleDAO.getArticleListByBlock(block);
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午100110
	 */
	@Override
	public Article getArticleById(String id) {
		return articleDAO.getArticleById(id);
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午100113
	 */
	@Override
	public List<Block> getBlockList() {
		return blockDAO.getBlockList();
	}

}
