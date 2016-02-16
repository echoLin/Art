package cn.edu.xmu.controller.cms;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.xmu.controller.AOP.isAdmin;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Lot;
import cn.edu.xmu.entity.PUBLIC;
import cn.edu.xmu.service.cms.LotService;

/**
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file LotController.java
 * @package cn.edu.xmu.controller.cms
 * @project Art
 * @version 拍卖品审核控制器
 */
@Controller
public class LotController {
	
	@Resource(name="lotService_cms")
	private LotService lotService;
	
	/********************************* jump start *****************************/

    /**
     * 
     * @Method getArtistList
     * @exception 获取拍卖品列表
     * @param is_passed 是否通过（-1 未通过； 0 待审核； 1 审核通过）
     * @param page 页码
     * @param request 请求
     * @param response 响应
     * @return
     * @author letitia
     * @time 2015年12月28日
     */
	@RequestMapping("/cms/jsp/lotList")
	@isAdmin(role=PUBLIC.Lot_Auditor)
	public String getLotList(String is_passed, String page, HttpServletRequest request, HttpServletResponse response){
		int pageNum = lotService.getPageNumByIsPassed(is_passed);
		List<Lot> list = lotService.getLotListByIsPassed(is_passed,page);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("pageNum", pageNum);
		return "/cms/jsp/lotList";
	}
	
    /**
     * 
     * 
     * @Method getLotById
     * @exception 预览拍卖品
     * @param id 拍卖品ID
     * @param request 请求
     * @param response 响应
     * @return
     * @author letitia
     * @time 2015年12月28日
     */
	@RequestMapping("/cms/jsp/viewDetailsOfLot")
	@isAdmin(role=PUBLIC.Lot_Auditor)
	public String getLotById(String id,HttpServletRequest request, HttpServletResponse response){
		Lot lot = lotService.getLotById(id);
		request.setAttribute("lot", lot);
		return "/cms/jsp/viewDetailsOfLot";
		
	}
/********************************* jump end *******************************/
	
/********************************* json start******************************/
	

	/**
	 * 
	 * @Method setLotIsPassed
	 * @exception 设置拍卖品状态
	 * @param id 拍卖品ID
	 * @param is_passed 拍卖品是否通过（1表示通过）
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/cmsSetLotIsPassed.json")
	@ResponseBody
	public JSON setLotIsPassed(String id,String is_passed,HttpServletRequest request, HttpServletResponse response){
		return lotService.setLotIsPassed(id,is_passed);
	}
	
/********************************* json end********************************/

	


}
