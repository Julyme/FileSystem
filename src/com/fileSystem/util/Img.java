/**
 * @Title: Img.java 
 * @Package com.fileSystem.util 
 * @Description: TODO 
 * @author  欧其平  
 * @date 2015年3月9日 下午4:26:01 
 * @version V1.0  
 */
package com.fileSystem.util;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * @ClassName: Img 
 * @Description: 图像类 
 * @author 欧其平
 * @date 2015年3月9日 下午4:26:01 
 */
public class Img {

	public static URL imgURL1 = Img.class.getResource("/res/file.png");
	public static URL imgURL2 = Img.class.getResource("/res/folder.png");
	public static URL imgURL3 = Img.class.getResource("/res/unknown.png");
	
	public static final Image FILE_IMAGE = new ImageIcon(imgURL1).getImage();
	
	public static final Image FOLDER_IMAGE = new ImageIcon(imgURL2).getImage();
	
	public static final Image UNKNOWN_IMAGE = new ImageIcon(imgURL3).getImage();
	
	
}
