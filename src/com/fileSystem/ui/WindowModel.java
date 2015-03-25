/**
 * @Title: WindowModel.java 
 * @Package com.fileSystem.ui 
 * @Description: TODO 
 * @author  欧其平  
 * @date 2015年3月5日 下午4:12:17 
 * @version V1.0  
 */
package com.fileSystem.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.fileSystem.FileSystem;
import com.fileSystem.model.File;
import com.fileSystem.util.DataOperation;
import com.fileSystem.util.EnumFileType;
import com.fileSystem.util.FileIO;
import com.fileSystem.util.Img;

/**
 * @ClassName: WindowModel 
 * @Description: TODO 
 * @author 欧其平
 * @date 2015年3月5日 下午4:13:47 
 */

@SuppressWarnings("serial")
public class WindowModel extends javax.swing.JFrame {

 
    public WindowModel(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    	initComponents();
    	this.setTitle("文件系统 v1.0  作者：欧其平");
    	this.refleshPanel(fileSystem.getFolderMap().get(fileSystem.getFolder()).folderList);
    	jTextField1.setEditable(false);
    	//设置UI风格
    	  try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			} 
          SwingUtilities.updateComponentTreeUI(this);
    }
   
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {

				System.out.println("程序关闭中。。。");
				DataOperation.startSaveData(fileSystem);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
			
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				
			}
		});
        setPreferredSize(new java.awt.Dimension(850, 650));

        jButton1.setText("返回");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("前进");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("目录：");
        
        jTextField1.setText(fileSystem.getDirectory());

        jTextField2.setText("搜索");

        jButton3.setText("搜索");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("文本模式");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setBackground(Color.white);

        jLabel2.setText("（文件名称）");

        jLabel3.setText("格式：");

        jLabel4.setText("(文件的格式)");

        jLabel5.setText("大小：");

        jLabel6.setText("(文件的大小)");

        jButton5.setText("导入文件");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(8, 8, 8)
                        .addComponent(jButton2)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(27, 27, 27))))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jButton5))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }    
    
    
    
    /**
	 * @Title: refleshPanel 
	 * @Description: 刷新容器      
	 * @return void     
	 */
	public void refleshPanel(List<File> list) {
		
		jPanel2.removeAll();
		
		//遍历文件夹中的每个文件
		for (int i = 0; i < list.size(); i++) {
			File fileTemp = list.get(i);
			if(fileTemp.getFileType() == EnumFileType.FOLDER){
				//显示一个文件夹		
				jlabel = new JLabel();
				jlabel.setText(fileTemp.getName());
				jlabel.setIcon(new ImageIcon(Img.FOLDER_IMAGE));
				jlabel.setVerticalTextPosition(JLabel.BOTTOM);
				jlabel.setHorizontalTextPosition(JLabel.CENTER);
				
				jlabel.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		                jLabel1MouseClicked(evt);
		            }
		            public void mouseEntered(java.awt.event.MouseEvent evt) {
		                jLabel1MouseEntered(evt);
		            }
		        });
				jPanel2.add(jlabel);
				
				
			}else if(fileTemp.getFileType() == EnumFileType.TEXT){
				//显示一个文件
				jlabel = new JLabel();
				jlabel.setText(fileTemp.getName());
				jlabel.setIcon(new ImageIcon(Img.FILE_IMAGE));
				jlabel.setVerticalTextPosition(JLabel.BOTTOM);
				jlabel.setHorizontalTextPosition(JLabel.CENTER);
				
				jlabel.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		                jLabel1MouseClicked(evt);
		            }
		            public void mouseEntered(java.awt.event.MouseEvent evt) {
		                jLabel1MouseEntered(evt);
		            }
		        });
				jPanel2.add(jlabel);
			}else if(fileTemp.getFileType() == EnumFileType.UNKNOWN){
				//显示一个未知格式文件
				jlabel = new JLabel();
				jlabel.setText(fileTemp.getName());
				jlabel.setIcon(new ImageIcon(Img.UNKNOWN_IMAGE));
				jlabel.setVerticalTextPosition(JLabel.BOTTOM);
				jlabel.setHorizontalTextPosition(JLabel.CENTER);
				
				jlabel.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		                jLabel1MouseClicked(evt);
		            }
		            public void mouseEntered(java.awt.event.MouseEvent evt) {
		                jLabel1MouseEntered(evt);
		            }
		        });
				jPanel2.add(jlabel);
			}
			
		}
		jPanel2.validate();   
		jPanel2.repaint();
		jTextField1.setText(fileSystem.getDirectory());
	}
    
    

    /**
	 * @Title: jLabel1MouseEntered 
	 * @Description: 图标焦点获取 
	 * @param evt     
	 * @return void     
	 */
	protected void jLabel1MouseEntered(MouseEvent evt) {
		
		Object obj = evt.getComponent();
		if(obj instanceof JLabel){
			jlabel = (JLabel) obj;
			if (searchFlag == false) {
				file = FileIO.findFile(fileSystem, jlabel.getText(),
						fileSystem.getFolder());
				fileSystem.setFile(file);
			} else {			
				List<File> fileList = FileIO.findFile(fileSystem, jlabel.getText());
				file = (File) fileList.get(fileRecord);
				fileSystem.setFile(file);
				fileRecord++;
				if (fileRecord >= fileList.size()) {
					fileRecord = 0;
				}				
			}
			name = file.getName();
			fileSystem.setName(name);// 设置当前文件名
			jLabel2.setText(file.getName());
			if(file.getFileType()==EnumFileType.TEXT){
				jLabel4.setText("文本");
			}else if(file.getFileType()==EnumFileType.FOLDER){
				jLabel4.setText("文件夹");
			}
			
			if (file.getBytes() == null) {
				jLabel6.setText("0 Bytes");
			} else {
				jLabel6.setText(file.getBytes().length + " Bytes");
			}
		}
		
	}

	/**
	 * @Title: jLabel1MouseClicked 
	 * @Description: 图标点击 事件
	 * @param evt     
	 * @return void     
	 */
	protected void jLabel1MouseClicked(MouseEvent evt) {

		if(evt.getButton() == MouseEvent.BUTTON3){
			//单击图标右键，弹出菜单
			JPopupMenu popup = new JPopupMenu();
			JMenuItem item1 = new JMenuItem("打开");
			item1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jLabelopenActionPerformed(evt);
				}
			});
			JMenuItem item2 = new JMenuItem("删除");
			item2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jLabelDeleteActionPerformed(evt);
				}
			});
			JMenuItem item3 = new JMenuItem("导出");
			item3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jLabelOutputActionPerformed(evt);
				}
			});
			popup.add(item1);
			popup.add(item2);
			popup.add(item3);
			popup.show(this.jlabel, evt.getX(), evt.getY());
			System.out.println("图标点击");
		}
		if(evt.getClickCount() == 2){
			if(file.getFileType() == EnumFileType.TEXT){
				fileSystem.startTextEdit();
			}else if(file.getFileType() == EnumFileType.FOLDER){
				fileSystem.setDirectory(fileSystem.getDirectory()+"/"+name);		
				fileSystem.setFolder(name);
				System.out.println(fileSystem.getFolder());
				refleshPanel(fileSystem.getFolderMap().get(fileSystem.getFolder()).folderList);
			}
		}
		
	}

	/**
	 * @Title: jLabelOutputActionPerformed 
	 * @Description: 文件导出 
	 * @param evt     
	 * @return void     
	 */
	protected void jLabelOutputActionPerformed(ActionEvent evt) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showDialog(this, "导出");
		java.io.File file = fileChooser.getSelectedFile();
		DataOperation.exportFile(fileSystem, file, this.file);
		
	}


	/**
	 * @Title: jLabelDeleteActionPerformed 
	 * @Description: 图标（文件）删除事件 
	 * @param evt     
	 * @return void     
	 */
	protected void jLabelDeleteActionPerformed(ActionEvent evt) {

		fileSystem.deleteFile(name);
		refleshPanel(fileSystem.getFolderMap().get(fileSystem.getFolder()).folderList);
		
	}

	/**
	 * @Title: jLabelopenActionPerformed 
	 * @Description: 图标（文件）打开事件 
	 * @param evt     
	 * @return void     
	 */
	protected void jLabelopenActionPerformed(ActionEvent evt) {
				
		if(file.getFileType() == EnumFileType.TEXT){
			fileSystem.startTextEdit();
		}else if(file.getFileType() == EnumFileType.FOLDER){
			fileSystem.setDirectory(fileSystem.getDirectory()+"/"+name);		
			fileSystem.setFolder(name);
			refleshPanel(fileSystem.getFolderMap().get(fileSystem.getFolder()).folderList);
		}
		
	}

	/**
	 * @Title: jPanel2MouseClicked 
	 * @Description: 鼠标单击事件 ,单击后弹出菜单
	 * @param evt     
	 * @return void     
	 */
	protected void jPanel2MouseClicked(MouseEvent evt) {
		
		
		if(evt.getButton() == MouseEvent.BUTTON3){
			// 单击右键时弹出菜单
			JPopupMenu popup = new JPopupMenu();
			JMenu menu = new JMenu("新建");
			JMenuItem item1 = new JMenuItem("文件");
			item1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					item1ActionPerformed(evt);
				}
			});
			JMenuItem item2 = new JMenuItem("文件夹");
			item2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					item2ActionPerformed(evt);
				}
			});
			JMenuItem item3 = new JMenuItem("刷新");
			item3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					item3ActionPerformed(evt);
				}
			});
			menu.add(item1);
			menu.add(item2);
			popup.add(menu);
			popup.add(item3);

			popup.show(this.jPanel2, evt.getX(), evt.getY());
			System.out.println(evt.getX() + "," + evt.getY());
		}	
		
	}
	

	/**
	 * @Title: item3ActionPerformed 
	 * @Description: (刷新)事件 
	 * @param evt     
	 * @return void     
	 */
	protected void item3ActionPerformed(ActionEvent evt) {
		System.out.println(fileSystem.getFolder());
		refleshPanel(fileSystem.getFolderMap().get(fileSystem.getFolder()).folderList);
	}

	/**
	 * @Title: item2ActionPerformed 
	 * @Description: (新建文件夹)事件 
	 * @param evt     
	 * @return void     
	 */
	protected void item2ActionPerformed(ActionEvent evt) {

		JTextField folderName = new JTextField();
		int response = JOptionPane.showConfirmDialog(null, folderName, "输入文件夹名", 0, 0,
					new ImageIcon(Img.FOLDER_IMAGE));	
		name = folderName.getText();
		if(response == JOptionPane.YES_OPTION){
			fileSystem.createFolder(name);
			refleshPanel(fileSystem.getFolderMap().get(fileSystem.getFolder()).folderList);
		}
		
	}

	/**
	 * @Title: item1ActionPerformed 
	 * @Description: (新建文件)事件 
	 * @param evt     
	 * @return void     
	 */
	protected void item1ActionPerformed(ActionEvent evt) {

		JTextField textName = new JTextField();
		int response = JOptionPane.showConfirmDialog(null, textName, "输入文件名", 0, 0,
					new ImageIcon(Img.FILE_IMAGE));	
		name = textName.getText();
		if(response == JOptionPane.YES_OPTION){
			fileSystem.createFile(name, EnumFileType.TEXT);
			refleshPanel(fileSystem.getFolderMap().get(fileSystem.getFolder()).folderList);
		}
		
	}

	
	/**
	 * @Title: jButton5ActionPerformed 
	 * @Description: (导入文件)事件 
	 * @param evt     
	 * @return void     
	 */
	protected void jButton5ActionPerformed(ActionEvent evt) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showDialog(fileChooser, "导入");
		java.io.File file = fileChooser.getSelectedFile();
		if(file != null){
			if (file.length() > 1024 * 1024 * 1024) {
				JOptionPane.showConfirmDialog(null, "导入文件不能超过1GB！");
			} else {
				DataOperation.importFile(fileSystem, file, this);
				refleshPanel(fileSystem.getFolderMap().get(fileSystem.getFolder()).folderList);
			}
		}
	}

	/**
	 * @Title: jButton4ActionPerformed 
	 * @Description: (文本模式)事件 
	 * @param evt     
	 * @return void     
	 */
	protected void jButton4ActionPerformed(ActionEvent evt) {

		fileSystem.startText();

	}

	/**
	 * @Title: jButton3ActionPerformed 
	 * @Description: (搜索)事件 
	 * @param evt     
	 * @return void     
	 */
	protected void jButton3ActionPerformed(ActionEvent evt) {
		
		searchFlag = true;
		refleshPanel(FileIO.findFile(fileSystem, jTextField2.getText()));
		jTextField1.setText("搜索状态中...");
		
	}

	/**
	 * @Title: jButton2ActionPerformed 
	 * @Description: (前进)事件 
	 * @param evt     
	 * @return void     
	 */
	protected void jButton2ActionPerformed(ActionEvent evt) {

		
		
	}

	/**
	 * @Title: jButton1ActionPerformed 
	 * @Description: (返回)事件 
	 * @param evt     
	 * @return void     
	 */
	protected void jButton1ActionPerformed(ActionEvent evt) {
	
		if (!fileSystem.getFolder().equals(fileSystem.getUser().getName())) {
			fileSystem.setDirectory(fileSystem.getDirectory().substring(0,
					fileSystem.getDirectory().lastIndexOf("/")));
			//获取当前所在位置的文件夹名称
			fileSystem.setFolder(fileSystem.getDirectory().substring(
					fileSystem.getDirectory().lastIndexOf("/"),
					fileSystem.getDirectory().length()));
			fileSystem.setFolder(fileSystem.getFolder().substring(1,
					fileSystem.getFolder().length()));			
		}
		refleshPanel(fileSystem.getFolderMap().get(fileSystem.getFolder()).folderList);
		searchFlag = false;
		
	}

	private JLabel jlabel;
	private FileSystem fileSystem;
	/**
	 * @Fields fileRecord : 用来区别同名文件
	 */
	private int fileRecord = 0;
	/**
	 * @Fields searchFlag : true表示在搜索页面，false表示正常页面
	 */
	private boolean searchFlag = false;
	/**
	 * @Fields name : 文件（文件夹）名字
	 */
	private String name;
	/**
	 * @Fields file : 当前文件
	 */
	private File file;
	
                   
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
                
}
