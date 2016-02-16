package cn.edu.xmu.service.cms;

import java.util.List;

import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Lot;

/**
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file LotService.java
 * @package cn.edu.xmu.service.cms
 * @project Art
 * @version TODO
 */
public interface LotService {
	
	
	/**
	 * 
	 * @Method getLotListByIsPassed
	 * @exception 通过页码和状态获取拍卖品列表
	 * @param is_passed
	 * @return
	 * @author letitia
	 * @time 2015年12月28日
	 */
	public List<Lot> getLotListByIsPassed(String is_passed, String page);
	
	/**
	 * 
	 * @Method getLotById
	 * @exception 通过id获取单个Lot
	 * @param id
	 * @return
	 * @author letitia
	 * @time 2015年12月28日
	 */
	public Lot getLotById(String id);
	
	/**
	 *  
	 * @Method getPageNumByIsPassed
	 * @exception 通过状态获取获取页码
	 * @param is_passed
	 * @return
	 * @author letitia
	 * @time 2015年12月28日
	 */
	public int getPageNumByIsPassed(String is_passed);
	
	/**
	 * 
	 * @Method setLotIsPassed
	 * @exception 更改拍卖品的审核状态
	 * @param id
	 * @param is_passed
	 * @return
	 * @author letitia
	 * @time 2015年12月28日
	 */
	public JSON setLotIsPassed(String id, String is_passed);

}
