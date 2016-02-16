/**
 * @Title {filename}
 * @Package cn.edu.xmu.entity
 * @Description TODO
 * @author echo
 * @date 2015年12月27日 下午2:20:38
 * @version V1.0
 */
package cn.edu.xmu.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file: Favorite.java
 * @package: cn.edu.xmu.entity
 * @project: Art
 * @description: TODO
 */
@Entity
@Table(name = "Favorite", uniqueConstraints={@UniqueConstraint(columnNames={"user_id","shop_id"}),@UniqueConstraint(columnNames={"user_id","artist_id"}),@UniqueConstraint(columnNames={"user_id","artwork_id"})})
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name="Favorite.getFavoriteById", query="from Favorite f where f.id = :id")
})
public class Favorite {
	@Id 
	@GeneratedValue
	protected Long id;
	@ManyToOne
	@JoinColumn(name="user_id", updatable=false)
	protected User user;
	protected Date time;
	
	public Favorite() {
		super();
	}
	
	public Favorite(User user) {
		super();
		this.user = user;
		this.time = new Date();
	}

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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	public boolean equalsUser(User user){
		return this.user.equals(user);
	}

}
