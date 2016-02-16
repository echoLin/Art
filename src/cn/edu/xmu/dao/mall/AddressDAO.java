package cn.edu.xmu.dao.mall;

import java.util.List;

import cn.edu.xmu.entity.Address;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.User;

/**
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file AddressDAO.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @version TODO
 */
public interface AddressDAO {
	
	/**
	 * 
	 * 
	 * @Method getAddressListByUser
	 * @exception 通过用户获取地址列表
	 * @param user
	 * @return
	 * @author letitia
	 * @time 2015年12月29日
	 */
	public List<Address> getAddressListByUser(User user);
	
	/**
	 * 
	 * 
	 * @Method saveOrUpdateAddress
	 * @exception 保存一个地址
	 * @param user
	 * @return
	 * @author letitia
	 * @time 2015年12月29日
	 */
	public boolean saveOrUpdateAddress(Address address) throws Exception;
	
	/**
	 * 
	 * 
	 * @Method deleteAddress
	 * @exception 删除地址
	 * @param id
	 * @return
	 * @throws Exception
	 * @author letitia
	 * @time 2015年12月30日
	 */
	public boolean deleteAddress(Long id) throws Exception; 
	
	/**
	 * 
	 * 
	 * @Method getAddressByIs
	 * @exception TODO
	 * @param id
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */
	public Address getAddressById(Long id);
	

}
