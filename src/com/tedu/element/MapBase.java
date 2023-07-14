package com.tedu.element;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * @author 
 *@说明 地板类
 */
public class MapBase extends ElementObj{
	
	@Override
	public void showElement(Graphics g) {
			g.drawImage(this.getIcon().getImage(), this.getX(),this.getY(), 
					this.getW(),this.getH(), null);
	}
	
	@Override
		public ElementObj createElement(String str) {
		String []arr=str.split(",");

		ImageIcon icon=null;
			switch(arr[0]) {//设置图片信息 
			case "GREY":icon = new ImageIcon("image/floor2.png");break;
			case "GREEN":icon = new ImageIcon("image/floor1.png");break;
			case "YELLOW":icon = new ImageIcon("image/floor3.png");break;
			case "ICE":icon = new ImageIcon("image/floor4.png");break;
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
