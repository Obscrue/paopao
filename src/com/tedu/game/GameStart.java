package com.tedu.game;

import com.tedu.controller.GameListener;
import com.tedu.controller.GameListener2;
import com.tedu.controller.GameMusicPlayer;
import com.tedu.controller.GameThread;

import com.tedu.show.GameJFrame;
import com.tedu.show.GameMainJPanel;
import com.tedu.show.Startgame;

public class GameStart {
	/**
	 * 程序的唯一入口
	 * @param args
	 */
	 public static Startgame gj;
	public  static void main(String[] args) {
		
		

	    gj = new Startgame();
	        /**实例化面板，注入到jframe中*/
	        GameMainJPanel jp = new GameMainJPanel();
//			实例化监听
	        GameListener listener = new GameListener();
	        GameListener2 listener2 = new GameListener2();
//			实例化主线程
	        GameThread th = new GameThread();
//		
		GameMusicPlayer musicPlayer = new GameMusicPlayer();
		musicPlayer.start();

	    gj.start();

	}
}

/**
 * 1.分析游戏，射击游戏的配置文件格式，文件读取格式（load格式）
 * 2.设计游戏角色，分析游戏需求（抽象基于基类的继承）
 * 3.开发pojo类(Vo)....
 * 4.需要的方法就在父类中重写（如果父类不支持，可以采用修改父类）
 * 5.检查配置，完成对象的load和add到Manager
 * 6.碰撞等等细节代码
 */


