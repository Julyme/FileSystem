/**
 * @Title: UserService.java 
 * @Package com.fileSystem 
 * @Description: TODO 
 * @author  ŷ��ƽ  
 * @date 2015��3��10�� ����9:16:10 
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
 * @Description: �û������� ���ṩ���û�����ɾ�Ĳ����(CRUD) 
 * @author ŷ��ƽ
 * @date 2015��3��10�� ����9:16:10 
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
	 * @Description: ��������     
	 */
	public UserService() {
		super();
		users = new ArrayList<>();
		user = new User("test", "test");//Ĭ���˺�����
		users.add(user);
	}
	
	
	@Override
	public String toString() {
		return "UserService [users=" + users + ", user=" + user + "]";
	}

	/**
	 * @Title: add 
	 * @Description: ��ӷ��� 
	 * @param user     
	 * @return void     
	 */
	public void add(User user){
		users.add(user);
	}
	
	/**
	 * @Title: upDate 
	 * @Description: �޸ķ��� 
	 * @param user     
	 * @return void     
	 */
	public void upDate(String name, String passWord){
		User u = find(name);
		if(u == null){
			return;
		}else{
			//�޸ĵ�����
			u.setPassWord(passWord);
		}
	}
	
	/**
	 * @Title: delete 
	 * @Description: ɾ������ 
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
	 * @Description: ���ҷ��� 
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
