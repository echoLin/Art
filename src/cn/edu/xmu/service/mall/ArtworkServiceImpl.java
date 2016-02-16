/**
 * 
 */
package cn.edu.xmu.service.mall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xmu.dao.mall.ArtworkDAO;
import cn.edu.xmu.dao.mall.LotDAO;
import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Lot;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 Qing
 * All rights reserved
 *
 * @file ArtworkServiceImpl.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version TODO
 */
public class ArtworkServiceImpl implements ArtworkService{

	@Autowired
	private ArtworkDAO artworkDAO;
	@Autowired
	private LotDAO lotDAO;


	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月29日
	 */
	@Override
	public List<Artwork> getArtworkListByShopAndTypeForArtist(Shop shop, Integer type) {
		// TODO Auto-generated method stub
		return artworkDAO.getArtworkListByShopAndTypeForArtist(shop,type);
	}


	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月29日
	 */
	@Override
	public List<Artwork> getArtworkListByShopForArtist(Shop shop) {
		// TODO Auto-generated method stub
		return artworkDAO.getArtworkListByShopForArtist(shop);
	}


	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月29日
	 */
	@Override
	public List<Lot> getLotListByShopForArtist(Shop shop) {
		// TODO Auto-generated method stub
		return lotDAO.getLotListByShopForArtist(shop);
	}


	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月29日
	 */
	@Override
	public List<Lot> getLotListByShopAndIsPassedForArtist(Shop shop, Integer is_passed) {
		// TODO Auto-generated method stub
		return lotDAO.getLotListByShopAndIsPassedForArtist(shop,is_passed);
	}


	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月29日
	 */
	@Override
	public JSON saveOrUpdateArtwork(User user, Long artwork_id,int type) {
		// TODO Auto-generated method stub
		if(user==null)
			return new JSON(INFO.NotLogin,INFO.LoginMALL);
		Artist artist=user.getArtist();
		if(artist==null)
			return new JSON(INFO.JumpTo,INFO.ApplyArtist);
		if(artist.getStatus()==0)
			return new JSON(INFO.JumpTo,INFO.Applying);
		Artwork artwork=artworkDAO.getArtworkByIdForArtist(artwork_id);
		if(artwork==null)
			return new JSON(INFO.Error,"该商品不存在");
		artwork.setType(type);
		if(artworkDAO.saveOrUpdateArtworkForArtist(artwork))
			return new JSON(INFO.Success,"修改成功");
		else
			return new JSON(INFO.Error,"修改失败");
	}


	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月29日
	 */
	@Override
	public JSON toLot(User user, Lot lot, Long artwork_id) {
		// TODO Auto-generated method stub
		if(user==null)
			return new JSON(INFO.NotLogin,INFO.LoginMALL);
		Artist artist=user.getArtist();
		if(artist==null)
			return new JSON(INFO.JumpTo,INFO.ApplyArtist);
		if(artist.getStatus()==0)
			return new JSON(INFO.JumpTo,INFO.Applying);
		Artwork artwork=artworkDAO.getArtworkByIdForArtist(artwork_id);
		if(artwork==null)
			return new JSON(INFO.Error,"该商品不存在");
	    if(!lot.checkLotTime())
	    	return new JSON(INFO.Error,"拍卖时间不合理");
		artwork.setType(4);
		lot.setArtwork(artwork);
		lot.setIs_passed(0);
		try {
			if(artworkDAO.saveOrUpdateArtworkForArtist(artwork)&&lotDAO.saveOrUpdateLot(lot))
				return new JSON(INFO.Success,"申请已提交，请耐心等待审核");
			else
				return new JSON(INFO.Error,"修改失败");
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.ActionError);
		}
	}


	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月30日
	 */
	@Override
	public Lot getLotByIDForArtist(Long lot_id) {
		// TODO Auto-generated method stub
		return lotDAO.getLotByIdForArtist(lot_id);
	}


	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月30日
	 */
	@Override
	public boolean deleteLot(Lot lot) {
		// TODO Auto-generated method stub
		return lotDAO.deleteLot(lot);
	}


	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月30日
	 */
	@Override
	public Artwork getArtworkByIdForArtist(Long artwork_id) {
		// TODO Auto-generated method stub
		return artworkDAO.getArtworkByIdForArtist(artwork_id);
	}


	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月30日
	 */
	@Override
	public JSON saveOrUpdateLot(User user, Lot lot) {
		// TODO Auto-generated method stub
		if(user==null)
			return new JSON(INFO.NotLogin,INFO.LoginMALL);
		Artist artist=user.getArtist();
		if(artist==null)
			return new JSON(INFO.JumpTo,INFO.ApplyArtist);
		if(artist.getStatus()==0)
			return new JSON(INFO.JumpTo,INFO.Applying);
		try {
			if(lotDAO.saveOrUpdateLot(lot))
				return new JSON(INFO.Success,"修改成功");
			else
				return new JSON(INFO.Error,"修改失败");
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error,"修改失败");
		}
	}


}
