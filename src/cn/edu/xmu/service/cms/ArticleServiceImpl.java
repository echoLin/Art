package cn.edu.xmu.service.cms;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.xmu.dao.cms.ArticleDAO;
import cn.edu.xmu.dao.cms.BlockDAO;
import cn.edu.xmu.entity.Admin;
import cn.edu.xmu.entity.Article;
import cn.edu.xmu.entity.Block;
import cn.edu.xmu.entity.PUBLIC;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArticleServiceImpl.java
 * @package cn.edu.xmu.service.cms
 * @project Art
 * @version 后台资讯管理Service接口实现类
 */
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDAO articleDAO;
	@Autowired
	private BlockDAO blockDAO;
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月18日 下午15840
	 */
	@Override
	public List<Block> getBlockList(){
		return blockDAO.getBlockList();
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月18日 下午15846
	 */
	@Override
	public int getPageNumByStatus(String status) {
		return articleDAO.getPageNumByStatus(status);
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月18日 下午15910
	 */
	@Override
	public int getPageNumByEditorAndStatus(Admin editor, String status) {
		return articleDAO.getPageNumByEditorAndStatus(editor, status);
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月18日 下午15852
	 */
	@Override
	public List<Article> getArticleListByStatus(String status, String page) {
		return articleDAO.getArticleListStatus(status, page);
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月18日 下午15856
	 */
	@Override
	public JSON saveArticle(Article article, Admin editor, String block_id){
		if(editor == null){
			return new JSON(INFO.NotLogin, INFO.LoginCMS);
		}
		if(article.getId() == null){
			article.setEditor(editor);
			article.setTime(new Date());
		}
		Block block = new Block();
		block.setId(Integer.parseInt(block_id));
		article.setBlock(block);
		boolean ret;
		try {
			ret = articleDAO.saveOrUpdateArticle(article);
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.SaveError);
		}
		if(ret){
			return new JSON(INFO.Success, article.getId().toString());
		}else{
			return new JSON(INFO.Error, INFO.SaveError);
		}
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月18日 下午15859
	 */
	@Override
	public JSON deleteArticle(Article article, Admin editor) {
		if(editor == null){
			return new JSON(INFO.NotLogin, INFO.LoginCMS);
		}
		article = articleDAO.getArticleById(article.getId().toString());
		if(article.getStatus()!=1){
			return new JSON(INFO.Error, INFO.NotDraft);
		}else if(article.getEditor().getId() != editor.getId()){
			return new JSON(INFO.Error, INFO.NotYoursDraft);
		}
		boolean ret;
		try {
			ret = articleDAO.deleteArticle(article);
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.DeleteError);
		}
		if(ret){
			return new JSON(INFO.Success, INFO.DeleteSuccess);
		}else{
			return new JSON(INFO.Error, INFO.DeleteError);
		}
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月18日 下午15903
	 */
	@Override
	public JSON setArticleStatus(String id, String status, Admin admin) {
		if(admin == null){
			return new JSON(INFO.NotLogin, INFO.LoginCMS);
		}
		Article article = articleDAO.getArticleById(id);
		if(status == "2"){//采编提交审核
			if(article.getStatus()!=1 && article.getStatus()!=3){
				return new JSON(INFO.Error, INFO.CannotSubmitArticle);
			}else if(article.getEditor().getId() != admin.getId()){
				return new JSON(INFO.Error, INFO.NotYourArticle);
			}
		}else if(status=="3" || status=="4" || status=="-1"){//主编设置资讯状态
			if(article.getStatus()!=2){
				return new JSON(INFO.Error, INFO.CannotDoIt);
			}
			article.setChief_editor(admin);
		}
		article.setStatus(Integer.parseInt(status));
		try {
			if(articleDAO.saveOrUpdateArticle(article)){
				return new JSON(INFO.Success, INFO.ActionSuccess);
			}
		} catch (Exception e) {
		}
		return new JSON(INFO.Error, INFO.ActionError);
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月18日 下午15906
	 */
	@Override
	public List<Article> getArticleListByEditorAndStatus(Admin editor, String status, String page) {
		return articleDAO.getArticleListByEditorAndStatus(editor, status, page);
	}

	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月18日 下午15936
	 */
	@Override
	public JSON addImage(MultipartFile file, Admin admin) {
		if(admin == null){
			return new JSON(INFO.NotLogin, INFO.LoginCMS);
		}
		if(file.isEmpty()){
			return new JSON(INFO.Error, "图片不能为空");
		}
		String url = null;
	   try {
		   url = Article.uploadImage(file);
		} catch (IOException e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.ActionError);
		}
	   return new JSON(INFO.Success, url);
	}
	
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月18日 下午20014
	 */
	@Override
	public JSON getArticleById(String id, Admin admin) {

		if(admin == null){
			return new JSON(INFO.NotLogin, INFO.LoginCMS);
		}
		Article article = articleDAO.getArticleById(id);
		if(article == null){
			return new JSON(INFO.Error, INFO.ActionError);
		}
		return new JSON(INFO.Success, article);
	}
	
}
