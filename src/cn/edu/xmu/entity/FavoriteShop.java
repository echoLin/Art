/**
 * @Title {filename}
 * @Package cn.edu.xmu.entity
 * @Description TODO
 * @author echo
 * @date 2015年12月27日 下午3:22:06
 * @version V1.0
 */
package cn.edu.xmu.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file: FavoriteShop.java
 * @package: cn.edu.xmu.entity
 * @project: Art
 * @description: TODO
 */
@Entity
@DiscriminatorValue("Shop")
@NamedQueries({
	@NamedQuery(name="FavoriteShop.getFavoriteListByUser", query="from FavoriteShop fs where fs.user=:user and fs.shop.is_passed = 1 and fs.shop.artist.status = 1 order by time desc"),
	@NamedQuery(name="FavoriteShop.getFavoriteByUserAndShop", query="from FavoriteShop fs where fs.user=:user and fs.shop=:shop and fs.shop.is_passed = 1 and fs.shop.artist.status = 1 "),
	@NamedQuery(name="FavoriteShop.getFavoriteListByShop", query="from FavoriteShop fs where  fs.shop=:shop  and fs.shop.is_passed = 1 and fs.shop.artist.status = 1 order by fs.time desc")
})
public class FavoriteShop extends Favorite {
	@ManyToOne
	@JoinColumn(name="shop_id", updatable=false)
	private Shop shop;

	public FavoriteShop() {
		super();
	}

	public FavoriteShop(User user, Shop shop) {
		super(user);
		this.shop = shop;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
}
