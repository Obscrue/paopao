package com.tedu.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

/**
 * @说明 该类是游戏音乐播放器，继承自Thread类，可以在独立的线程中运行。
 * @author scm
 */
public class GameMusicPlayer extends Thread{
	private List<String> files;
	
	@Override
	public void run(){
		startMusic();
	}
	
	public GameMusicPlayer(){
		// 初始化音乐列表，添加要播放的音乐文件
		files = new ArrayList<String>();
        files.add("music/bgm.wav");

	}
	
	private void startMusic(){
		// 启动音乐播放循环
        int i=0;
        byte[] buffer = new byte[4096];
        while(true)
        {
            try
            {
            	// 读取音乐文件
            	File file = new File(files.get(i));
                InputStream stream = new FileInputStream(file);
                InputStream bufferedIn = new BufferedInputStream(stream);
                // 获取音频格式和输出设备
                AudioInputStream is = AudioSystem.getAudioInputStream(bufferedIn);
                AudioFormat format = is.getFormat();
                SourceDataLine line = AudioSystem.getSourceDataLine(format);
                line.open(format);
                line.start();
                
                // 循环写入音频数据
                while (is.available() > 0)
                {
                    int len = is.read(buffer);
                    line.write(buffer, 0, len);
                }
                // 关闭输出设备
                line.drain(); 
                line.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
	}

	public void start() {
		// TODO Auto-generated method stub
		super.start(); // 调用父类的 start 方法，启动线程
		
	}

}
