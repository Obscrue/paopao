package com.tedu.show;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.tedu.controller.GameListener;
import com.tedu.controller.GameListener2;
import com.tedu.controller.GameThread;

/**
 * @说明 开始面板	--开始游戏 --游戏说明
 * @author cm
 * 
 */

public class Startgame extends JFrame implements ActionListener {
    public static int GameX = 816;//GAMEX 
    public static int GameY = 638;
    public static int contentWidth;
    public static int contentHeight;

    JButton jb1;
    JButton jb2;
    Image background;
    JLabel jl;
  
    public Startgame() {
 
        JPanel jp = new JPanel(){
        	
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
//                g.drawImage(background, 0, 0, null);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
                
                
            }
        };
        jp.setPreferredSize(new Dimension(GameX, GameY));
        
        BoxLayout box = new BoxLayout(jp, BoxLayout.Y_AXIS);//垂直方向的布局
        jp.setLayout(box);
        
        // 加载背景图片
        ImageIcon bgIcon = new ImageIcon("image/title.png");
        
        background = bgIcon.getImage();
        
        jb1 = new JButton();
        jb1.addActionListener(this);
        jb1.setIcon(new ImageIcon("image/start.png"));

  
 
        jp.add(jb1);
        
     
      //intro
        ImageIcon img2 = new ImageIcon("image/introduce.png");
        
//        // 计算图片的宽度和高度
        int w = img2.getIconWidth();
        int h = img2.getIconHeight();
//        
        jb2 = new JButton();
        jb2.addActionListener(this);
        jb2.setIcon(new ImageIcon("image/info.png"));
    
  
 
        jp.add(jb2);
        jl = new JLabel(img2);
  
        Dimension size = jp.getSize();
        int x = size.width - w;
        int y = size.height - h;
        jl.setBounds(x, y, w, h);
        
        jl.setVisible(false);
        jp.add(jl);
        
        add(jp);
        setLayout(new FlowLayout());
        setTitle("泡泡堂");
        setSize(GameX, GameY);
        setLocationRelativeTo(null);//窗口居中
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //pack();
    }
 

    
    public void start() {
    	 SwingUtilities.invokeLater(() -> {
             new Startgame().setVisible(true);//启动菜单窗口
         });
    }
 

    
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        if (jb == jb1) {
            // 隐藏关闭菜单窗口
            this.setVisible(false);
            this.dispose();
            
            // 创建游戏窗口实例
            GameJFrame gj = new GameJFrame();

            // 创建游戏面板实例
            GameMainJPanel jp = new GameMainJPanel();
            
            // 实例化监听
            GameListener listener = new GameListener();
            GameListener2 listener2 = new GameListener2();
             //实例化主线程
            GameThread th = new GameThread();
            
            // 注入
            gj.setjPanel(jp);
            gj.setKeyListener(listener);
            gj.setKeyListener2(listener2);
            gj.setThread(th);
            
            // 显示游戏窗口
            gj.setVisible(true);
            
            // 启动游戏
            gj.start();
            
        }else if (jb == jb2) {
        	if (jl.isVisible()) {
                jl.setVisible(false);
            } else {
                jl.setVisible(true);
            }
        }
    }
    
    
}

