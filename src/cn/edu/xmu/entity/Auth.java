package cn.edu.xmu.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "cms_Auth")
@NamedQueries({
	@NamedQuery(name="Auth.getAuthListByAdmin", query="from Auth a where a.admin = :admin")
})
public class Auth {

	@Id 
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="admin_id", updatable=false)
	private Admin admin;
	
	@ManyToOne
	@JoinColumn(name="role_id", updatable=false)
	private Role role;
	
	private Date time;
	
	private Integer is_used;
	
	

	public Auth() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Role getRole() {
		return role;
	}

	public void setPower(Role role) {
		this.role = role;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getIs_used() {
		return is_used;
	}

	public void setIs_used(Integer is_used) {
		this.is_used = is_used;
	}
	
}
