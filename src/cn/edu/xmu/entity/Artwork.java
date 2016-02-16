package cn.edu.xmu.entity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name = "Artwork")
@NamedQueries({
	@NamedQuery(name="Artwork.getArtworkListByArtistForUser", query="from Artwork a where a.shop.is_passed = 1 and a.shop.artist = :artist and a.is_passed=1 order by a.time desc"),
	@NamedQuery(name="Artwork.getArtworkListByTypeForUser", query="from Artwork a where a.shop.is_passed=1 and a.type=:type and a.is_passed=1 order by a.time desc"),
	@NamedQuery(name="Artwork.getArtworkListByCategoryAndTypeForUser", query="from Artwork a where a.shop.is_passed=1 and a.category=:category and a.type=:type and a.is_passed=1 order by a.time desc"),
	@NamedQuery(name="Artwork.getArtworkByIdForUser", query="from Artwork a where a.id = :id and a.shop.is_passed = 1"),
	@NamedQuery(name="Artwork.getArtworkListByIdListForUser", query="from Artwork a where a.id IN (:idList) and a.is_passed = 1"),
	@NamedQuery(name="Artwork.getArtworkListByShopForUser", query="from Artwork a where a.shop = :shop and a.shop.is_passed = 1 and a.type = :type and a.is_passed = 1 order by a.time desc"),
	@NamedQuery(name="Artwork.getArtworkListByShopForArtist",query="from Artwork a where a.shop=:shop"),
	@NamedQuery(name="Artwork.getArtworkListByShopAndTypeForArtist",query="from Artwork a where a.shop=:shop and a.type=:type"),
	@NamedQuery(name="Artwork.getArtworkByIdForArtist",query="from Artwork a where a.id=:id")
})
public class Artwork {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="shop_id", updatable=false)
	private Shop shop;//所属店铺
	@ManyToOne
	@JoinColumn(name="category_id", updatable=false)
	private Category category;//所属类别
	private String name;//名字
	@Column(precision=10,scale=2)
	private Double price;//价格
	private String head_url;//头像
	@Column(length = 16777216)
	private String content;//详细介绍
	private Date create_time;//创作年份
	private Date time;//上架时间
	private Integer type;//1.非卖品 2.成品 3.订制品 4.拍卖品
	private Integer is_passed;//1.通过审核  0.待审核  -1.未通过审核

	@Transient
	private String create_year;
	@Transient 
	private boolean favorite=false;
	@Transient
	private Integer favoriteNum = 0;;
	
	public Artwork() {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getHead_url() {
		return head_url;
	}

	public void setHead_url(String head_url) {
		this.head_url = head_url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getCreate_time() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(create_time);
	}
	
	public String getCreate_year(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		if(create_time == null){
			return "xxxx-xx-xx";
		}
		return sdf.format(create_time);
	}

	public String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(time);
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIs_passed() {
		return is_passed;
	}

	public void setIs_passed(Integer is_passed) {
		this.is_passed = is_passed;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public String getFavoriteNum() {
		return String.valueOf(favoriteNum);
	}

	public void setFavoriteNum(Integer favoriteNum) {
		this.favoriteNum = favoriteNum;
	}

	/**
	 * 
	 * @Method: uploadImage
	 * @Description: 添加作品图片
	 * @param file
	 * @return
	 * @throws IOException
	 * @author: echo
	 * @time: 2015年12月27日
	 */
	public static String uploadImage(MultipartFile file) throws IOException{
		File f = new File(PUBLIC.Save_Img_Path_Of_Artwork);
		if(!f.exists()){
			f.mkdirs();
		}
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String name = UUID.randomUUID().toString()+suffix;
		String filename = PUBLIC.Save_Img_Path_Of_Artwork + File.separator + name;
		File img = new File(filename);
		try{
			file.transferTo(img);
		}catch(IllegalStateException e){
			e.printStackTrace();
			return null;
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
		return "/Art/images/artwork/"+name;
	}
	
	/**
	 * 
	 * @Method: checkArtistAndShop
	 * @Description: 检查该作品是否属于该作者和该店铺
	 * @param artist
	 * @param shop
	 * @return
	 * @author: echo
	 * @time: 2015年12月27日
	 */
	public boolean checkArtistAndShop(Artist artist, Shop shop){
		if(this.shop.getArtist() != artist || this.shop != shop){
			return false;
		}
		return true;
	}
	
	public void loadArtwork(Artwork artwork){
		if(id == null){
			id = artwork.getId();
		}
		if(this.category == null){
			this.category = artwork.getCategory();
		}
		this.content += artwork.getContent();
		if(this.create_time == null){
			this.create_time = new Date();
		}
		if(this.head_url == null){
			this.head_url = artwork.getHead_url();
		}
		if(this.is_passed == null){
			this.is_passed = artwork.getIs_passed();
		}
		if(this.name == null){
			this.name = artwork.getName();
		}
		if(this.shop == null){
			this.shop = artwork.getShop();
		}
		if(this.price == null){
			this.price = artwork.getPrice();
		}
		if(this.type == null){
			this.type = artwork.getType();
		}
	}
}
