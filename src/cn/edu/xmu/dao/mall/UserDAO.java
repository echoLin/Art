package cn.edu.xmu.dao.mall;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Address;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 Qing
 * All rights reserved
 *
 * @file UserDAO.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public interface UserDAO {

	/** 
	 * @Method addUser
	 * @exception 注册
	 * @param user
	 * @return
	 * @author Qing
	 * @time 2015年12月20日
	 */
	public boolean saveOrUpdateUser(User user) throws Exception;
	
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
	 * @exception get User by username
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
	 * @exception 修改密码
	 * @param user
	 * @param new_psd
	 * @return
	 * @author Qing
	 * @time 2015年12月21日
	 */
	public User modify_psd(User user, String new_psd);

	/** 
	 * @Method deleteUser
	 * @exception TODO
	 * @param user
	 * @author Qing
	 * @time 2015年12月25日
	 */
	public boolean deleteUser(User user);

	/** 
	 * @Method getSession
	 * @exception TODO
	 * @return
	 * @author Qing
	 * @time 2015年12月26日
	 */
	public SessionFactory getSessionFactory();
	
	/**
	 * 
	 * 
	 * @Method saveOrUpdateDefaultAddress
	 * @exception 设为默认地址
	 * @param address
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */
	public boolean saveOrUpdateDefaultAddress(User user,Address address);
	
	/**
	 * 
	 * 
	 * @Method cancelDeafultAddrress
	 * @exception 取消默认地址
	 * @param address
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */
	public boolean cancelDeafultAddrress(User user);
	
	/**
	 * 
	 * @Method addMoney
	 * @exception 充值
	 * @param user
	 * @param recharge
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	public boolean addMoney(User user,String recharge) throws Exception;
	
	/**
	 * 
	 * @Method subMoney
	 * @exception 扣款
	 * @param user
	 * @param recharge
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	public boolean subMoney(User user, String recharge) throws Exception;
	
	/**
	 * 
	 * @Method mergeUser
	 * @exception TODO
	 * @param user
	 * @throws Exception
	 * @author echo
	 * @time 2015年12月31日
	 */
	public void mergeUser(User user) throws Exception;
	
	/**
	 * 
	 * @Method saveOrUpdateList
	 * @exception TODO
	 * @param list
	 * @throws Exception
	 * @author echo
	 * @time 2015年12月31日
	 */
	public void saveOrUpdateList(List<User> list) throws Exception;

}
