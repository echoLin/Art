/**
 * @Title {filename}
 * @Package cn.edu.xmu.service.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月30日 下午84238
 * @version V1.0
 */
package cn.edu.xmu.service.mall;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xmu.dao.mall.AddressDAO;
import cn.edu.xmu.dao.mall.ArtworkDAO;
import cn.edu.xmu.dao.mall.BidDAO;
import cn.edu.xmu.dao.mall.CategoryDAO;
import cn.edu.xmu.dao.mall.DepositDAO;
import cn.edu.xmu.dao.mall.LotDAO;
import cn.edu.xmu.dao.mall.OrderDAO;
import cn.edu.xmu.dao.mall.PaymentDAO;
import cn.edu.xmu.dao.mall.ShopDAO;
import cn.edu.xmu.dao.mall.UserDAO;
import cn.edu.xmu.entity.Address;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.Bid;
import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.Deposit;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Lot;
import cn.edu.xmu.entity.Order;
import cn.edu.xmu.entity.Payment;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file BuyServiceImpl.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 实现交易接口
 */
public class BuyServiceImpl implements BuyService{
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private PaymentDAO paymentDAO;
	@Autowired
	private ArtworkDAO artworkDAO;
	@Autowired
	private ShopDAO shopDAO;
	@Autowired
	private AddressDAO addressDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private LotDAO lotDAO;
	@Autowired
	private DepositDAO depositDAO;
	@Autowired
	private BidDAO bidDAO;
	
	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月30日 下午84836
	 */
	@Override
	public Artwork getArtworkById(Long id) {
		return artworkDAO.getArtworkByIdForUser(id);
	}
	
	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月30日 下午92713
	 */
	@Override
	public Payment getPaymentById(Long id, User user) {
		return paymentDAO.getPaymentByIdAndFrom(id, user);
	}
	
	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月30日 下午84836
	 */
	@Override
	public Shop getShopById(Long id) {
		return shopDAO.getShopByIdForUser(id);
	}
	
	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月30日 下午84836
	 */
	@Override
	public Lot getLotById(Long id) {
		return lotDAO.getLotByIdForUser(id);
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月30日 下午85411
	 */
	@Override
	public JSON createOrder(Long artwork_id, Long address_id, User user){
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}
		Artwork artwork = artworkDAO.getArtworkByIdForUser(artwork_id);
		if(artwork == null){
			return new JSON(INFO.Error, "没有找到该艺术品");
		}else if(artwork.getType()==-1){
			return new JSON(INFO.Error, "该艺术品是非卖品");
		}
		Address address = addressDAO.getAddressById(address_id);
		if(address == null){
			return new JSON(INFO.Error, "没有找到该地址");
		}
		
		Order order = new Order();
		order.setArtwork(artwork);
		order.setShop(artwork.getShop());
		order.setUser(user);
		order.setStatus(1);
		order.setType(artwork.getType());
		order.setTime(new Date());
		
		try {
			order = orderDAO.saveOrUpdateOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, "生成订单失败");
		}
		
		artwork.setType(1);
		try {
			artworkDAO.saveOrUpdateArtwork(artwork);
		} catch (Exception e1) {
			e1.printStackTrace();
			return new JSON(INFO.Error, "生成订单失败");
		}
		
		Payment payment = new Payment();
		payment.setFrom(user);
		payment.setTo(artwork.getShop().getArtist().getUser());
		payment.setPrice(artwork.getPrice());
		payment.setIs_pay(-1);
		payment.setTime(new Date());
		payment.setOrder(order);
		
		try {
			payment = paymentDAO.saveOrUpdatePayment(payment);
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, "生成订单失败");
		}
		
		return new JSON(INFO.Success, payment.getId());
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月30日 下午103140
	 */
	@Override
	public List<Address> getAddressListByUser(User user) {
		return addressDAO.getAddressListByUser(user);
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月31日 上午125938
	 */
	@Override
	public JSON setPay(Long payment_id, User user) {
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}
		user = userDAO.getUserByTelephone(user.getTelephone());
		Payment payment = paymentDAO.getPaymentByIdAndFrom(payment_id, user);
		if(payment == null){
			return new JSON(INFO.Error, "没有找到该支付记录");
		}
		if(payment.getIs_pay() == 1){
			return new JSON(INFO.Error, "订单已经支付");
		}
		if(payment.getPrice() > user.getMoney()){
			return new JSON(INFO.Error, "您的余额不足，请先充值");
		}
		user.subMoney(payment.getPrice());
		User to = payment.getTo();
		to.addMoney(payment.getPrice());
		payment.setIs_pay(1);
		Order order = payment.getOrder();
		order.setStatus(order.getStatus()+1);
		
		try {
			userDAO.saveOrUpdateUser(user);
			userDAO.saveOrUpdateUser(to);
			paymentDAO.saveOrUpdatePayment(payment);
			orderDAO.saveOrUpdateOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, "支付失败");
		}
		return new JSON(INFO.Success,"支付成功");
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月31日 上午34151
	 */
	@Override
	public JSON saveCustomOrder(Artwork artwork, Long category_id,
			Long shop_id, User user) {
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}
		Shop shop = shopDAO.getShopByIdForUser(shop_id);
		if(shop == null || shop.getIs_customized() != 1){
			return new JSON(INFO.Error, INFO.ActionError);
		}
		Category category = categoryDAO.getCategoryById(category_id);
		if(category == null){
			return new JSON(INFO.Error, INFO.ActionError);
		}
		artwork.setCategory(category);
		artwork.setShop(shop);
		artwork.setType(3);
		artwork.setTime(new Date());
		artwork.setCreate_time(new Date());
		artwork.setHead_url(user.getAvatar());
		
		try {
			artwork = artworkDAO.saveOrUpdateArtwork(artwork);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		Order order = new Order();
		order.setArtwork(artwork);
		order.setShop(shop);
		order.setType(3);
		order.setUser(user);
		order.setStatus(1);
		order.setTime(new Date());
		try {
			order = orderDAO.saveOrUpdateOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return new JSON(INFO.Success, INFO.ActionSuccess);
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月31日 上午45135
	 */
	@Override
	public JSON createDeposit(Long lot_id, User user) {
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}
		Lot lot = lotDAO.getLotByIdForUser(lot_id);
		if(lot == null){
			return new JSON(INFO.Error, INFO.ActionError);
		}
		if(user.getMoney() < lot.getPrice()){
			return new JSON(INFO.Error, "您的账户余额不足");
		}
		user.subMoney(lot.getPrice());
		try {
			userDAO.saveOrUpdateUser(user);
		} catch (Exception e1) {
			try {
				userDAO.mergeUser(user);
			} catch (Exception e) {
				e.printStackTrace();
				return new JSON(INFO.Error, "支付押金失败");
			}
		}
		Deposit deposit = new Deposit();
		deposit.setLot(lot);
		deposit.setPrice(lot.getPrice());
		deposit.setUser(user);
		deposit.setIs_return(-1);
		deposit.setTime(new Date());
		try {
			depositDAO.saveOrUpdateDeposit(deposit);
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, "支付押金失败");
		}
		return new JSON(INFO.Success, INFO.ActionSuccess);
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月31日 上午51007
	 */
	@Override
	public JSON createBid(Long lot_id, Double money, User user) {
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}
		Lot lot = lotDAO.getLotByIdForUser(lot_id);
		Long now = new Date().getTime();
		if(lot == null || lot.getIs_finished() == 1 || lot.getStart_time().getTime()>now){
			return new JSON(INFO.Error, "竞价记录不存在、竞价已结束或者竞价尚未开始");
		}
		if(lot.getIs_finished() == -1 && lot.getEnd_time().getTime()<now){
			//触发竞拍的结束
			try {
				createLotOrder(lot_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new JSON(INFO.Error, "竞拍已结束");
		}
		Deposit deposit = depositDAO.getDepositByUserAndLot(user.getUserid(), lot_id);
		if(deposit == null){
			return new JSON(INFO.JumpTo, "/Art/mall/jsp/buy/deposit?lot_id="+lot_id);
		}
		if(lot.getNow_price()>money){
			return new JSON(INFO.Error, "您的叫价低于当前最高价");
		}
		lot.setNow_price(money);
		lot.setUser(user);
		try {
			lotDAO.saveOrUpdateLot(lot);
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.ActionError);
		}
		
		Bid bid = new Bid();
		bid.setLot(lot);
		bid.setPrice(money);
		bid.setUser(user);
		bid.setTime(new Date());
		try {
			bidDAO.saveOrUpdateBid(bid);
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.ActionError);
		}
		return new JSON(INFO.Success, INFO.ActionSuccess);
	}
	
	/**
	 * 
	 * @Method createLotOrder
	 * @exception 生成拍卖订单
	 * @param lot_id
	 * @return
	 * @throws Exception
	 * @author echo
	 * @time 2015年12月31日
	 */
	private boolean createLotOrder(Long lot_id) throws Exception{
		Lot lot = lotDAO.getLotByIdForUser(lot_id);
		lot.setIs_finished(1);
		lotDAO.saveOrUpdateLot(lot);
		List<Deposit> list = depositDAO.getDepositListByLot(lot_id);
		List<User> userList = new ArrayList<User>();
		for(int i = 0; i<list.size(); i++){
			User u = list.get(i).getUser();
			if(u.getUserid() != lot.getUser().getUserid()){
				u.addMoney(list.get(i).getPrice());
				list.get(i).setIs_return(1);
				userList.add(u);
			}
		}
		userDAO.saveOrUpdateList(userList);
		depositDAO.saveOrUpdateDepositList(list);
		
		Order order = new Order();
		order.setArtwork(lot.getArtwork());
		order.setShop(lot.getArtwork().getShop());
		order.setStatus(1);
		order.setType(lot.getArtwork().getType());
		order.setUser(lot.getUser());
		order.setTime(new Date());
		order = orderDAO.saveOrUpdateOrder(order);
		Payment payment = new Payment();
		payment.setFrom(lot.getUser());
		payment.setTo(lot.getArtwork().getShop().getArtist().getUser());
		payment.setPrice(lot.getNow_price());
		payment.setTime(new Date());
		paymentDAO.saveOrUpdatePayment(payment);
		
		return true;
	}
	
}
