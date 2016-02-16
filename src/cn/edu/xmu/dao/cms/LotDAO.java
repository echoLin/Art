package cn.edu.xmu.dao.cms;

import java.util.List;

import cn.edu.xmu.entity.Lot;

/**
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file LotDAO.java
 * @package cn.edu.xmu.dao.cms
 * @project Art
 * @exception TODO
 */
public interface LotDAO {
	
	/**
	 * 
	 * 
	 * @Method getLotByIsPasssed
	 * @exception 获取不同状态的拍卖品的列表
	 * @param type
	 * @param is_passed
	 * @return 
	 * @author letitia
	 * @time 2015年12月28日
	 */
    public List<Lot> getLotByIsPasssed(String is_passed,String page);
	
	/**
	 * 
	 * 
	 * @Method getLotById
	 * @exception 获取单个艺术拍品
	 * @param id
	 * @return
	 * @author letitia
	 * @time 2015年12月28日
	 */
	public Lot getLotById(String id);
	
	/**
	 * 
	 * 
	 * @Method getPageNumByIsPassed
	 * @exception 通过不通的状态获取页表
	 * @param is_passed
	 * @return
	 * @author letitia
	 * @time 2015年12月28日
	 */
	public int getPageNumByIsPassed(String is_passed);
	
	/**
	 *  
	 * @Method updateLotIspassed
	 * @exception 更新拍卖品的审核状态
	 * @param id
	 * @return
	 * @author letitia
	 * @time 2015年12月28日
	 */
	public boolean updateLotIsPassed(Lot lot);

}
