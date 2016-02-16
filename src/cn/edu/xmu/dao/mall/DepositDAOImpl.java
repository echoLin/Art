/**
 * @Title {filename}
 * @Package cn.edu.xmu.dao.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月31日 上午45501
 * @version V1.0
 */
package cn.edu.xmu.dao.mall;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Deposit;
import cn.edu.xmu.entity.Lot;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file DepositDAOImpl.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public class DepositDAOImpl implements DepositDAO{
	
	SessionFactory sessionFactory;
	
	/**
	 * 
	 * @Method setSessionFactory
	 * @exception TODO
	 * @param sessionFactory
	 * @author echo
	 * @time 2015年12月19日
	 */
	public void setSessionFactory(SessionFactory sessionFactory) throws Exception{
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月31日 上午45708
	 */
	@Override
	public void saveOrUpdateDeposit(Deposit deposit) {
		sessionFactory.getCurrentSession().saveOrUpdate(deposit);
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月31日 上午45708
	 */
	@Override
	public Deposit getDepositByUserAndLot(Long user_id, Long lot_id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Deposit.getDepositByUserAndLot");
		User user = new User();
		user.setUserid(user_id);
		Lot lot = new Lot();
		lot.setId(lot_id);
		query.setParameter("user", user);
		query.setParameter("lot", lot);
		return (Deposit) query.uniqueResult();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月31日 上午75146
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Deposit> getDepositListByLot(Long lot_id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Deposit.getDepositListByLot");
		Lot lot = new Lot();
		lot.setId(lot_id);
		query.setParameter("lot", lot);
		return query.list();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月31日 上午80332
	 */
	@Override
	public void saveOrUpdateDepositList(List<Deposit> list) throws Exception{
		for(int i = 0; i<list.size(); i++){
			try{
				this.saveOrUpdateDeposit(list.get(i));
			}catch(Exception e){
				sessionFactory.getCurrentSession().merge(list.get(i));
			}
		}
	}

}
