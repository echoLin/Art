/**
 * @Title {filename}
 * @Package cn.edu.xmu.entity
 * @Description TODO
 * @author echo
 * @date 2015年12月30日 上午9:15:52
 * @version V1.0
 */
package cn.edu.xmu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file: Bid.java
 * @package: cn.edu.xmu.entity
 * @project: Art
 * @description: TODO
 */
@Entity
@Table(name = "Bid")
public class Bid {
	@Id 
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="user_id", updatable=false)
	private User user;
	@ManyToOne
	@JoinColumn(name="lot_id", updatable=false)
	private Lot lot;
	@Column(precision=10,scale=2)
	private Double price;
	private Date time;
	public Bid() {
		super();
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
	public Lot getLot() {
		return lot;
	}
	public void setLot(Lot lot) {
		this.lot = lot;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
