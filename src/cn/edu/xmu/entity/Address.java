package cn.edu.xmu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file: Address.java
 * @package: cn.edu.xmu.entity
 * @project: Art
 * @description: TODO
 */
@Entity
@Table(name="Address")
@NamedQueries({
	@NamedQuery(name = "Address.getAddressListByUser",
			query = "from Address a where a.user = :user"),
	@NamedQuery(name = "Address.getAddressByUserAndNotDelete",
	        query = "from Address a where a.user = :user and a.is_delete = 0"),
	@NamedQuery(name = "Address.getAddressById",
	        query = "from Address a where a.id = :id")
})
public class Address {
	
	@Id
	@GeneratedValue
	private Long id;
	private String receiver_name;//收货人姓名
	private String receiver_telephone;//收货人手机号码
	private String province;//省
	private String city;//市
	private String district;//区
	private String detailDescription;//详细地址
	private String postalcode;//邮政编码
	private Integer is_delete;//是否被删除,1代表是被删除，0代表未被删除
	
	@ManyToOne
	@JoinColumn(name="user_id",updatable=false)
	private User user;//地址所对应的用户
	
	
	public Address() {
		super();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_telephone() {
		return receiver_telephone;
	}
	public void setReceiver_telephone(String receiver_telephone) {
		this.receiver_telephone = receiver_telephone;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getDetailDescription() {
		return detailDescription;
	}
	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public Integer getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}

	

}
