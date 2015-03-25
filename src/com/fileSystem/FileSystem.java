/**
 * @Title: FileSystem.java 
 * @Package com.fileSystem 
 * @Description: TODO 
 * @author  ŷ��ƽ  
 * @date 2015��3��6�� ����8:36:03 
 * @version V1.0  
 */
package com.fileSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fileSystem.model.File;
import com.fileSystem.txtedit.TextEdit;
import com.fileSystem.ui.Login;
import com.fileSystem.ui.TextModel;
import com.fileSystem.ui.WindowModel;
import com.fileSystem.util.EnumFileType;
import com.fileSystem.util.FileFactory;
import com.fileSystem.util.FileIO;

/**
 * @ClassName: FileSystem 
 * @Description: ��̨���� 
 * @author ŷ��ƽ
 * @date 2015��3��6�� ����8:36:03 
 */
public class FileSystem {

	private File file;
	private File home ;
	private File user;
	/**
	 * @Fields order : �����ַ���
	 */
	private String order = null;
	/**
	 * @Fields name : ѡ���ļ�������
	 */
	private String name = null;
	/**
	 * @Fields bytes : �ļ�������
	 */
	private byte[] bytes;
	/**
	 * @Fields fileTemp : ��ʱ����
	 */
	public File fileTemp;
	/**
	 * @Fields folderTemp : ��ʱ�ļ�������
	 */
	public String folderTemp;
	/**
	 * @Fields folder : ��ǰλ�õ��ļ�������
	 */
	private String folder;
	/**
	 * @Fields folderMap : ��������ļ��У����ڱ����ļ�
	 */
	private Map<String,File> folderMap;
	/**
	 * @Fields dirctory : ��ǰĿ¼
	 */
	private String directory ;
	
	private Login login;
	/**
	 * @Fields home : ����ַĿ¼
	 */
	private String homeDirectory;
	
	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

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
	 * @return the folder
	 */
	public String getFolder() {
		return folder;
	}

	/**
	 * @param folder the folder to set
	 */
	public void setFolder(String folder) {
		this.folder = folder;
	}

	/**
	 * @return the folderMap
	 */
	public Map<String, File> getFolderMap() {
		return folderMap;
	}

	/**
	 * @param folderMap the folderMap to set
	 */
	public void setFolderMap(Map<String, File> folderMap) {
		this.folderMap = folderMap;
	}

	/**
	 * @return the directory
	 */
	public String getDirectory() {
		return directory;
	}

	/**
	 * @param directory the directory to set
	 */
	public void setDirectory(String directory) {
		this.directory = directory;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
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
	 * @return the user
	 */
	public File getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(File user) {
		this.user = user;
	}

	/**
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * @Title: FileSystem 
	 * @Description: ��ʼ���ļ�״̬
	 * @param login    
	 */
	public FileSystem(Login login) {
		super();
		this.login = login;
		folderMap = new HashMap<String, File>();
		user = FileFactory.newFolder(login.userName, EnumFileType.FOLDER, login.userName, new ArrayList<File>());
		folderMap.put(login.userName, user);
		home = FileFactory.newFolder("home", EnumFileType.FOLDER, homeDirectory, new ArrayList<File>());
		user.folderList.add(home);
		folderMap.put("home", home);
		directory = "/" + login.userName + "/home";
		folder = directory.substring(directory.lastIndexOf("/"), directory.length());
		folder = folder.substring(1, folder.length());
		File music = FileFactory.newFolder("music", EnumFileType.FOLDER, directory, new ArrayList<File>());
		File photo = FileFactory.newFolder("photo", EnumFileType.FOLDER, directory, new ArrayList<File>());
		File movie = FileFactory.newFolder("movie", EnumFileType.FOLDER, directory, new ArrayList<File>());
		home.folderList.add(music);
		folderMap.put("music", music);
		home.folderList.add(photo);
		folderMap.put("photo", photo);
		home.folderList.add(movie);
		folderMap.put("movie", movie);
	}

	/**
	 * @Title: FileSystem 
	 * @Description: TODO     
	 */
	public FileSystem() {
		super();
	}
	
	
	
	/**
	 * @Title: startWindow 
	 * @Description: ���������߳�      
	 * @return void     
	 */
	public void startWindow(){
		new Thread(new MyWindowThread()).start();
	}
	
	/**
	 * @Title: startText 
	 * @Description: �����ı��߳�      
	 * @return void     
	 */
	public void startText(){
		new Thread(new MyTextThread()).start();
	}
	
	/**
	 * @Title: startTextEdit 
	 * @Description: �����ı��༭���߳�      
	 * @return void     
	 */
	public void startTextEdit(){
		new Thread(new MyTextEditThread()).start();
	}


	/**
	 * @Title: createFile 
	 * @Description: �½�һ���ļ� 
	 * @param name     
	 * @return void     
	 */
	public void createFile(String name, EnumFileType fileType){
		
		//��ȡ��ǰ����λ�õ��ļ�������
		folder = directory.substring(directory.lastIndexOf("/"), directory.length());
		folder = folder.substring(1, folder.length());
		//��ʼ�����ļ�
		file = FileFactory.newFile(name, "",
				fileType, directory, null);			
		fileTemp = folderMap.get(folder);
		fileTemp.folderList.add(file);
		
	}
	
	
	/**
	 * @Title: createFolder 
	 * @Description: �½�һ���ļ��� 
	 * @param name     
	 * @return void     
	 */
	public void createFolder(String name){
				
		// ��ȡ��ǰ����λ�õ��ļ�������
		folder = directory.substring(directory.lastIndexOf("/"), directory.length());
		folder = folder.substring(1, folder.length());
		//����һ���ļ���
		file = FileFactory.newFolder(name, EnumFileType.FOLDER, directory, new ArrayList<File>());				
		fileTemp = folderMap.get(folder);
		fileTemp.folderList.add(file);
		folderMap.put(name, file);
		
	}
	
	/**
	 * @Title: deleteFile 
	 * @Description: TODO 
	 * @param name     
	 * @return void     
	 */
	public void deleteFile(String name) {

		// ��ȡ��ǰ����λ�õ��ļ�������
		folder = directory.substring(directory.lastIndexOf("/"), directory.length());
		folder = folder.substring(1, folder.length());
		//��ȡ��һ���ĸ��ļ���
		folderTemp = directory.substring(0, directory.lastIndexOf("/"));
		folderTemp = folderTemp.substring(folderTemp.lastIndexOf("/"), folderTemp.length());
		folderTemp = folderTemp.substring(1, folderTemp.length());
		System.out.println("��һ���ĸ��ļ�������"+folderTemp+",��ǰ����λ�õ��ļ�����������"+folder);
		//��ȡ��ǰ�ļ���
		File fileTemp = FileIO.findFile(this, folder, folderTemp);
		//��ȡҪɾ�����ļ����ļ��У����ж��Ƿ����
		File file = FileIO.findFile(this, name, folder);
		if(file != null){
			if(file.getFileType() == EnumFileType.FOLDER){
				//ɾ���ļ���
				folderMap.remove(name);
				fileTemp.folderList.remove(file);
			}else{
				//ɾ���ļ�
				fileTemp.folderList.remove(file);
			}
			
		}
	}
	
	
	/**
	 * @Title: textServer 
	 * @Description: �ı�������� 
	 * @param textModel     
	 * @return void     
	 */
	public void textServer(TextModel textModel){
		
		String orderTemp1 = null;
		String orderTemp[] = new String[2];
		orderTemp1 = textModel.getText().substring(
				textModel.getText().lastIndexOf("#:"),
				textModel.getText().length());
		orderTemp1 = orderTemp1.substring(2, orderTemp1.length());
		System.out.println("order:" + orderTemp1);
		/*
		 * ��ȡ��ǰ����λ�õ��ļ�������
		 */
		folder = directory.substring(directory.lastIndexOf("/"), directory.length());
		folder = folder.substring(1, folder.length());
		// ʹ��������ʽ���ж������ʽ�Ƿ���ȷ
		if (orderTemp1.matches("[a-z]{1,10}\\s[a-z]{1,10}\\s{0,10}")) {
			orderTemp = orderTemp1.split(" ");
			orderTemp[1] = orderTemp[1].trim();// ȥ���ո�
			order = orderTemp[0];//�����ַ���
			name = orderTemp[1];//�����ַ���
			switch (order) {
			
			case "create":			
				createFile(name, EnumFileType.TEXT);
				textModel.setText("\n�����ɹ���");
				textModel.setText("\n" + directory + " #:");
				break;

			case "mkdir":
				createFolder(name);
				textModel.setText("\n�����ɹ���");
				textModel.setText("\n" + directory + " #:");
				break;
				
			case "cd":
				if(folderMap.get(name) != null){
					directory = directory + "/" +name;
					textModel.setText("\n����"+name);
					textModel.setText("\n" + directory + " #:");
				} else {
					textModel.setText("\n�ļ��в�����");
				}				
				break;
				
			case "open":
				startTextEdit();
				textModel.setText("\n" + directory + " #:");
				break;

			case "delete":
				deleteFile(name);
				textModel.setText("\n�ļ�"+name+"��ɾ����");
				textModel.setText("\n" + directory + " #:");
				break;
				
			default:
				textModel.setText("\n" + directory + " #:");
				break;
			}
		} else if ("dir".equals(orderTemp1.trim())) {
			List<File> list = folderMap.get(folder).folderList;
			//�����ļ����е�ÿ���ļ�
			for (int i = 0; i < list.size(); i++) {
				fileTemp = list.get(i);
				StringBuffer buff = new StringBuffer();
				buff.append("\n").append(fileTemp.getName()).append(fileTemp.getSuffix());
				if(fileTemp.getFileType() == EnumFileType.FOLDER){
					buff.append("  (�ļ���)");
				}else{
					if (fileTemp.getBytes() == null) {
						buff.append("  ��С��").append("0").append(" Bytes");
					} else {
						buff.append("  ��С��").append(fileTemp.getBytes().length)
								.append(" Bytes");
					}
				}
				textModel.setText(buff.toString());
			}
			textModel.setText("\n" + directory + " #:");
		}else if("cd..".equals(orderTemp1) && !folder.equals(login.userName)){
			directory = directory.substring(0, directory.lastIndexOf("/"));
			textModel.setText("\n" + directory + " #:");
		}else if("clear".equals(orderTemp1.trim())){
			textModel.setText();
			textModel.setText("\n" + directory + " #:");
		}else {
			textModel.setText("\n" + directory + " #:");
		}
		
		
	}

	/**
	 * @ClassName: MyWindowThread 
	 * @Description: ���ڷ����߳� 
	 * @author ŷ��ƽ
	 * @date 2015��3��6�� ����9:19:42 
	 */
	class MyWindowThread implements Runnable{
		
		@Override
		public void run() {

			homeDirectory = "/"+login.userName + "/home";
			directory = homeDirectory;

			WindowModel windowModel = new WindowModel(FileSystem.this);
			windowModel.setVisible(true);
			windowModel.setLocationRelativeTo(null);
			login.dispose();
		}		
	}
	
	/**
	 * @ClassName: MyTextThread 
	 * @Description: �ı������߳� 
	 * @author ŷ��ƽ
	 * @date 2015��3��6�� ����10:16:34 
	 */
	class MyTextThread implements Runnable{

		
		@Override
		public void run() {
			TextModel textmodel = new TextModel(FileSystem.this);
			textmodel.setVisible(true);
			textmodel.setLocationRelativeTo(null);				
		}
		
	}
	
	/**
	 * @ClassName: MyTextEditThread 
	 * @Description: �ı��༭���߳� 
	 * @author ŷ��ƽ
	 * @date 2015��3��7�� ����10:14:55 
	 */
	class MyTextEditThread implements Runnable{

		@Override
		public void run() {
			
			bytes = FileIO.outputFile(file);			
			TextEdit textEdit = new TextEdit(FileSystem.this);
			textEdit.setVisible(true);
			textEdit.setLocationRelativeTo(null);	
						
		}
		
	}
	
}
