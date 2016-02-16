package cn.edu.xmu.controller.cms;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.edu.xmu.controller.AOP.isAdmin;
import cn.edu.xmu.entity.Admin;
import cn.edu.xmu.entity.Article;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.PUBLIC;
import cn.edu.xmu.service.cms.ArticleService;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArticleController.java
 * @package cn.edu.xmu.controller.cms
 * @project Art
 * @version 后台资讯管理控制器
 */
@Controller
public class ArticleController {
	
	@Resource(name="articleService_cms")
	private ArticleService articleService;
	
/********************************* jump start *****************************/
	
	/**
	 * 
	 * @Method toSummernote
	 * @exception 跳转到资讯编辑页面
	 * @param id 资讯id
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	@RequestMapping("/cms/jsp/summernote")
	@isAdmin(role=PUBLIC.Editor)
	public String toSummernote(String id, HttpServletRequest request, HttpServletResponse response){
		//1.获取模块
		request.setAttribute("blockList", articleService.getBlockList());
		//2.返回id
		request.setAttribute("article_id", id);
		return "/cms/jsp/summernote";
	}
	
	/**
	 * 
	 * @Method getArticleListOfEditor
	 * @exception 跳转到采编的资讯列表
	 * @param status 资讯状态值
	 * @param page 资讯页码
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	@RequestMapping("/cms/jsp/articleListOfEditor")
	@isAdmin(role=PUBLIC.Editor)
	public String getArticleListOfEditor(String status, String page, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		List<Article> list = articleService.getArticleListByEditorAndStatus(admin, status, page);
		request.setAttribute("pageNum", articleService.getPageNumByEditorAndStatus(admin, status));
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		return "/cms/jsp/articleListOfEditor";
	}
	
	/**
	 * 
	 * @Method getArticleListOfChiefEditor
	 * @exception 跳转到主编的资讯页面
	 * @param status 资讯状态值
	 * @param page 资讯页码
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	@RequestMapping("/cms/jsp/articleListOfChiefEditor")
	@isAdmin(role=PUBLIC.Chief_Editor)
	public String getArticleListOfChiefEditor(String status, String page, HttpServletRequest request, HttpServletResponse response){
		int pageNum = articleService.getPageNumByStatus(status);
		List<Article> list = articleService.getArticleListByStatus(status, page);
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("page", page);
		return "/cms/jsp/articleListOfChiefEditor";
	}
	
	/**
	 * 
	 * @Method previewArticle
	 * @exception 预览资讯
	 * @param id 资讯id
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	@RequestMapping("/cms/jsp/previewArticle")
	@isAdmin(role=PUBLIC.Editor+"|"+PUBLIC.Chief_Editor)
	public String previewArticle(String id, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		JSON json = articleService.getArticleById(id, admin);
		if(json.getErrno() == 0){
			request.setAttribute("article", json.getData());
		}
		return "/cms/jsp/previewArticle";
	}
	
/********************************* jump end *******************************/
	
/********************************* json start******************************/
	
	/**
	 * 
	 * @Method saveArticle
	 * @exception 保存资讯
	 * @param article 资讯
	 * @param block_id 模块id
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2015年12月18日
	 */
	@RequestMapping("/cmsSaveArticle.json")
	@ResponseBody
	public JSON saveArticle(Article article, String block_id, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		JSON json  = articleService.saveArticle(article, admin, block_id);
		return json;
	}
	
	/**
	 * 
	 * @Method deleteArticle
	 * @exception 删除草稿
	 * @param article 资讯
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2015年12月18日
	 */
	@RequestMapping("/cmsDeleteArticle.json")
	@ResponseBody
	public JSON deleteArticle(Article article, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		return articleService.deleteArticle(article, admin);
	}
	
	/**
	 * 
	 * @Method getArticle
	 * @exception 获取资讯
	 * @param id 资讯id
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2015年12月18日
	 */
	@RequestMapping("/cmsGetArticle.json")
	@ResponseBody
	public JSON getArticle(String id, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		return articleService.getArticleById(id, admin);
	}
	
	/**
	 * 
	 * @Method submitArticle
	 * @exception 提交资讯
	 * @param id 资讯id
	 * @param status 资讯状态值
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/cmsSetArticleStatus.json")
	@ResponseBody
	public JSON submitArticle(String id, String status, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		return articleService.setArticleStatus(id, status, admin);
	}
	
	/**
	 * 
	 * @Method uploadImage
	 * @exception 上传资讯图片
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/cmsUploadImg")
	@ResponseBody
	public JSON uploadImage(HttpServletRequest request, HttpServletResponse response){
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
		// 获得上传的文件（根据前台的name名称得到上传的文件）
		// MultiValueMap<String, MultipartFile> multiValueMap = multipartRequest.getMultiFileMap();
		// List<MultipartFile> file = multiValueMap.get("imgFile");
        MultipartFile file = multipartRequest.getFile("file_data");  
        //在这里就可以对file进行处理了，可以根据自己的需求把它存到数据库或者服务器的某个文件夹  
        HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
        return articleService.addImage(file, admin);
	}
	
/********************************* json end********************************/

}
