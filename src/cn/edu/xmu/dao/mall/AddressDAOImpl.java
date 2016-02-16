package cn.edu.xmu.dao.mall;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Address;
import cn.edu.xmu.entity.User;

/**
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file AddressDAOImpl.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public class AddressDAOImpl implements AddressDAO {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月29日 下午10736
	 */
	@Override
	public List<Address> getAddressListByUser(User user) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Address.getAddressByUserAndNotDelete");
		query.setParameter("user", user);
		return query.list();
	}
 
	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月30日 上午14358
	 */
	@Override
	public boolean saveOrUpdateAddress(Address address) throws Exception{
     	sessionFactory.getCurrentSession().saveOrUpdate(address);
     	return true;
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月30日 上午14404
	 */
	@Override
	public boolean deleteAddress(Long id) throws Exception {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Address.getAddressById");
		query.setParameter("id", id);
		Address address = (Address)query.uniqueResult();
		address.setIs_delete(1);
		sessionFactory.getCurrentSession().saveOrUpdate(address);;
		return true;
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月30日 上午14410
	 */
	@Override
	public Address getAddressById(Long id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Address.getAddressById");
		query.setParameter("id", id);
		Address address = (Address)query.uniqueResult();
		return address;
	}
  

}
