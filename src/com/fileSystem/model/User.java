/**
 * @Title: User.java 
 * @Package com.fileSystem.model 
 * @Description: TODO 
 * @author  欧其平  
 * @date 2015年3月9日 下午8:05:25 
 * @version V1.0  
 */
package com.fileSystem.model;

import java.io.Serializable;

/**
 * @ClassName: User 
 * @Description: 用户类 
 * @author 欧其平
 * @date 2015年3月9日 下午8:05:25 
 */
@SuppressWarnings("serial")
public class User implements Serializable{

	private String userName;
	private String passWord;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * @param passWord the passWord to set
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	/* (non-Javadoc)
	 * <p>Title: toString</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord + "]";
	}
	/**
	 * @Title: User 
	 * @Description: TODO 
	 * @param userName
	 * @param passWord    
	 */
	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	/**
	 * @Title: User 
	 * @Description: TODO     
	 */
	public User() {
		super();
	}
	
}
