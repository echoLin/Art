package cn.edu.xmu.service.mall;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.xmu.entity.Address;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.User;


/**
 * @Copyright Copyright (c) 2015 Qing
 * All rights reserved
 *
 * @file UserService.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 用户接口
 */
public interface UserService {
	
	/** 
	 * @Method addUser
	 * @exception 注册
	 * @param user
	 * @return
	 * @author Qing
	 * @time 2015年12月20日
	 */
	public boolean addUser(User user);
	
	/** 
	 * @Method login
	 * @exception 登录
	 * @param nameORtel
	 * @param password
	 * @return
	 * @author Qing
	 * @time 2015年12月20日
	 */
	public User login(String nameORtel,String password);
	/** 
	 * @Method getUserByUsername
	 * @exception get User By username
	 * @param username
	 * @return
	 * @author Qing
	 * @time 2015年12月20日
	 */
	public User getUserByUsername(String username);
	/** 
	 * @Method getUserByTelephone
	 * @exception get User by telephone
	 * @param telephone
	 * @return
	 * @author Qing
	 * @time 2015年12月20日
	 */
	public User getUserByTelephone(String telephone);
	
	/** 
	 * @Method modify_psd
	 * @exception TODO
	 * @param user
	 * @param new_psd
	 * @return
	 * @author Qing
	 * @time 2015年12月21日
	 */
	public User modify_psd(User user, String new_psd);
	
	/**
	 * 
	 * @Method saveArator
	 * @exception TODO
	 * @param file
	 * @param user
	 * @return
	 * @author echo
	 * @time 2015年12月23日
	 */
	public JSON saveAvatar(MultipartFile file, User user);

	/** 
	 * @Method saveOrUpdateUser
	 * @exception TODO
	 * @param user
	 * @return
	 * @author Qing
	 * @time 2015年12月23日
	 */
	public JSON saveOrUpdateUser(User user);
	
	/**
	 * 
	 * 
	 * @Method getAddressListByUser
	 * @exception 通过用户获取地址
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
	 * @exception 保存地址
	 * @param user
	 * @param address
	 * @return
	 * @author letitia
	 * @time 2015年12月29日
	 */
	public JSON saveOrUpdateAddress(User user, Address address);
	
	/**
	 * 
	 * 
	 * @Method deleteAddress
	 * @exception 删除地址
	 * @param user
	 * @param id
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */
	public JSON deleteAddress(Long id);
	
	/**
	 * 
	 * 
	 * @Method getAddressById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */
	public Address getAddressById(Long id);
	
	/**
	 * 
	 * 
	 * @Method modifyAddressStatus
	 * @exception 设置默认地址
	 * @param user
	 * @param addressId
	 * @param is_default
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */
	public JSON modifyAddressStatus(User user,Long addressId,Integer is_default);
	
	/**
	 * 
	 * 
	 * @Method rechargeMoney
	 * @exception 充值
	 * @param user
	 * @param addressId
	 * @param is_default
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */
	public JSON rechargeMoney(User user,String recharge);
}
