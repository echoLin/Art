package cn.edu.xmu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


@Entity
@Table(name = "Block")
@NamedQueries({
	@NamedQuery(name="Block.getBlockList",query="from Block b"),
	@NamedQuery(name="Block.getBlockById",query="from Block b where b.id = :id")
})
public class Block {
	@Id 
	@GeneratedValue
	private int id;
	private String name;
	private int field_count;
	
	public Block() {
		super();
	}
	
	public Block(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getField_count() {
		return field_count;
	}

	public void setField_count(int field_count) {
		this.field_count = field_count;
	}
	
	
}
