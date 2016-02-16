package cn.edu.xmu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
//@DiscriminatorValue("artist")
@NamedQueries({
	@NamedQuery(name="Artist.getArtistList",
			query="from Artist a"),
    @NamedQuery(name="Artist.getArtistByStatus",
            query="from Artist a where a.status = :status order by apply_time"),
	@NamedQuery(name="Artist.getArtistById",
	        query="from Artist a where a.id = :id"),
	@NamedQuery(name="Artist.getArtistByUser", query="from Artist a where a.user=:user"),
	@NamedQuery(name="Artist.getArtistListByIdListForUser", query="from Artist a where a.id IN (:idList) and a.status = 1"),
	@NamedQuery(name="Artist.getArtistByIdForUser", query="from Artist a where a.id=:id and a.status = 1"),
	@NamedQuery(name="Artist.getArtistListForUser", query="from Artist a where a.status = 1 order by a.apply_time desc")
})

public class Artist{
	@Id
	@GeneratedValue
	private Long id;
	
	private String real_name;//艺术家真实姓名
	
	private String art_direction;//艺术创作方向
	
	private String education;//学历
	
	@Column(length = 16777216)
	private String introduction;//个人经历
	
	private Integer status;//0代表待审核，1代表通过，2代表未通过
	
	@Column(updatable=false)
	private Date apply_time;//申请时间
	@Transient
	private boolean favorite = false;
	@Transient 
	private Integer favoriteNum = 0;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user; 
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getApply_time() {
		return apply_time;
	}

	public void setApply_time(Date apply_time) {
		this.apply_time = apply_time;
	}

	public Artist() {
	    super();
	}

	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getArt_direction() {
		return art_direction;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setArt_direction(String art_direction) {
		this.art_direction = art_direction;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public String getFavoriteNum() {
		return String.valueOf(favoriteNum);
	}

	public void setFavoriteNum(Integer favoriteNum) {
		this.favoriteNum = favoriteNum;
	}
	
	
}
