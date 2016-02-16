/**
 * @Title {filename}
 * @Package cn.edu.xmu.entity
 * @Description TODO
 * @author echo
 * @date 2015年12月27日 下午3:26:33
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
 * @file: FavoriteArtist.java
 * @package: cn.edu.xmu.entity
 * @project: Art
 * @description: TODO
 */
@Entity
@DiscriminatorValue("Artist")
@NamedQueries({
	@NamedQuery(name="FavoriteArtist.getFavoriteListByUser", query="from FavoriteArtist fa where fa.user=:user and fa.artist.status = 1 order by time desc"),
	@NamedQuery(name="FavoriteArtist.getFavoriteByUserAndArtist", query="from FavoriteArtist fa where fa.user=:user and fa.artist=:artist and fa.artist.status = 1"),
	@NamedQuery(name="FavoriteArtist.getFavoriteListByArtist", query="from FavoriteArtist fa where fa.artist=:artist and fa.artist.status = 1 order by fa.time desc")
})
public class FavoriteArtist extends Favorite {
	@ManyToOne
	@JoinColumn(name="artist_id", updatable=false)
	private Artist artist;

	public FavoriteArtist() {
		super();
	}

	public FavoriteArtist(User user, Artist artist) {
		super(user);
		this.artist = artist;
	}



	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}	
	
}
