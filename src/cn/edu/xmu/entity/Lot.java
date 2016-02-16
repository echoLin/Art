/**
 * @Title {filename}
 * @Package cn.edu.xmu.entity
 * @Description TODO
 * @author echo
 * @date 2015年12月24日 下午9:04:53
 * @version V1.0
 */
package cn.edu.xmu.entity;

import java.text.SimpleDateFormat;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file: Lot.java
 * @package: cn.edu.xmu.entity
 * @project: Art
 * @description: TODO
 */
@Entity
@Table(name = "Lot")
@NamedQueries({
	@NamedQuery(name="Lot.getLotListByIsPassed", query = "from Lot l where l.is_passed=:is_passed"),
	@NamedQuery(name="Lot.getLotListForUser", query = "from Lot l where l.is_passed = 1 and l.end_time >= :end_time order by l.start_time"),
	@NamedQuery(name="Lot.getLotListByCategoryForUser", query = "from Lot l where l.is_passed = 1 and l.artwork.category = :category and l.end_time >= :end_time order by l.start_time"),
	@NamedQuery(name="Lot.getLotListByFutureForUser", query = "from Lot l where l.is_passed = 1 and l.start_time >= :start_time order by l.start_time"),
	@NamedQuery(name="Lot.getLotListByNowForUser", query = "from Lot l where l.is_passed = 1 and l.end_time >= :end_time and l.start_time <= :start_time order by l.start_time"),
	@NamedQuery(name="Lot.getLotListByCategoryAndFutureForUser", query = "from Lot l where l.is_passed = 1 and l.artwork.category = :category and l.start_time >= :start_time order by l.start_time"),
	@NamedQuery(name="Lot.getLotListByCategoryAndNowForUser", query = "from Lot l where l.is_passed = 1 and l.artwork.category = :category and l.end_time >= :end_time and l.start_time <= :start_time order by l.start_time"),
	@NamedQuery(name="Lot.getLotListByShopForUser", query="from Lot l where l.is_passed = 1 and l.end_time >= :end_time and l.artwork.shop = :shop order by l.start_time"),
	@NamedQuery(name="Lot.getLotListByShopForArtist",query="from Lot l where l.artwork.shop=:shop"),
	@NamedQuery(name="Lot.getLotListByShopAndIsPassedForArtist",query="from Lot l where l.artwork.shop=:shop and l.is_passed=:is_passed"),
	@NamedQuery(name="Lot.getLotByIdForArtist",query="from Lot l where l.id=:id"),
	@NamedQuery(name="Lot.getLotByIdForUser", query="from Lot l where l.id=:id and l.is_passed = 1"),
	@NamedQuery(name="Lot.getLotById", query="from Lot l where l.id=:id")
})
public class Lot {
	@Id 
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="artwork_id", updatable=false)
	private Artwork artwork;
	@Column(precision=10,scale=2)
	private Double price;//起拍价
	private Double add_price;//每次加价金额
	private Double now_price=price;//当前价格
	private Date start_time;//开始时间
	private Date end_time;//结束时间
	private Date time;//申请时间
	private Integer is_passed;//1.通过审核  0.待审核  -1.未通过审核
	@OneToOne
	@JoinColumn(name="user_id", updatable=true)
	private User user;
	private Integer is_finished = -1;//是否结束
	
	@Transient
	private String startTime;
	@Transient
	private String endTime;

	public Lot() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Artwork getArtwork() {
		return artwork;
	}
	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getAdd_price() {
		return add_price;
	}
	public void setAdd_price(Double add_price) {
		this.add_price = add_price;
	}
	public Double getNow_price() {
		return now_price;
	}
	public void setNow_price(Double now_price) {
		this.now_price = now_price;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(time);
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getIs_passed() {
		return is_passed;
	}
	public void setIs_passed(Integer is_passed) {
		this.is_passed = is_passed;
	}	
	
	/** 
	 * @Method: checkLotTime
	 * @Description: 判断开始时间大于当前时间，且开始时间小于结束时间
	 * @return
	 * @author: Qing
	 * @time: 2015年12月29日
	 */
	public boolean checkLotTime(){
		Date current=new Date();
		if(this.start_time.after(current)&&this.start_time.before(this.end_time))
			return true;
		else
			return false;		
	}
	public String getStartTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(start_time);
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(end_time);
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getIs_finished() {
		return is_finished;
	}
	public void setIs_finished(Integer is_finished) {
		this.is_finished = is_finished;
	}
	
}
