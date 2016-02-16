package cn.edu.xmu.dao.cms;

import java.util.List;

import cn.edu.xmu.entity.Admin;
import cn.edu.xmu.entity.Article;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArticleDAO.java
 * @package cn.edu.xmu.dao.cms
 * @project Art
 * @exception TODO
 */
public interface ArticleDAO {
	/**
	 * 
	 * @Method saveOrUpdateArticle
	 * @exception 保存或更新资讯
	 * @param article
	 * @return
	 * @throws Exception
	 * @author echo
	 * @time 2015年12月19日
	 */
	public boolean saveOrUpdateArticle(Article article) throws Exception;
	
	/**
	 * 
	 * @Method getPageNumByEditorAndStatus
	 * @exception TODO
	 * @param editor
	 * @param status
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public int getPageNumByEditorAndStatus(Admin editor, String status);
	
	/**
	 * 
	 * @Method getPageNumByStatus
	 * @exception TODO
	 * @param status
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public int getPageNumByStatus(String status);
	
	/**
	 * 
	 * @Method getArticleListByEditorAndStatus
	 * @exception TODO
	 * @param editor
	 * @param status
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public List<Article> getArticleListByEditorAndStatus(Admin editor, String status, String page);
	
	/**
	 * 
	 * @Method getArticleListStatus
	 * @exception TODO
	 * @param status
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public List<Article> getArticleListStatus(String status, String page);
	
	/**
	 * 
	 * @Method deleteArticle
	 * @exception TODO
	 * @param article
	 * @return
	 * @throws Exception
	 * @author echo
	 * @time 2015年12月19日
	 */
	public boolean deleteArticle(Article article) throws Exception;
	
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
