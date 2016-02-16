package cn.edu.xmu.entity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name = "Article")
@NamedQueries({
	@NamedQuery(name="Article.getArticleListByEditorAndStatus",
			query="from Article a where a.status = :status and a.editor = :editor order by time desc"),
	@NamedQuery(name="Article.getArticleById",
			query="from Article a where a.id = :id"),
	@NamedQuery(name="Article.getArticleByIdAndStatus",
			query="from Article a where a.id = :id and a.status = :status"),
	@NamedQuery(name="Article.getArticleListByStatus",
			query="from Article a where a.status = :status order by up_time"),
	@NamedQuery(name="Article.getArticleListForMall",
			query="from Article a where a.down_time >= :down_time and status = :status and block = :block order by a.up_time desc")
})

public class Article{
	@Id 
	@GeneratedValue
	private Long id; 
	
	@ManyToOne
	@JoinColumn(name="editor", updatable=false)
	private Admin editor;//采编id
	
	@ManyToOne
	@JoinColumn(name="chief_editor", updatable=true)
	private Admin chief_editor;//主编id
	
	@ManyToOne
	@JoinColumn(name="block_id", updatable=false)
	private Block block;//模块
	
	private String head_url;//头像
	
	private String summary;//摘要
	
	private String title;//标题
	
	@Column(length = 16777216)
	private String content;//内容 html代码
	
	private Date up_time;//上线时间
	
	private Date down_time;//下线时间
	
	private Integer charge;//是否收费
	
	private Integer type; //1.软文 2.广告
	
	@Column(updatable=false)
	private Date time;//创建时间
	
	private Integer status;//资讯的审核状态 1 草稿箱 2 待审核 3 待修改 4 审核通过 -1 审核未通过
	
	@Transient
	private Double price;

	public Article() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Admin getEditor() {
		return editor;
	}

	public void setEditor(Admin editor) {
		this.editor = editor;
	}

	public Admin getChief_editor() {
		return chief_editor;
	}

	public void setChief_editor(Admin chief_editor) {
		this.chief_editor = chief_editor;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public String getHead_url() {
		return head_url;
	}

	public void setHead_url(String head_url) {
		this.head_url = head_url;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUp_time() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(up_time);
	}

	public void setUp_time(Date up_time) {
		this.up_time = up_time;
	}

	public String getDown_time() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(down_time);
	}

	public void setDown_time(Date down_time) {
		this.down_time = down_time;
	}

	public Integer getCharge() {
		return charge;
	}

	public void setCharge(Integer charge) {
		this.charge = charge;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(time);
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public static String uploadImage(MultipartFile file) throws IOException{
		File f = new File(PUBLIC.Save_Img_Path_Of_Article);
		if(!f.exists()){
			f.mkdirs();
		}
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String name = UUID.randomUUID().toString()+suffix;
		String filename = PUBLIC.Save_Img_Path_Of_Article + File.separator + name;
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
		return "/Art/images/article/"+name;
	}

	public Double getPrice(){
		if(charge == 1)
			return 0.0;
		else{
			return (double) ((100-this.block.getId())*100);
		}
	}
	
	
}
