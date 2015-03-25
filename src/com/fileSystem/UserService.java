/**
 * @Title: UserService.java 
 * @Package com.fileSystem 
 * @Description: TODO 
 * @author  欧其平  
 * @date 2015年3月10日 上午9:16:10 
 * @version V1.0  
 */
package com.fileSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fileSystem.model.User;
import com.fileSystem.ui.Register;

/**
 * @ClassName: UserService 
 * @Description: 用户管理类 ，提供对用户的增删改查操作(CRUD) 
 * @author 欧其平
 * @date 2015年3月10日 上午9:16:10 
 */
@SuppressWarnings("serial")
public class UserService implements Serializable{

	private List<User> users;
	private User user;

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @Title: UserService 
	 * @Description: 构件容器     
	 */
	public UserService() {
		super();
		users = new ArrayList<>();
		user = new User("test", "test");//默认账号密码
		users.add(user);
	}
	
	
	@Override
	public String toString() {
		return "UserService [users=" + users + ", user=" + user + "]";
	}

	/**
	 * @Title: add 
	 * @Description: 添加方法 
	 * @param user     
	 * @return void     
	 */
	public void add(User user){
		users.add(user);
	}
	
	/**
	 * @Title: upDate 
	 * @Description: 修改方法 
	 * @param user     
	 * @return void     
	 */
	public void upDate(String name, String passWord){
		User u = find(name);
		if(u == null){
			return;
		}else{
			//修改的属性
			u.setPassWord(passWord);
		}
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除方法 
	 * @param name     
	 * @return void     
	 */
	public void delete(String name){
		User u = find(name);
		if (u == null){
			return;
		}else{
			users.remove(u);
		}
	}
	
	/**
	 * @Title: find 
	 * @Description: 查找方法 
	 * @param name     
	 * @return User     
	 */
	public User find(String name){
		for (int i = 0; i < users.size(); i++){
			User u = users.get(i);
			if (u.getUserName().equals(name)){
				return u;
			}
		}
		return null;
	}
	
	
	public void startRegister(){
		
		new Thread(new MyRegisterThread()).start();
		
	}
	
	
	class MyRegisterThread implements Runnable{

		@Override
		public void run() {

			Register r = new Register(UserService.this);
			r.setVisible(true);
			r.setLocationRelativeTo(null);
			
		}
		
	}
	
}
