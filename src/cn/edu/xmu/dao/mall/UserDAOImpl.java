package cn.edu.xmu.dao.mall;


import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.edu.xmu.entity.Address;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 Qing
 * All rights reserved
 *
 * @file UserDAOImpl.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public class UserDAOImpl implements UserDAO{

	SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月20日
	 */
	@Override
	public boolean saveOrUpdateUser(User user) throws Exception{
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}



	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月20日
	 */
	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("User.getUserByUsername");
		query.setParameter("username", username);
		return (User) query.uniqueResult();
	}



	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月20日
	 */
	@Override
	public User getUserByTelephone(String telephone) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("User.getUserByTelephone");
		query.setParameter("telephone", telephone);
		return (User) query.uniqueResult();
	}



	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月20日
	 */
	@Override
	public User login(String nameORtel, String password) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("User.login");
		query.setParameter("username", nameORtel);
		query.setParameter("password", password);
		query.setParameter("telephone", nameORtel);
		return (User) query.uniqueResult();
	}



	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月21日
	 */
	@Override
	public User modify_psd(User user, String new_psd) {
		// TODO Auto-generated method stub
		user.setPassword(new_psd);
		sessionFactory.getCurrentSession().update(user);
		return user;
	}



	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月25日
	 */
	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		//Session session=sessionFactory.openSession();
		//Session session=sessionFactory.getCurrentSession();
		//Transaction ts=session.beginTransaction();
		//User user2 = (User)session.get(User.class, user.getUserid());
		/*session.delete(user);
		ts.commit();
		return true;*/
		/* try {
			  //session.flush();
		      session.delete(user2); 
		      ts.commit(); //事物必须提交 
		   } catch (Exception ef) { 
		      if (null != ts) { 
		         ts.rollback();//撤销事务 
		         ef.printStackTrace(); 
		      } 
		   } finally{
			   session.close();
		   }*/
		 //session.close();
		sessionFactory.getCurrentSession().delete(user);
		 return true;
	}


    /**
     * 
     * @Override
     * @author letitia
     * @time 2015年12月30日 上午34036
     */
	@Override
	public boolean saveOrUpdateDefaultAddress(User user,Address address) {
		user.setAddress(address);
		user = (User) sessionFactory.getCurrentSession().merge(user);
		sessionFactory.getCurrentSession().update(user);
		return true;
	}


    /**
     * 
     * @Override
     * @author letitia
     * @time 2015年12月30日 上午35951
     */
	@Override
	public boolean cancelDeafultAddrress(User user) {
		user.setAddress(null);
		user = (User) sessionFactory.getCurrentSession().merge(user);
		sessionFactory.getCurrentSession().update(user);
		//System.out.println("userDAO user-addressid"+user.getAddress().getId());
		return true;
	}



	@Override
	public boolean addMoney(User user, String recharge) throws Exception{
		user.addMoney(Double.parseDouble(recharge));
		sessionFactory.getCurrentSession().update(user);
		return true;
	}
	
	@Override
	public boolean subMoney(User user, String recharge) throws Exception{
		user.subMoney(Double.parseDouble(recharge));
		sessionFactory.getCurrentSession().update(user);
		return true;
	}



	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月31日 上午61535
	 */
	@Override
	public void mergeUser(User user) throws Exception {
		sessionFactory.getCurrentSession().merge(user);
	}



	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月31日 上午75849
	 */
	@Override
	public void saveOrUpdateList(List<User> list) throws Exception {
		for(int i = 0; i<list.size(); i++){
			try{
				this.saveOrUpdateUser(list.get(i));
			}catch(Exception e){
				this.mergeUser(list.get(i));
			}
		}
	}

}
