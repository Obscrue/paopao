package com.tedu.element;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * @author hao
 *@说明 不可爆障碍物类
 */
public class Wall extends ElementObj{
	private int imgx=0;
	private long imgtime=0;
	@Override
	public void showElement(Graphics g) {
		g.drawImage(this.getIcon().getImage(), this.getX(),this.getY(), 
				this.getW(),this.getH(), null);

	}

	@Override
	public ElementObj createElement(String str) {
		String []arr=str.split(",");
		ImageIcon icon=null;
			switch(arr[0]) {//设置图片信息 图片还未加载到内存中
			case "OBS1":icon = new ImageIcon("image/ob4.png");break;
			case "OBS2":icon = new ImageIcon("image/ob2.png");break;
			case "OBS3":icon = new ImageIcon("image/ob3.png");break;
			case "OBS4":icon = new ImageIcon("image/ob1.png");break;
		
			}
		int x=Integer.parseInt(arr[1]);
		int y=Integer.parseInt(arr[2]);
		int w=icon.getIconWidth();
		int h=icon.getIconHeight();
		this.setH(h);
		this.setW(w);
		this.setX(x);
		this.setY(y);
		this.setIcon(icon);
		return this;
	}
	
	
	
	
}
