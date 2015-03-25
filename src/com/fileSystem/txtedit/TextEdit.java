/**
 * @Title: TextEdit.java 
 * @Package com.txtedit.ui 
 * @Description: TODO 
 * @author  欧其平  
 * @date 2015年1月7日 下午4:14:00 
 * @version V1.0  
 */
package com.fileSystem.txtedit;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.JColorChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.fileSystem.FileSystem;
import com.fileSystem.util.FileIO;

/**
 * @ClassName: TextEdit 
 * @Description: 文本编辑器的UI和事件处理 
 * @author 欧其平
 * @date 2015年1月7日 下午4:26:26 
 */

 public class  TextEdit extends javax.swing.JFrame {

   
    /**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	public TextEdit(FileSystem fileSystem) {
        initComponents();
        this.fileSystem = fileSystem;
        name = fileSystem.getName();
        if(fileSystem.getBytes()!=null){
            textContent = new String(fileSystem.getBytes());           
        }
        jTextPane1.setText(textContent);
        this.setTitle(name);
        
        
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

   
    /**
     * @Title: initComponents 
     * @Description: UI组件，使用视图编辑直接生成      
     * @return void     
     */
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
         

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("文本编辑器");

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );

        jMenu1.setText("文件");
       
        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("新建");
        jMenuItem1.setEnabled(false);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("打开");
        jMenuItem2.setEnabled(false);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jMenuItem2ActionPerformed(evt);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("保存");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("编辑");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("撤销");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("重写");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("格式");

        jMenuItem6.setText("颜色");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        
        jMenuItem7.setText("字体");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ctionPerformed(evt);
            }

        });
        
        jMenuItem8.setText("大小");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ctionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);
        jMenu3.add(jMenuItem7);
        jMenu3.add(jMenuItem8);
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>

    /**
     * @Title: （按钮：新建）的动作 
     * @Description: 创建一个文件 
     * @param evt     
     * @return void     
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
    	
        
    }

    /**
     * @Title: （按钮：打开）的动作 
     * @Description: 打开文件并读出文件内容 
     * @param evt     
     * @return void     
     * @throws FileNotFoundException 
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException {
    	
				
    }

    /**
     * @Title: （按钮：保存）的动作 
     * @Description: 判断文件是否存在，若存在，则写入，不存在则创建再写入 
     * @param evt     
     * @return void     
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
    	
    		textContent = jTextPane1.getText();
    		FileIO.inputFile(fileSystem, name, textContent.getBytes());
    		jTextPane1.setText("保存成功！");
	}
 

    /**
     * @Title: （按钮：撤销）的动作 
     * @Description: 用识别空格的方法来进行单词的撤销 
     * @param evt     
     * @return void     
     */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {

    	/**
    	 * 以空格把文本分成多个单词，撤销变减少一个单词
    	 */  	 
    	String s[];
		sTemp = jTextPane1.getText();
		sRecord[record++] = jTextPane1.getText();
		reId = record;
    	s = sTemp.split(" ");
    	jTextPane1.setText("");
    	for (int i = 0; i < s.length - 1; i++){
    		jTextPane1.setText(jTextPane1.getText() + s[i] + " ");
    	}
    	
    	
    
    }

    /**
     * @Title: （按钮：重写）的动作 
     * @Description: 使用撤销前的数据进行还原 
     * @param evt     
     * @return void     
     */
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {

    	if (reId > 0)
    		jTextPane1.setText(sRecord[--reId]);
  
    }

    

	/**
	 * @Title: (按钮：颜色)的动作 
	 * @Description: 调用JColorChooser 
	 * @param evt     
	 * @return void     
	 */
	private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt ) {
		
		
		Color fontcolor=JColorChooser.showDialog(this,"字体颜色选择",jTextPane1.getForeground());
		  jTextPane1.setForeground(fontcolor);

	}

	/**
	 * @Title: (按钮：字体)的动作  
	 * @Description: 调用JOptionpane,把字体列表加入 ，获取用户选择的值
	 * @param evt     
	 * @return void     
	 */
	
	private void jMenuItem7ctionPerformed(ActionEvent evt) {
		
		GraphicsEnvironment ge =  GraphicsEnvironment.getLocalGraphicsEnvironment();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList fontNames = new JList(ge.getAvailableFontFamilyNames());
		
		int response = JOptionPane.showConfirmDialog(null, new JScrollPane(fontNames));
		
		
	    Object selectedFont = fontNames.getSelectedValue();
	    
		if (response == JOptionPane.YES_OPTION && selectedFont !=  null)  {   			
			Font font = new Font((String) selectedFont,Font.PLAIN,12);
			jTextPane1.setFont(font);
		}
	}

	/**
	 * @Title: (按钮：大小)的动作 
	 * @Description: 调用JOptionpane,把文本框加入 ，获取用户输入的值
	 * @param evt     
	 * @return void     
	 */
	private void jMenuItem8ctionPerformed(ActionEvent evt) {

		JTextField fontsizetext = new JTextField("12", 2);
		
		int response = JOptionPane.showConfirmDialog(null, fontsizetext,"输入字体大小",0);
		
		int size = Integer.valueOf(fontsizetext.getText());    
		
		if (response == JOptionPane.YES_OPTION && size > 0)  {   			
			Font font = new Font(null ,Font.PLAIN,size);
			jTextPane1.setFont(font);
		}
	}

	private FileSystem fileSystem;
	/**
	 * @Fields textContent : 文本内容
	 */
	private String textContent;
	/**
	 * @Fields name : 文件名
	 */
	private String name;
    
    private int reId = 0; //记录可以重写多少次
    private int record = 0; //记录撤销的次数
    private String sRecord[] = new String [20];	//记录撤销前的数据
    private String sTemp = null;

    // Variables declaration - do not modify
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration

}



