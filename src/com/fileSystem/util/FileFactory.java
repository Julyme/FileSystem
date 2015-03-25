/**
 * @Title: FileFactory.java 
 * @Package com.fileSystem.util 
 * @Description: TODO 
 * @author  欧其平  
 * @date 2015年3月6日 上午9:05:03 
 * @version V1.0  
 */
package com.fileSystem.util;

import java.util.List;

import com.fileSystem.model.File;

/**
 * @ClassName: FileFactory 
 * @Description: TODO 
 * @author 欧其平
 * @date 2015年3月6日 上午9:05:03 
 */
public  class  FileFactory {

	/**
	 * @Title: newFile 
	 * @Description: 创建一个文件 
	 * @param name
	 * @param suffix
	 * @param fileType
	 * @param address
	 * @param bytes
	 * @return     
	 * @return File     
	 */
	public static File newFile(String name, String suffix,EnumFileType fileType, String address, byte[] bytes){
		return new File(name, suffix,fileType, address,bytes);
	}
	
	
	/**
	 * @Title: newFolder 
	 * @Description: 创建一个文件夹 
	 * @param name
	 * @param fileType
	 * @param address
	 * @return     
	 * @return File     
	 */
	public static File newFolder(String name, EnumFileType fileType, String address, List<File> folderList){
		return new File(name, fileType, address,folderList);
	}
	
}
