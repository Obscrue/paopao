package com.tedu.show;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @说明 游戏窗体 主要实现的功能：关闭，显示，最大最小化
 * @功能说明：需要嵌入面板，启动主线程等等
 *  @author 
 *  @窗体说明 swing awt 窗体大小（记录用户上次使用软件的窗体样式）	
 *  @分析 1.面板绑定到窗体
 *  	  2.监听绑定
 *        3.游戏主线程启动
 *        4.显示窗体
 *        
 *  
 *  
 */

public class GameJFrame extends JFrame{
	
	 public class OverJPanel extends JPanel {
		    private ImageIcon img;
		    private int w;
		    private int h;
		    private GameJFrame parentFrame;

		    public OverJPanel(GameJFrame parentFrame) {
		        this.img = new ImageIcon("image/Gameovers.png");
		        this.w = 816;
		        this.h = 638;
		        this.parentFrame = parentFrame;
		        init();
		    }

		   
		}
	 
	 
	public static int GameX = 816;// 850
	public static int GameY = 638;//650
	
	
//	public static GameMainJPanel gamePanel;

	
	public static int contentWidth;
	public static int contentHeight;
	    
	private JPanel jPanel = null;//正在显示的面板
	private KeyListener keyListener=null;
	private KeyListener keyListener2=null;
	private MouseMotionListener mouseMotionListener = null;
	private MouseListener mouseListener = null;
	private Thread thread = null;//游戏主线程
	
	public GameJFrame() {

		init();
		
		
	}
	public void init() {
		this.setSize(GameX, GameY);//设置窗体大小
		this.setTitle("泡泡堂");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置退出并且关闭
		this.setLocationRelativeTo(null);//屏幕居中显示
		
		
		
		
		
		
		
	}
	
	/*窗体布局*/
	public void addButton() {

	}
	
	
	/**
	 *启动方法 
	*/
	public void start() {
		if(jPanel!=null) {
			this.add(jPanel);
		}
		if(keyListener != null) {
			this.addKeyListener(keyListener);
			this.addKeyListener(keyListener2);
		}
		if(thread!=null) {
			thread.start();//启动线程
		}
		//界面的刷新
		this.setVisible(true);//显示界面
		//如果jPanel是runnable的实体对象子类
		if(this.jPanel instanceof Runnable) {
			//已做类型转换判定，强制类型转换不会出错
//			new Thread((Runnable)this.jPanel).start();
			Runnable run = (Runnable)this.jPanel;
			Thread th = new Thread(run);
			th.start();
		}
	}
	
	/*set注入：ssm 通过set方法注入配置文件中读取的数据;将配置文件
	 * 中的数据赋值为类的属性
	 * 构造注入：需要配合构造方法
	 * spring 中ioc进行对象的自动生成，管理。
	 *  */
	public void setjPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}
	
	public void setKeyListener(KeyListener keyListener) {
		this.keyListener = keyListener;
	}
	public void setKeyListener2(KeyListener keyListener) {
		this.keyListener2 = keyListener;
	}
	public void setMouseMotionListener(MouseMotionListener mouseMotionListener) {
		this.mouseMotionListener = mouseMotionListener;
	}
	public void setMouseListener(MouseListener mouseListener) {
		this.mouseListener = mouseListener;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
	}


	
}

