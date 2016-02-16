package cn.edu.xmu.service.mall;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.xmu.dao.mall.AddressDAO;
import cn.edu.xmu.dao.mall.UserDAO;
import cn.edu.xmu.entity.Address;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 Qing
 * All rights reserved
 *
 * @file: UserServiceImpl.java
 * @package: cn.edu.xmu.service.mall
 * @project: Art
 * @version 实现用户接口
 */
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	@Autowired
    private AddressDAO addressDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	/**
	 * @Override
	 * @author:Qing
	 * @time:2015年12月20日
	 */
	@Override
	public boolean addUser(User user) {
		try {
			return userDAO.saveOrUpdateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}




	/**
	 * @Override
	 * @author:Qing
	 * @time:2015年12月20日
	 */
	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDAO.getUserByUsername(username);
	}




	/**
	 * @Override
	 * @author:Qing
	 * @time:2015年12月20日
	 */
	@Override
	public User getUserByTelephone(String telephone) {
		// TODO Auto-generated method stub
		return userDAO.getUserByTelephone(telephone);
	}




	/**
	 * @Override
	 * @author:Qing
	 * @time:2015年12月20日
	 */
	@Override
	public User login(String nameORtel, String password) {
		// TODO Auto-generated method stub
		return userDAO.login(nameORtel, password);
	}



	/**
	 * @Override
	 * @author:Qing
	 * @time:2015年12月21日
	 */
	@Override
	public User modify_psd(User user, String new_psd) {
		// TODO Auto-generated method stub
		return userDAO.modify_psd(user,new_psd);
	}



	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月23日 上午11:48:54
	 */
	@Override
	public JSON saveAvatar(MultipartFile file, User user) {
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}
		try {
			if(file.isEmpty() || !user.uploadAvator(file)){
				return new JSON(INFO.Error, INFO.ActionError);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.ActionError);
		}
		try {
			if(!userDAO.saveOrUpdateUser(user)){
				return new JSON(INFO.Error, INFO.ActionError);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.ActionError);
		}
		return new JSON(INFO.Success, "/Art/mall/jsp/user/user");
	}




	/**
	 * @Override
	 * @author:Qing
	 * @time:2015年12月23日
	 */
	@Override
	public JSON saveOrUpdateUser(User user) {
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}
		try {
			if(!userDAO.saveOrUpdateUser(user)){
				return new JSON(INFO.Error, INFO.ActionError);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.ActionError);
		}
		return new JSON(INFO.Success, user);
	}



    /**
     * 
     * @Override
     * @author letitia
     * @time 2015年12月29日 下午1:15:15
     */
	@Override
	public List<Address> getAddressListByUser(User user) {
		return addressDAO.getAddressListByUser(user);
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月29日 下午10:59:42
	 */
	@Override
	public JSON saveOrUpdateAddress(User user, Address address) {
		boolean ret;
		try {
			address.setUser(user);
			ret = addressDAO.saveOrUpdateAddress(address);
		} catch (Exception e) {			
			e.printStackTrace();
			return new JSON(INFO.Error,INFO.SaveError);
		}
		if(ret)
			return new JSON(INFO.Success, address.getId().toString());
		else
			return new JSON(INFO.Error,INFO.SaveError);
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月30日 上午12:42:19
	 */
	@Override
	public JSON deleteAddress(Long id) {
		boolean ret;
		try {
			ret = addressDAO.deleteAddress(id);
			
		} catch (Exception e) {			
			e.printStackTrace();
			return new JSON(INFO.Error,INFO.SaveError);
		}
		if(ret)
			return new JSON(INFO.Success, id);
		else
			return new JSON(INFO.Error,INFO.SaveError);
		
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月30日 上午1:42:29
	 */
	@Override
	public Address getAddressById(Long id) {	
		return addressDAO.getAddressById(id);
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月30日 上午3:28:03
	 */
	@Override
	public JSON modifyAddressStatus(User user, Long addressId,
			Integer is_default) {
		if(user == null)//没有登录
			return new JSON(INFO.NotLogin,INFO.LoginMALL);
		
		Address address = addressDAO.getAddressById(addressId);
		
		boolean ret = true;
		if(is_default == 0)//如果要取消默认地址
		{
		   ret = userDAO.cancelDeafultAddrress(user);			   
		}
			
		if(is_default == 1)//如果要设置为默认地址
		{   
			ret = userDAO.saveOrUpdateDefaultAddress(user, address);		
		}		
		
		if(ret)
			   return new JSON(INFO.Success,INFO.SubmitSuccess);
		else
			   return new JSON(INFO.Error,INFO.SubmitError);

		
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月30日 上午3:28:03
	 */
	@Override
	public JSON rechargeMoney(User user, String recharge) {
		if(user == null)//没有登录
			return new JSON(INFO.NotLogin,INFO.LoginMALL);
		boolean ret;
		try {
			ret = userDAO.addMoney(user, recharge);
		} catch (Exception e) {
			e.printStackTrace();
			ret = false;
		}
		if(ret)
			   return new JSON(INFO.Success,INFO.SubmitSuccess);
		else
			   return new JSON(INFO.Error,INFO.SubmitError);
	}
	
}
