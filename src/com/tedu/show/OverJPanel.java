package com.tedu.show;



import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;






	public class OverJPanel extends JPanel {
	 private ImageIcon img;
	 private int w;
	 private int h;
	
	 
	 //构造函数
	 public OverJPanel(){
	  this.img = new ImageIcon("image/Gameovers.png");
	  this.w = 816;
	  this.h = 638;
	  init();
	 }
	
	 private void init() {
	
	  this.setLayout(null);
	  
	  JLabel jLabel = new JLabel(img);
	  img.setImage(img.getImage().getScaledInstance(w, h,Image.SCALE_DEFAULT ));
	  jLabel.setBounds(0, 0, w, h); 
	  
	  JButton restart = new JButton();
	  restart.setIcon(new ImageIcon("image/restart.png"));
	  restart.setBounds(w/2-90, h-h/4, 202, 83);
	  restart.setBorderPainted(false);
	  restart.setFocusPainted(false);
	  restart.setContentAreaFilled(false);
	  restart.addActionListener(new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent arg0) {
	    GameJFrame gj = new GameJFrame();
	    /*实例化面板，注入到jFrame中 */
	  Startgame bj = new Startgame();

	    gj.start();
	    bj.start();
	    
	   }
	  });
	 
	
	 
	  this.add(restart);
	  this.add(jLabel);
	  
	  this.setVisible(true);
	  this.setOpaque(true);
	 }


}
