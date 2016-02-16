package cn.edu.xmu.entity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Shop")
@NamedQueries({
	@NamedQuery(name="Shop.getShopById", query="from Shop s where id = :id"),
	@NamedQuery(name="Shop.getShopListByArtist", query="from Shop s where s.artist = :artist"),
	@NamedQuery(name="Shop.getShopByName",query="from Shop s where s.name=:name"),
	@NamedQuery(name="Shop.getShopListByArtistAndIsPassed", query="from Shop s where s.artist = :artist and s.is_passed = :is_passed"),
	@NamedQuery(name="Shop.getShopListByArtistForUser", query="from Shop s where s.artist = :artist and s.artist.status = 1 and s.is_passed = 1 order by s.time desc"),
	@NamedQuery(name="Shop.getShopByIdForUser", query="from Shop s where s.id = :id and s.is_passed = 1 and s.artist.status = 1"),
	@NamedQuery(name="Shop.getShopListByIdListForUser", query="from Shop s where s.id IN (:idList) and s.is_passed = 1 and s.artist.status = 1"),
	@NamedQuery(name="Shop.getShopListForUser", query="from Shop s where s.is_passed = 1 and s.artist.status = 1 order by s.time desc"),
	@NamedQuery(name="Shop.getShoListByCategoryForUser", query="from Shop s where s.category = :category and s.is_passed = 1 and s.artist.status = 1"),
	@NamedQuery(name="Shop.getShopListByCategoryAndIsCusForUser", query="from Shop s where s.category=:category and s.is_customized = :is_customized and s.is_passed = 1 and s.artist.status = 1 order by s.time desc"),
	@NamedQuery(name="Shop.getShopListByIsCusForUser", query="from Shop s where s.is_customized = :is_customized and s.is_passed = 1 and s.artist.status = 1 order by s.time desc"),
	@NamedQuery(name="Shop.getShopListForArtist", query="from Shop s"),
	@NamedQuery(name="Shop.getShopListByCategoryForArtist", query="from Shop s where s.category = :category"),
	@NamedQuery(name="Shop.getShopByIdForArtist", query="from Shop s where id = :id"),
	@NamedQuery(name="Shop.getShopListByArtistForArtist", query="from Shop s where s.artist = :artist"),
	@NamedQuery(name="Shop.getShopByNameForArtist",query="from Shop s where s.name=:name"),
	@NamedQuery(name="Shop.getShopByArtistAndShop_idForArtist",query="from Shop s where s.artist = :artist and s.id = :id")
})
public class Shop {
	@Id 
	@GeneratedValue
	private Long id;
	@OneToOne
	@JoinColumn(name="artist_id", updatable=false)
	private Artist artist;//所属艺术家
	@ManyToOne
	@JoinColumn(name="category_id", updatable=false)
	private Category category;//所属类型
	private String name;//店名
	private String introduction;//介绍
	private String head_url="/Art/images/shop/default.png";
	private Integer limit_not_for_sale_num=10;//非卖品的数量限制
	private Integer limit_finish_num=10;//卖品数量限制
	private Integer limit_auction_num=10;//拍卖品数量限制
	private Integer is_customized;//是否提供定制服务
	private Date time;//店铺注册时间
	private Integer is_passed;//1启用 -1停用
	@Transient
	private boolean favorite = false;
	@Transient
	private Integer favoriteNum = 0;
	
	public Shop() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getLimit_not_for_sale_num() {
		return limit_not_for_sale_num;
	}

	public void setLimit_not_for_sale_num(Integer limit_not_for_sale_num) {
		this.limit_not_for_sale_num = limit_not_for_sale_num;
	}

	public Integer getLimit_finish_num() {
		return limit_finish_num;
	}

	public void setLimit_finish_num(Integer limit_finish_num) {
		this.limit_finish_num = limit_finish_num;
	}

	public Integer getLimit_auction_num() {
		return limit_auction_num;
	}

	public void setLimit_auction_num(Integer limit_auction_num) {
		this.limit_auction_num = limit_auction_num;
	}

	public Integer getIs_customized() {
		return is_customized;
	}

	public void setIs_customized(Integer is_customized) {
		this.is_customized = is_customized;
	}

	public String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(time);
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getHead_url() {
		return head_url;
	}

	public void setHead_url(String head_url) {
		this.head_url = head_url;
	}
	
	public Integer getIs_passed() {
		return is_passed;
	}

	public void setIs_passed(Integer is_passed) {
		this.is_passed = is_passed;
	}
	

	public boolean getFavorite() {
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
	 * @Description: 添加店铺相关图片，如店铺头像
	 * @param file
	 * @return
	 * @throws IOException
	 * @author: echo
	 * @time: 2015年12月27日
	 */
	public static String uploadImage(MultipartFile file) throws IOException{
		File f = new File(PUBLIC.Save_Img_Path_Of_Shop);
		if(!f.exists()){
			f.mkdirs();
		}
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String name = UUID.randomUUID().toString()+suffix;
		String filename = PUBLIC.Save_Img_Path_Of_Shop + File.separator + name;
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
		return "/Art/images/shop/"+name;
	}
	
	/**
	 * 
	 * @Method: checkArtist
	 * @Description: 检查该店铺是否属于该艺术家
	 * @param artist
	 * @return
	 * @author: echo
	 * @time: 2015年12月27日
	 */
	public boolean checkArtist(Artist artist){
		if(this.artist != artist){
			return false;
		}
		return true;
	}
	
}
