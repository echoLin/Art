package cn.edu.xmu.dao.mall;

import java.util.List;

import cn.edu.xmu.entity.Block;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file BlockDAO.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public interface BlockDAO {
	/**
	 * 
	 * @Method getBlockById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public Block getBlockById(Integer id);
	
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
