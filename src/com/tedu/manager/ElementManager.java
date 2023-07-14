package com.tedu.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tedu.element.ElementObj;

/**
 * @说明 本类是元素管理器，专门存储所有的元素，同时，提供方法
 * 给予视图和控制获取数据
 * @author 24390
 *@问题一：存储所有元素数据，怎么存放？ list map set 三大集合
 *@问题二：管理器是视图和控制要访问，管理器就必须只有一个，单例模式
 *
 */
//如果想获得某种类型的元素，需要用list=getElementsByKey（ge），然后在循环获取elementobj
public class ElementManager {
//	private List<Object> listMap;
//	private List<Object> listPlay;
	/*
	 * String 作为key 匹配所有的元素 play -> List<Object> listPlay
	 *                              enemy -> List<Object> listEnemy
	 * 枚举类型，当做map的key用来区分不一样的资源，用于获取资源
	 * List中元素的泛型应该是元素基类
	 * 所有元素都可以存放到map集合中，显示模块只需要获取到这个map就可以
	 * 显示是有的界面需要显示的元素（调用元素基类的showElement())
	 */
	private Map<GameElement, List<ElementObj>> gameElements;
	
	//getGameElements是获得整个map的
	public Map<GameElement, List<ElementObj>> getGameElements(){
		return gameElements;
	}
	
	//添加元素（多半由加载器调用），向map中加入物体
	public void addElement(ElementObj obj,GameElement ge) {
		//List<ElementObj> list = gameElements.get(ge);
		//list.add(obj);
		gameElements.get(ge).add(obj);//添加对象到集合中，按key值就行存储
	}
	
	//依据key返回list集合，取出某一类元素，返回list集合
	public List<ElementObj> getElementsByKey(GameElement ge){
		return gameElements.get(ge);
	}
	
	/*
	 * 单例模式：内存中有且只有一个实例
	 * 饿汉模式-是启动就自动加载实例
	 * 饱汉模式-是需要使用的时候才加载实例
	 * 
	 * 编写方式：
	 * 1.需要一个静态的属性（定义一个常量）单例的引用
	 * 2.提供一个静态的方法（返回这个实例）return 单例的引用
	 * 3.一般为防止其他人自己使用（类是可以实例化），所以会私有化构造方法
	 *   ElementManager em=new ElementManager();
	 */
	
	private static ElementManager EM=null;//引用
	// synchronized线程锁->保证本方法执行中只有一个线程
	public static ElementManager getManager() {
		if(EM == null) {//控制锁定
			EM = new ElementManager();
		}
		return EM;
	}
	
	private ElementManager() {//私有化构造方法
		init();//实例化方法
	}
//	static {//饿汉实例化对象 静态语句块是在类被加载的时候直接执行
//		EM = new ElementManager();//只会执行一次
//	}
	/*
	 * 本方法是为将来可能出现的功能扩展，重写init方法准备
	 */
	
	public void init() {//实例化在这里完成
		gameElements = new HashMap<GameElement, List<ElementObj>>();
		for(GameElement ge:GameElement.values()) {
			gameElements.put(ge, new ArrayList<ElementObj>());
		}
	}
	public void reinit(){
	    gameElements.clear();
	    init();
	}
}
