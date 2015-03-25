/**
 * @Title: TextModel.java 
 * @Package com.fileSystem.ui 
 * @Description: TODO 
 * @author  欧其平  
 * @date 2015年3月5日 下午4:14:18 
 * @version V1.0  
 */
package com.fileSystem.ui;

import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.fileSystem.FileSystem;

/**
 * @ClassName: TextModel 
 * @Description: TODO 
 * @author 欧其平
 * @date 2015年3月5日 下午4:14:18 
 */
@SuppressWarnings("serial")
public class TextModel extends javax.swing.JFrame {

   
    public TextModel(FileSystem fileSystem) {
    	this.fileSystem = fileSystem;
        initComponents();
        this.setTitle("文件系统 v1.0  作者：欧其平");
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        
        jTextArea1.setText("create name(创建文件)\n"+"delete name(删除文件)\n"
        +"cd name(进入文件夹)\n"+"open name(打开文件)\n"+"dir(查看当前位置文件)\n"+"cd..(返回上一级)\n"+"mkdir name(创建文件夹)\n"+
        		"---------------分割线-------------\n"+fileSystem.getDirectory()+" #:");
        jTextArea1.setFont(new Font(null, Font.CENTER_BASELINE, 20));
        
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        
       

        pack();
    }                      


    /**
	 * @Title: jTextArea1KeyPressed 
	 * @Description: 按键事件 
	 * @param evt     
	 * @return void     
	 */
	protected void jTextArea1KeyPressed(KeyEvent evt) {

		if (evt instanceof KeyEvent) {
			KeyEvent e = (KeyEvent) evt;
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				fileSystem.textServer(this);				
			}
		}
		
	}

	
	/**
	 * @Title: getText 
	 * @Description: 获取文本框内容 
	 * @return     
	 * @return String     
	 */
	public String getText(){
		return jTextArea1.getText();
	}
	
	/**
	 * @Title: setText 
	 * @Description: 设置文本框内容 
	 * @param s     
	 * @return void     
	 */
	public void setText(String s){
		jTextArea1.setText(jTextArea1.getText()+s);
	}
	
	/**
	 * @Title: setText 
	 * @Description: 设置文本框内容为空      
	 * @return void     
	 */
	public void setText(){
		jTextArea1.setText("");
	}
	
	private FileSystem fileSystem;                  
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
               
}
