/**
 * @Title {filename}
 * @Package cn.edu.xmu.dao.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月31日 上午45449
 * @version V1.0
 */
package cn.edu.xmu.dao.mall;

import java.util.List;

import cn.edu.xmu.entity.Deposit;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file DepositDAO.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public interface DepositDAO {
	public void saveOrUpdateDeposit(Deposit deposit) throws Exception;
	public Deposit getDepositByUserAndLot(Long user_id, Long lot_id);
	public List<Deposit> getDepositListByLot(Long lot_id);
	public void saveOrUpdateDepositList(List<Deposit> list) throws Exception;
}
