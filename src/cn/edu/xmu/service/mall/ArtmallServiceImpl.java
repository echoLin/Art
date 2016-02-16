package cn.edu.xmu.service.mall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xmu.dao.mall.ArtistDAO;
import cn.edu.xmu.dao.mall.ArtworkDAO;
import cn.edu.xmu.dao.mall.CategoryDAO;
import cn.edu.xmu.dao.mall.FavoriteDAO;
import cn.edu.xmu.dao.mall.LotDAO;
import cn.edu.xmu.dao.mall.ShopDAO;
import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Lot;
import cn.edu.xmu.entity.Shop;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArtmallServiceImpl.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 实现商城Service
 */
public class ArtmallServiceImpl implements ArtmallService{
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ShopDAO shopDAO;
	@Autowired
	private ArtworkDAO artworkDAO;
	@Autowired
	private LotDAO lotDAO;
	@Autowired
	private FavoriteDAO favoriteDAO;
	@Autowired 
	private ArtistDAO artistDAO;

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午100002
	 */
	@Override
	public List<Category> getCategoryList() {
		return categoryDAO.getCategoryList();
	}
	
	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午54149
	 */
	@Override
	public List<Artist> getArtistList(Integer page, boolean isHot) {
		if(page == null || page == 0)
			page = 1;
		List<Artist> list = null;
		if(isHot){//返回热门艺术家
			List<Long> idList = favoriteDAO.getHotArtist_idList(page);
			if(idList == null || idList.size() == 0){
				return null;
			}
			list = artistDAO.getArtistByIdListForUser(idList);
		}else{//按时间排序返回艺术家
			list = artistDAO.getArtistListForUser(page);
		}
		return list;
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午70357
	 */
	public List<Artwork> getArtworkListByCategoryAndType(Long category_id, Integer type, Integer page, Boolean isHot){
		if(page == null || page == 0)
			page = 1;
		List<Artwork> list = null;
		if(isHot){//返回热门艺术品
			List<Long> idList = favoriteDAO.getHotArtwork_idList(category_id,page);
			if(idList == null || idList.size() == 0){
				return null;
			}
			list = artworkDAO.getArtworkListByIdGroupForUser(idList);
		}else{//按时间排序返回艺术品
			if(category_id == 0){
				list = artworkDAO.getArtworkListByTypeForUser(type, page);
			}else{
				list = artworkDAO.getArtworkListByCagetoryAndTypeForUser(category_id, type, page);
		
			}
		}
		return list;
	}
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午82817
	 */
	public List<Shop> getShopListByCategoryAndIsCus(Long category_id, Integer isCus, Integer page, Boolean isHot){
		if(page == null || page == 0)
			page = 1;
		List<Shop> list = null;
		if(isHot){//返回热门艺术商铺
			List<Long> idList = favoriteDAO.getHotShop_idList(category_id, isCus, page);
			if(idList == null || idList.size() == 0){
				return null;
			}
			list = shopDAO.getShopListByIdListForUser(idList);
		}else{//按时间排序返回艺术商铺
			list = shopDAO.getShopListByCategoryAndIsCusForUser(category_id, isCus, page);
		}
		return list;
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午95709
	 */
	public List<Lot> getLotListByCategoryAndTime(Long category_id, Integer time, Integer page){
		return lotDAO.getLotListForUser(category_id, time, page);
	}
	
	@Override
	public List<Object> getArtworkListByShop(Long id, Integer type,
			Integer page) {
		switch(type){
		case 1:
		case 2:
		case 3:
			return artworkDAO.getArtworkListByShopForUser(id, type, page);
		case 4:
			return lotDAO.getLotListByShopForUser(id, page);
		}
		return null;
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午100015
	 */
	@Override
	public Artwork getArtworkById(Long id) {
		Artwork artwork = artworkDAO.getArtworkByIdForUser(id);
		if(artwork!=null){
			artwork.setFavoriteNum(favoriteDAO.getFavoriteNum(artwork));
		}
		return artwork;
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月28日 上午62851
	 */
	@Override
	public Artist getArtistById(Long id) {
		Artist artist = artistDAO.getArtistById(id);
		if(artist != null){
			artist.setFavoriteNum(favoriteDAO.getFavoriteNum(artist));
		}
		return artist;
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月28日 下午32350
	 */
	@Override
	public Shop getShopById(Long id) {
		return shopDAO.getShopById(id);
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午14835
	 */
	@Override
	public List<Shop> getShopListByArtist(Artist artist, Integer page) {
		return shopDAO.getShopListByArtistForUser(artist, page);
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午14835
	 */
	@Override
	public List<Artwork> getArtworkListByArtist(Artist artist, Integer page) {
		return artworkDAO.getArtworkByArtistForUser(artist, page);
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月30日 上午64018
	 */
	@Override
	public Lot getLotById(Long id) {
		return lotDAO.getLotByIdForUser(id);
	}
}
