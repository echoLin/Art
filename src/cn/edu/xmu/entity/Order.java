package cn.edu.xmu.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "ArtOrder", uniqueConstraints={@UniqueConstraint(columnNames={"artwork_id","user_id"})})
@NamedQueries({
	
	@NamedQuery(name= "Order.getOrderListByUserAndStatus",
			query="from Order a where a.status = :status and a.user = :user order by a.time desc"),
	@NamedQuery(name= "Order.getOrderByIdAndUser",
			query="from Order a where a.id = :id and a.user = :user order by a.time desc"),
	@NamedQuery(name= "Order.getOrderByIdAndShop",
			query="from Order a where a.id = :id and a.shop = :shop order by a.time desc"),	
	@NamedQuery(name= "Order.getOrderListByUserAndType",
			query="from Order a where a.type =:type and a.user = :user order by a.time desc"),
	@NamedQuery(name= "Order.getOrderListByShopAndType",
			query="from Order a where a.type =:type and a.shop = :shop order by a.time desc"),
	@NamedQuery(name= "Order.getOrderListByShopAndStatus",
			query="from Order a where a.status =:status and a.shop = :shop order by a.time desc"),
	@NamedQuery(name= "Order.getOrderListByShopAndTypeAndStatus",
			query="from Order a where a.type =:type and a.shop = :shop and a.status = :status order by a.time desc"),
	@NamedQuery(name= "Order.getOrderListByUserAndTypeAndStatus",
			query="from Order a where a.type =:type and a.user = :user and a.status = :status order by a.time desc")
})
public class Order {
	
	@Id 
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="shop_id", updatable=false)
	private Shop shop;//所属店铺
	
	@ManyToOne
	@JoinColumn(name="artwork_id", updatable=false)
	private Artwork artwork;//艺术品id
	
	@ManyToOne
	@JoinColumn(name="user_id", updatable=false)
	private User user;//购买用户
	
	private Date time;//订单生成时间
	
	private String express_company;//快递公司(快递公司的拼音)
	
	private String tracking_number;//快递单号
	
	private Integer status;//1.代付款  2.待发货   3.待收货  4.待评价  5.已评价
	
	private Integer stage;//定制阶段数
	
	private Integer type;//2.成品 3.定制 4.拍卖
	
	private Integer is_deleted = 2;//1.已取消 2.未取消
	
	public Order() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
 
	public Artwork getArtwork() {
		return artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
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

	public String getExpress_company() {
		return express_company;
	}

	public void setExpress_company(String express_company) {
		this.express_company = express_company;
	}

	public String getTracking_number() {
		return tracking_number;
	}

	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStage() {
		return stage;
	}

	public void setStage(Integer stage) {
		this.stage = stage;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(Integer is_deleted) {
		this.is_deleted = is_deleted;
	}
	
}
