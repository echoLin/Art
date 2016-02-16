/**
 * @Title {filename}
 * @Package cn.edu.xmu.entity
 * @Description TODO
 * @author echo
 * @date 2015年12月27日 下午3:16:10
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
 * @file: FavoriteArtwork.java
 * @package: cn.edu.xmu.entity
 * @project: Art
 * @description: TODO
 */
@Entity
@DiscriminatorValue("Artwork")
@NamedQueries({
	@NamedQuery(name="FavoriteArtwork.getFavoriteListByUser", query="from FavoriteArtwork fa where fa.user=:user and fa.artwork.shop.artist.status = 1 and fa.artwork.shop.is_passed = 1 and fa.artwork.is_passed = 1 order by time desc"),
	@NamedQuery(name="FavoriteArtwork.getFavoriteByUserAndArtwork", query="from FavoriteArtwork fa where fa.user=:user and fa.artwork=:artwork and fa.artwork.shop.artist.status = 1 and fa.artwork.shop.is_passed = 1 and fa.artwork.is_passed = 1 "),
	@NamedQuery(name="FavoriteArtwork.getFavoriteListByArtwork", query="from FavoriteArtwork fa where fa.artwork=:artwork and fa.artwork.shop.artist.status = 1 and fa.artwork.shop.is_passed = 1 and fa.artwork.is_passed = 1 order by fa.time desc")
})
public class FavoriteArtwork extends Favorite {
	@ManyToOne
	@JoinColumn(name="artwork_id", updatable=false)
	private Artwork artwork;

	public FavoriteArtwork() {
		super();
	}

	public FavoriteArtwork(User user, Artwork artwork) {
		super(user);
		this.artwork = artwork;
	}

	public Artwork getArtwork() {
		return artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}
	
}
