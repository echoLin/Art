/**
 * @Title {filename}
 * @Package cn.edu.xmu.entity
 * @Description TODO
 * @author echo
 * @date 2015年12月18日 下午1:28:10
 * @version V1.0
 */
package cn.edu.xmu.entity;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file: CONSTVAL.java
 * @package: cn.edu.xmu.entity
 * @project: Art
 * @description: 一些共用的变量值和函数
 */
public final class  PUBLIC {
	public final static String Editor = "edit";
	public final static String Chief_Editor = "audit_article";
	public final static String Artist_Auditor = "audit_artist";
	public final static String Artwork_Auditor = "audit_artwork";
	public final static String Lot_Auditor = "audit_lot";
	public final static String Category_Manager = "manage_category";
	//public final static String Save_Img_Path_Of_Article = "/Users/echo/Desktop/大三/J2EE_邱明/Art/code/Art/WebContent/images/article";
	public final static String Save_Img_Path_Of_Article = "/usr/local/tomcat7/webapps/Art/images/article";
	public final static String Save_Img_Path_Of_Avatar = "/usr/local/tomcat7/webapps/Art/images/avatar";
	public final static String Save_Img_Path_Of_Artwork = "/usr/local/tomcat7/webapps/Art/images/artwork";
	public final static String Save_Img_Path_Of_Shop = "/usr/local/tomcat7/webapps/Art/images/shop";
	//public final static String Save_Img_Path_Of_Avatar = "/Users/echo/Desktop/大三/J2EE_邱明/Art/code/Art/WebContent/images/avatar";
	//public final static String Save_Img_Path_Of_Artwork = "/Users/echo/Desktop/大三/J2EE_邱明/Art/code/Art/WebContent/images/artwork";
	//public final static String Save_Img_Path_Of_Shop = "/Users/echo/Desktop/大三/J2EE_邱明/Art/code/Art/WebContent/images/shop";
	
	/**
	 * 
	 * @Method: storeImageToFileSystem
	 * @Description: 存储图片
	 * @param savePath
	 * @param file
	 * @return String
	 * @throws IOException
	 * @author: echo
	 * @time: 2015年12月19日
	 */
	public final static String storeImageToFileSystem(String savePath, MultipartFile file) throws IOException{
		File f = new File(savePath);
		if(!f.exists()){
			f.mkdirs();
		}
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String name = UUID.randomUUID().toString()+suffix;
		String filename = savePath + File.separator + name;
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
		return name;
	}
}
