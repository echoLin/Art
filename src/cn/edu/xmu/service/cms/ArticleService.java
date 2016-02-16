package cn.edu.xmu.service.cms;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.xmu.entity.Admin;
import cn.edu.xmu.entity.Article;
import cn.edu.xmu.entity.Block;
import cn.edu.xmu.entity.JSON;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArticleService.java
 * @package cn.edu.xmu.service.cms
 * @project Art
 * @version 后台资讯管理Service
 */
public interface ArticleService {
	/**
	 * 
	 * @Method getBlockList
	 * @exception 获取资讯模块列表
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	public List<Block> getBlockList();
	/**
	 * 
	 * @Method getPageNumByEditorAndStatus
	 * @exception 根据资讯状态和采编获取当前资讯的页数
	 * @param editor
	 * @param status
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	public int getPageNumByEditorAndStatus(Admin editor, String status);
	/**
	 * 
	 * @Method getArticleListByEditorAndStatus
	 * @exception 根据资讯状态、采编和页码获取资讯列表
	 * @param editor
	 * @param status
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	public List<Article> getArticleListByEditorAndStatus(Admin editor, String status, String page);
	/**
	 * 
	 * @Method getPageNumByStatus
	 * @exception 根据资讯状态获取资讯页数
	 * @param status
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	public int getPageNumByStatus(String status);
	/**
	 * 
	 * @Method getArticleListByStatus
	 * @exception 根据资讯状态获取资讯列表
	 * @param status
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	public List<Article> getArticleListByStatus(String status, String page);
	/**
	 * 
	 * @Method saveArticle
	 * @exception 保存资讯
	 * @param article
	 * @param editor
	 * @param block_id
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	public JSON saveArticle(Article article, Admin editor, String block_id);
	
	/**
	 * 
	 * @Method deleteArticle
	 * @exception 删除资讯
	 * @param article
	 * @param editor
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	public JSON deleteArticle(Article article, Admin editor);
	/**
	 * 
	 * @Method setArticleStatus
	 * @exception 更改资讯的状态
	 * @param id
	 * @param status
	 * @param admin
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	public JSON setArticleStatus(String id, String status, Admin admin);
	/**
	 * 
	 * @Method addImage
	 * @exception TODO
	 * @param file
	 * @param admin
	 * @return
	 * @author echo
	 * @time 2015年12月26日
	 */
	public JSON addImage(MultipartFile file, Admin admin);
	/**
	 * 
	 * @Method getArticleById
	 * @exception 根据文章id获取文章
	 * @param id
	 * @param admin
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	public JSON getArticleById(String id, Admin admin);
}
