/**
 * @Title: FileFactory.java 
 * @Package com.fileSystem.util 
 * @Description: TODO 
 * @author  ŷ��ƽ  
 * @date 2015��3��6�� ����9:05:03 
 * @version V1.0  
 */
package com.fileSystem.util;

import java.util.List;

import com.fileSystem.model.File;

/**
 * @ClassName: FileFactory 
 * @Description: TODO 
 * @author ŷ��ƽ
 * @date 2015��3��6�� ����9:05:03 
 */
public  class  FileFactory {

	/**
	 * @Title: newFile 
	 * @Description: ����һ���ļ� 
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
	 * @Description: ����һ���ļ��� 
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
