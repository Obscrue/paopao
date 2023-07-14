package com.tedu.element;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import com.tedu.manager.ElementManager;
import com.tedu.manager.GameElement;

/**
 * @author 
 *@说明 物体类（可炸掉）
 */
public class Obstacle extends ElementObj{
	private ElementManager em=ElementManager.getManager();
	@Override
	public void showElement(Graphics g) {
			g.drawImage(this.getIcon().getImage(), this.getX(),this.getY(), 
					this.getW(),this.getH(), null);
	}
	
	@Override
	public ElementObj createElement(String str) {
		String []arr=str.split(",");
		ImageIcon icon=null;
		Random random=new Random();
		int i=random.nextInt(7);//0-6分别代表不同障碍
		icon = new ImageIcon("image/"+i+".png");
		this.setIcon(icon);
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
	
	
	
	
	/**
	 * 物体被炸掉后调用此方法 掉落道具或者不掉落道具
	 */
	public void layObject(int x,int y) {
//		随机生成一个道具
		Random random=new Random();
		int j=random.nextInt(10);
		if(j<4)
		{
			ElementObj element = new BlueBottle().createElement("x:"+x+",y:"+y);
			em.addElement(element, GameElement.BLUEBOTTLE);
		}
		if(j>=4&&j<8)
		{
			ElementObj element2 = new PurpleHead().createElement("x:"+x+",y:"+y);
			em.addElement(element2, GameElement.PURPLEHEAD);
		}
		else
		{
			return;
		}
		
	}
	
	

}
