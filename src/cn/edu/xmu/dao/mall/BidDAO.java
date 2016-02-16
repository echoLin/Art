/**
 * @Title {filename}
 * @Package cn.edu.xmu.dao.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月31日 上午51626
 * @version V1.0
 */
package cn.edu.xmu.dao.mall;

import cn.edu.xmu.entity.Bid;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file BidDAO.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public interface BidDAO {
	public void saveOrUpdateBid(Bid bid) throws Exception;
}
