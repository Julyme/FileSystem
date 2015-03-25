/**
 * @Title: FileIO.java 
 * @Package com.fileSystem.util 
 * @Description: TODO 
 * @author  欧其平  
 * @date 2015年3月7日 下午12:31:59 
 * @version V1.0  
 */
package com.fileSystem.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fileSystem.FileSystem;
import com.fileSystem.model.File;

/**
 * @ClassName: FileIO 
 * @Description: TODO 
 * @author 欧其平
 * @date 2015年3月7日 下午12:31:59 
 */
public class FileIO {
	
	/**
	 * @Title: findFile 
	 * @Description: 从文件夹中按名字找文件 
	 * @param fileSystem
	 * @param name
	 * @param folder
	 * @return     
	 * @return File     
	 */
	public static File findFile(FileSystem fileSystem, String name, String folder){
		List<File> list = fileSystem.getFolderMap().get(folder).folderList;
		//遍历文件夹中的每个文件
		for (int i = 0; i < list.size(); i++) {
			File fileTemp = list.get(i);
			if(fileTemp.getName().equals(name)){
				return fileTemp;
			}
		}
		return null;
	}
	
	/**
	 * @Title: findFile 
	 * @Description: 按名字查找全部文件 
	 * @param fileSystem
	 * @param name
	 * @return     
	 * @return List<File>     
	 */
	public static List<File> findFile(FileSystem fileSystem, String name){
		
		List<File> fileList = new ArrayList<File>();
		List<File> searchList = new ArrayList<File>();
		Map<String, File> folderMap = fileSystem.getFolderMap();
		Set<String> folderSet = folderMap.keySet();
		Iterator<String> iterator = folderSet.iterator();
		while(iterator.hasNext()){
			File folder = (File) folderMap.get(iterator.next());
			fileList = folder.folderList;
			for(int i = 0; i < fileList.size(); i++){
				if(fileList.get(i).getName().equals(name)){
					searchList.add(fileList.get(i));
				}
			}
		}
		
		return searchList;
	}
	
	

	/**
	 * @Title: inputFile 
	 * @Description: 把数据存入文件中 
	 * @param fileSystem
	 * @param name
	 * @param bytes
	 * @param fileSize
	 * @param count
	 * @param len     
	 * @return void     
	 */
	public static void inputFile(FileSystem fileSystem, String name,
			byte[] bytes, long fileSize, long count, int len) {
		File file = findFile(fileSystem, name, fileSystem.getFolder());
		file.addBytes(bytes, fileSize, count, len);
	}
	
	/**
	 * @Title: inputFile 
	 * @Description: 把数据存入文件中  
	 * @param fileSystem
	 * @param name
	 * @param bytes     
	 * @return void     
	 */
	public static void inputFile(FileSystem fileSystem, String name,byte[] bytes) {
		File file = findFile(fileSystem, name, fileSystem.getFolder());
		file.setBytes(bytes);
	}
	
	/**
	 * @Title: outputFile 
	 * @Description: 把数据从文件中取出 
	 * @param file
	 * @return     
	 * @return byte[]     
	 */
	public static byte[] outputFile(File file){ 
		return file.getBytes();
	}
	
	
	public static byte[] outputFile(){
		return null;
	}
	
	
}
