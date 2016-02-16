package cn.edu.xmu.service.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xmu.dao.cms.LotDAO;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Lot;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file LotServiceImpl.java
 * @package cn.edu.xmu.service.cms
 * @project Art
 * @version TODO
 */
public class LotServiceImpl implements LotService{
	@Autowired
	private LotDAO lotDAO;
	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月28日 上午13926
	 */
	@Override
	public List<Lot> getLotListByIsPassed(String is_passed, String page) {
		return lotDAO.getLotByIsPasssed(is_passed, page);
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月28日 上午14113
	 */
	@Override
	public Lot getLotById(String id) {
		return lotDAO.getLotById(id);
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月28日 上午14244
	 */
	@Override
	public int getPageNumByIsPassed(String is_passed) {
		return lotDAO.getPageNumByIsPassed(is_passed);
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月28日 上午14318
	 */
	@Override
	public JSON setLotIsPassed(String id, String is_passed) {
		Lot lot = lotDAO.getLotById(id);
		lot.setIs_passed(Integer.parseInt(is_passed));
		try{
			if(lotDAO.updateLotIsPassed(lot)){
				return new JSON(INFO.Success, INFO.ActionSuccess);		
			}		
		} catch (Exception e){		
			return new JSON(INFO.Error, INFO.ActionError);
		}
		return new JSON(INFO.Error, INFO.ActionError);
		
	}

}
