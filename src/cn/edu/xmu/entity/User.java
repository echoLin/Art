package cn.edu.xmu.entity;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="User")
@NamedQueries({
	@NamedQuery(name="User.getUserByUsername",
			query="from User u where u.username=:username"),
	@NamedQuery(name="User.getUserByTelephone",
	        query="from User u where u.telephone=:telephone"),
	@NamedQuery(name="User.login",
	        query="from User u where (u.username=:username and u.password=:password) or (u.telephone=:telephone and u.password=:password)")
})
@JsonIgnoreProperties(value={"artist","address"})
public class User {
	@Id
	@GeneratedValue
	protected long userid;
	protected String username;//用户名
	protected String password;//密码
	protected String telephone;//手机号
	protected Date register_time;//注册时间
	protected String avatar="/Art/images/avatar/default_avatar_male.jpg";//头像
	@Column(precision=10,scale=2)
	protected Double money = 0.0;//账户余额
	protected Integer version;
	@OneToOne
	@JoinColumn(name="artist_id")
	protected Artist artist;
	@OneToOne
	@JoinColumn(name="defaultAddress_id")
	private Address address;//默认收货地址
	
	

	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Artist getArtist() {
		return artist;
	}


	public void setArtist(Artist artist) {
		this.artist = artist;
	}


	public User(){
		super();
	}


	/**
	 * @param user
	 */
	public User(User user) {
	    this.avatar=user.avatar;
	    this.userid=user.userid;
	    this.username=user.username;
	    this.telephone=user.telephone;
	    this.password=user.password;
	    this.register_time=user.register_time;
	    this.money=user.money;
	}


	public long getUserid() {
		return userid;
	}


	public void setUserid(long userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public Date getRegister_time() {
		return register_time;
	}


	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	
	public Double getMoney() {
		return money;
	}


	public void setMoney(Double money) {
		this.money = money;
	}


	@Version
	public Integer getVersion(){
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}


	/**
	 * 
	 * @Method: uploadAvator
	 * @Description: 添加用户头像
	 * @param file
	 * @return
	 * @throws IOException
	 * @author: echo
	 * @time: 2015年12月27日
	 */
	public boolean uploadAvator(MultipartFile file) throws IOException{
		File f = new File(PUBLIC.Save_Img_Path_Of_Avatar);
		if(!f.exists()){
			f.mkdirs();
		}
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String name = String.valueOf(this.userid) + suffix;
		String filename = PUBLIC.Save_Img_Path_Of_Avatar + File.separator + name;
		File img = new File(filename);
		try{
			file.transferTo(img);
		}catch(IllegalStateException e){
			e.printStackTrace();
			return false;
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
		this.avatar = "/Art/images/avatar/"+name;
		return true;
	}
	
	public boolean check_username(String name){
		if(name.length()<3||name.length()>10){
			return false;
		}
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(name);
		return !m.find();
	}
	
	public boolean check_tel(String tel){
		 Pattern p = null;  
	     Matcher m = null;  
	     boolean b = false;   
	     p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号  
	     m = p.matcher(tel);  
	     b = m.matches();   
	     return b;
	}
	
	public boolean check_psd(String psd){
		if(psd.length()<6||psd.length()>20)
			return false;
		else
			return true;
	}
	
	public boolean equals(User user){
		if(this.userid != user.getUserid()){
			return false;
		}
		return true;
	}
	
	public void addMoney(Double add){
		this.money += add;
	}
	
	public void subMoney(Double sub){
		this.money -= sub;
	}
}
