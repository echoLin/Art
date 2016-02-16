package cn.edu.xmu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "Category")
@NamedQueries({
	@NamedQuery(name="Category.getCategoryList",query="from Category c"),
	@NamedQuery(name="Category.getCategoryById",query="from Category c where c.id=:id")
})
public class Category {
	@Id 
	@GeneratedValue
	private Long id;
	private String name;
	
	public Category() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
