/**
 * @Title: DataOperation.java 
 * @Package com.fileSystem.util 
 * @Description: TODO 
 * @author  欧其平  
 * @date 2015年3月9日 下午6:47:34 
 * @version V1.0  
 */
package com.fileSystem.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Map;

import com.fileSystem.FileSystem;
import com.fileSystem.UserService;
import com.fileSystem.model.File;
import com.fileSystem.ui.LoadModel;
import com.fileSystem.ui.Login;
import com.fileSystem.ui.WindowModel;

/**
 * @ClassName: DataOperation 
 * @Description: 数据保存，加载 
 * @author 欧其平
 * @date 2015年3月9日 下午6:47:34 
 */
public class DataOperation  {

	static{
		java.io.File file1 = new java.io.File("e://fileSystem");
		file1.mkdir();
		java.io.File file2 = new java.io.File("e://fileSystem//userData");
		file2.mkdir();	
	}
	
	/**
	 * @Title: startSaveData 
	 * @Description: 开始保存数据 
	 * @param fileSystem     
	 * @return void     
	 */
	public static void startSaveData(FileSystem fileSystem){
	
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				LoadModel loadModel = new LoadModel();
				loadModel.setjLabel("保存数据中....");
				loadModel.setVisible(true);
				loadModel.setLocationRelativeTo(null);
				
				String userData = "e://fileSystem//userData//data.fs";
				String userFolder = "e://fileSystem//"+fileSystem.getUser().getName()+"Folder.fs";
				String userFile = "e://fileSystem//"+fileSystem.getUser().getName()+"File.fs";
				try {
					//保存文件夹数据
					FileOutputStream fos1 = new FileOutputStream(userFolder);
					ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
					oos1.writeObject(fileSystem.getFolderMap());
					oos1.flush();
					oos1.close();
					fos1.close();
					Thread.sleep(300);
					loadModel.setjProgressBarValue(33);
					//保存文件数据
					FileOutputStream fos2 = new FileOutputStream(userFile);
					ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
					oos2.writeObject(fileSystem.getUser());
					oos2.flush();
					oos2.close();
					fos2.close();
					Thread.sleep(300);
					loadModel.setjProgressBarValue(66);
					//保存用户数据
					FileOutputStream fos3 = new FileOutputStream(userData);
					ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
					oos3.writeObject(fileSystem.getLogin().getUserService());
					oos3.flush();
					oos3.close();
					fos3.close();	
					loadModel.setjProgressBarValue(100);
					Thread.sleep(300);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				loadModel.setjLabel("保存完毕,请关闭！");
				System.out.println(Thread.activeCount());
				System.out.println("保存完毕！");
				
			}
		}).start();
		
		
	}

	
	/**
	 * @Title: startLoadUserData 
	 * @Description:  开始加载用户数据 
	 * @return     
	 * @return UserService     
	 */
	public static UserService startLoadUserData(){
		
		String userData = "e://fileSystem//userData//data.fs";
		java.io.File file = new java.io.File(userData);
		if(!file.isFile()){
			return new UserService();
		}else{
			try {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				UserService userService = (UserService)ois.readObject();
				System.out.println(userService.getUsers());
				fis.close();
				return userService;

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	
	/**
	 * @Title: startLoadData 
	 * @Description: 开始加载数据 
	 * @param fileSystem     
	 * @return void     
	 * @throws InterruptedException 
	 */
	public static void startLoadData(Login login) {
		
		new Thread(new Runnable() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				FileSystem fileSystem;
				LoadModel loadModel = new LoadModel();
				loadModel.setjLabel("加载文件夹数据....");
				loadModel.setVisible(true);
				loadModel.setLocationRelativeTo(null);
				fileSystem = new FileSystem(login);
				String userFolder = "e://fileSystem//"+login.userName+"Folder.fs";
				String userFile = "e://fileSystem//"+login.userName+"File.fs";
				java.io.File file1 = new java.io.File(userFolder);
				java.io.File file2 = new java.io.File(userFile);
				if(file1.isFile()&&file2.isFile()){
					//开始加载数据			
					try {				
						//加载文件夹数据
						FileInputStream fis1 = new FileInputStream(userFolder);
						ObjectInputStream ois1 = new ObjectInputStream(fis1);
						fileSystem.setFolderMap((Map<String, com.fileSystem.model.File>) ois1.readObject());
						ois1.close();
						//设置进度条
						Thread.sleep(300);
						loadModel.setjProgressBarValue(50);
						loadModel.setjLabel("加载文件数据....");
						Thread.sleep(300);
						//加载文件数据
						FileInputStream fis2 = new FileInputStream(userFile);
						ObjectInputStream ois2 = new ObjectInputStream(fis2);
						fileSystem.setUser((com.fileSystem.model.File)ois2.readObject());
						ois2.close();
						//设置进度条
						loadModel.setjProgressBarValue(100);
						Thread.sleep(300);
						loadModel.dispose();
						//启动窗体
						fileSystem.startWindow();

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}else{
					//设置进度条
					loadModel.setjProgressBarValue(2);
					loadModel.dispose();
					//启动窗体
					fileSystem.startWindow();
				}
				
			}
				
		}).start();
		
		
	}
	
	/**
	 * @Title: importFile 
	 * @Description: 导入文件 
	 * @param fileSystem
	 * @param file
	 * @param contents     
	 * @return void     
	 */
	public static void importFile(FileSystem fileSystem, java.io.File file, WindowModel windowModel){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				//设置加载UI
				LoadModel loadModel = new LoadModel();
				loadModel.setjLabel("导入文件中....");
				loadModel.setVisible(true);
				loadModel.setLocationRelativeTo(null);
				long temp1 = file.length()/100;
				long temp2 = temp1;
				int i = 1;
				//构造输入流
				InputStream is;
				BufferedInputStream bis;
				byte[] bytesTemp = new byte[(int)temp1];
				long count = 0;//记录输出的文件大小
				int len = -1;//每次写入的大小
				long fileSize = file.length();
				//判断文件的格式
				String fileName = file.getName();
				String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
				if("txt".equals(suffix)){
					fileSystem.createFile(file.getName(),EnumFileType.TEXT);
				}else{
					fileSystem.createFile(file.getName(),EnumFileType.UNKNOWN);
				}
				try {
					is = new FileInputStream(file);
					bis = new BufferedInputStream(is);
					while ((len = bis.read(bytesTemp)) != -1) {
						FileIO.inputFile(fileSystem, file.getName(), bytesTemp,
								fileSize, count, len);
						count = count + len;
						if (temp2 < count) {
							// 设置读条的值
							loadModel.setjProgressBarValue(i);
							i++;
							temp2 = i * temp1;
						}

						if (count >= fileSize) {
							loadModel.dispose();
							break;
						}
					}
					bis.close();
					is.close();
					windowModel.refleshPanel(fileSystem.getFolderMap().get(fileSystem.getFolder()).folderList);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
		
	}
	
	/**
	 * @Title: exportFile 
	 * @Description: 导出文件 
	 * @param fileSystem
	 * @param file
	 * @param exportFile     
	 * @return void     
	 */
	public static void exportFile(FileSystem fileSystem, java.io.File file, File exportFile){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				LoadModel loadModel = new LoadModel();
				loadModel.setjLabel("导出文件中....");
				loadModel.setVisible(true);
				loadModel.setLocationRelativeTo(null);
				loadModel.setjProgressBarValue(50);				
				try {
					if(file != null){
						OutputStream os = new FileOutputStream(file);
						BufferedOutputStream bos = new BufferedOutputStream(os);
						bos.write(exportFile.getBytes());
						bos.close();
						os.close();
					}
					loadModel.dispose();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		}).start();
		
	}
	
}
