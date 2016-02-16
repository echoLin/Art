package cn.edu.xmu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "cms_Admin")
@NamedQueries({
	@NamedQuery(name="Admin.getAdminByWorkNum", query="from Admin a where a.work_num = :work_num and a.password = :password and is_used = 1")
})
public class Admin {
	
	@Id 
	@GeneratedValue
	private Long id;
	
	private String work_num;//后台管理账号
	
	private String password;//后台管理密码
	
	private String realname;//真实姓名
	
	private Integer is_used;//是否启用 1 启用 2 停用
	
	

	public Admin() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public String getRealname() {
		return realname;
	}



	public void setRealname(String realname) {
		this.realname = realname;
	}

	

	public String getWork_num() {
		return work_num;
	}



	public void setWork_num(String work_num) {
		this.work_num = work_num;
	}



	public Integer getIs_used() {
		return is_used;
	}



	public void setIs_used(Integer is_used) {
		this.is_used = is_used;
	}



	public boolean equalsToPassword(String password){
		return this.password.endsWith(password);
	}
	
	
}
