/**
 * @Title: File.java 
 * @Package com.fileSystem.model 
 * @Description: TODO 
 * @author  ŷ��ƽ  
 * @date 2015��3��5�� ����4:00:10 
 * @version V1.0  
 */
package com.fileSystem.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.fileSystem.util.EnumFileType;

/**
 * @ClassName: File 
 * @Description: �ļ�ģ�� 
 * @author ŷ��ƽ
 * @date 2015��3��5�� ����4:00:10 
 */
@SuppressWarnings("serial")
public class File implements Serializable{

	/**
	 * @Fields folderList : �ļ���
	 */
	public List<File> folderList;
	/**
	 * @Fields name : �ļ�����
	 */
	private String name;
	/**
	 * @Fields suffix : �ļ���׺
	 */
	private String suffix;
	/**
	 * @Fields fileType : �ļ�����
	 */
	private EnumFileType fileType;	
	/**
	 * @Fields address : �ļ��ĵ�ַ
	 */
	private String address;
	/**
	 * @Fields bytes : �ļ�����
	 */
	private byte[] bytes;
	
	/**
	 * @return the bytes
	 */
	public byte[] getBytes() {
		return bytes;
	}
	/**
	 * @param bytes the bytes to set
	 */
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}
	/**
	 * @param suffix the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	/**
	 * @return the fileType
	 */
	public EnumFileType getFileType() {
		return fileType;
	}
	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(EnumFileType fileType) {
		this.fileType = fileType;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @Title: File 
	 * @Description: TODO 
	 * @param name
	 * @param suffix
	 * @param fileType
	 * @param address    
	 */
	public File(String name, String suffix, EnumFileType fileType,
			String address, byte[] bytes) {
		super();
		this.name = name;
		this.suffix = suffix;
		this.address = address;
		this.bytes = bytes;
		if(fileType == null){
			this.fileType = EnumFileType.UNKNOWN;
		}else{
			this.fileType = fileType;
		}
	}
	/**
	 * @Title: File 
	 * @Description: TODO 
	 * @param name
	 * @param fileType
	 * @param address    
	 */
	public File(String name, EnumFileType fileType, String address, List<File> folderList) {
		super();
		this.name = name;
		this.fileType = fileType;
		this.address = address;
		this.folderList = folderList;
		this.suffix = " ";
	}
	/**
	 * @Title: File 
	 * @Description: TODO     
	 */
	public File() {
		super();
	}
	/* (non-Javadoc)
	 * <p>Title: toString</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "File [ name=" + name
				+ ", suffix=" + suffix + ", fileType=" + fileType
				+ ", address=" + address + ", bytes=" + Arrays.toString(bytes)
				+ ",folderList=" + folderList + "]";
	}
	
	public void addBytes(byte[] bytes,long fileSize, long count, int len){
		
		if(this.bytes == null){
			this.bytes = new byte[(int)fileSize];
		}
		for (int i = 0; count < this.bytes.length; count++, i++) {
			
			if(i==len){
				break;
			}
			this.bytes[(int)count] = bytes[i];
			
		}
		
	}
	
}
