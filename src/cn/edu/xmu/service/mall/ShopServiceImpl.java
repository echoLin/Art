package cn.edu.xmu.service.mall;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.xmu.dao.mall.ArtistDAO;
import cn.edu.xmu.dao.mall.ArtworkDAO;
import cn.edu.xmu.dao.mall.CategoryDAO;
import cn.edu.xmu.dao.mall.ShopDAO;
import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 Qing
 * All rights reserved
 *
 * @file ShopServiceImpl.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 实现店铺管理接口
 */
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	private ShopDAO shopDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ArtworkDAO artworkDAO;
	@Autowired
	private ArtistDAO artistDAO;

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月24日
	 */
	@Override
	public JSON saveOrUpdateShop(Shop shop,Long category_id,User user) {
		if(user==null)
			return new JSON(INFO.NotLogin,INFO.LoginMALL);
		if(user.getArtist()==null)
			return new JSON(INFO.JumpTo,INFO.ApplyArtist);
		if(user.getArtist().getStatus()==0)
			return new JSON(INFO.Error,"艺术家申请正在审核，暂不能注册店铺");
		Artist artist=user.getArtist();
		if(shopDAO.getShopByNameForArtist(shop.getName())!=null){
			return new JSON(INFO.Error,"店铺名已存在");
		}	
		Category category = categoryDAO.getCategoryById(category_id);
		if(category == null){
			return new JSON(INFO.Error, "作品类别不存在");
		}
		if(shop.getId()!=null && shop.getId()!=0){
			Shop temp = shopDAO.getShopByIdForArtist(shop.getId());
			if(temp == null){
				return new JSON(INFO.Error, "不能修改不存在的店铺");
			}
			if(!temp.checkArtist(artist)){
				return new JSON(INFO.Error, "不能修改不属于你的店铺信息");
			}
		}else{
			shop.setTime(new Date());
		}
		shop.setArtist(artist);
		shop.setCategory(category);
		if(shopDAO.saveOrUpdateShop(shop)){
			//System.out.println("save success");
			return new JSON(INFO.Success,shop.getId());
		}
		else
			return new JSON(INFO.Error,"注册店铺失败");
			
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月24日
	 */
	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return categoryDAO.getCategoryList();
	}
	
	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月25日 上午93225
	 */
	@Override
	public JSON addArtworkImg(MultipartFile file, User user) {
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}

		Artist artist = artistDAO.getArtistByUser(user);
		if(artist == null || artist.getStatus() != 1){
			return new JSON(INFO.NotLogin, INFO.ApplyArtist);
		}
		String fileName = null;
		try {
			fileName = Artwork.uploadImage(file);
		} catch (IOException e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.ActionError);
		}
		if(fileName == null){
			return new JSON(INFO.Error, INFO.ActionError);
		}else{
			return new JSON(INFO.Success, fileName);
		}
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月25日 上午93713
	 */
	@Override
	public Artwork getArtworkByIdForArtist(Long id) {
		return artworkDAO.getArtworkByIdForArtist(id);
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月26日 下午61001
	 */
	@SuppressWarnings("unused")
	@Override
	public JSON saveOrUpdateArtwork(Artwork artwork, Long shop_id,
			Long category_id, User user) {
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}

		Artist artist = artistDAO.getArtistByUser(user);
		if(artist == null || artist.getStatus() != 1){
			return new JSON(INFO.NotLogin, INFO.ApplyArtist);

		}
		Shop shop = shopDAO.getShopByArtistAndShop_idForArtist(artist, shop_id);
		if(shop == null){
			return new JSON(INFO.Error, "这家店铺不是您的，您不能上传作品哦");
		}
		Category category = categoryDAO.getCategoryById(category_id);
		if(category == null){
			return new JSON(INFO.Error, "作品类别不存在");
		}
		if(artwork.getId()!=null){
			Artwork temp = artworkDAO.getArtworkByIdForArtist(artwork.getId());
			if(temp == null){
				artwork.setId(null);
			}else if(!temp.checkArtistAndShop(artist, shop)){
				return new JSON(INFO.Error, "对不起，不能修改不属于您或者不属于该店铺的作品");
			}
		}else{
			artwork.setTime(new Date());
		}
		artwork.setCategory(category);
		artwork.setShop(shop);
		try {
			artworkDAO.saveOrUpdateArtwork(artwork);
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.ActionError);
		}
		return new JSON(INFO.Success, INFO.ActionSuccess);
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月26日 下午84146
	 */
	@Override
	public Shop getShopByArtistAndShop_idForArtist(Artist artist, Long shop_id) {
		if(artist == null){
			return null;
		}
		return shopDAO.getShopByArtistAndShop_idForArtist(artist, shop_id);
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月27日
	 */
	@Override
	public List<Shop> getShopListByArtistForArtist(Artist artist, Integer page) {
		return shopDAO.getShopListByArtistForArtist(artist, page);
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月28日
	 */
	@Override
	public boolean saveOrUpdateShop(Shop shop) {
		// TODO Auto-generated method stub
		return shopDAO.saveOrUpdateShop(shop);
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月28日
	 */
	@Override
	public Category getCategoryById(Long id) {
		// TODO Auto-generated method stub
		return categoryDAO.getCategoryById(id);
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月28日
	 */
	@Override
	public JSON saveAvatar(MultipartFile file, User user,Long shop_id) {
		// TODO Auto-generated method stub
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}
		Artist artist=user.getArtist();
		if(artist==null)
			return new JSON(INFO.JumpTo,INFO.ApplyArtist);
		if(artist.getStatus()==0)
			return new JSON(INFO.JumpTo,INFO.Applying);
		Shop shop=shopDAO.getShopByArtistAndShop_idForArtist(artist, shop_id);
		System.out.println(shop);
		if(shop==null)
			return new JSON(INFO.Error,"该店铺不存在");
		String head_url=null;
		try {
			head_url=shop.uploadImage(file);
			if(file.isEmpty() || head_url==null){
				return new JSON(INFO.Error, INFO.ActionError);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.ActionError);
		}
		shop.setHead_url(head_url);
		if(!shopDAO.saveOrUpdateShop(shop)){
			return new JSON(INFO.Error, INFO.ActionError);
		}
		String url="/Art/mall/jsp/artist/shop/shopInfo?id="+shop.getId();
		return new JSON(INFO.Success, url);
	}

}
