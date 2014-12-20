package com.FIP;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class FIPImage{

	private BufferedImage image;
	private int xOffset = 0;
	private int yOffset = 0;
	private int width;
	private int height;
	static public ArrayList<FIPImage> images;
	
	public FIPImage(BufferedImage image, int x, int y){
		this.image = image;
		this.xOffset = x;
		this.yOffset = y;
		this.width = image.getWidth();
		this.height = image.getHeight();
	}
	
	public int getX(){
		return xOffset;
	}
	
	public int getY(){
		return yOffset;
	}
	
	public void setX(int x){
		this.xOffset = x;
	}
	
	public void setY(int y){
		this.yOffset = y;
	}
	
	public void incX(int x){
		this.xOffset += x;
	}
	
	public void incY(int y){
		this.yOffset += y;
	}
	
	public BufferedImage getImage(){
		return this.image;
	}
	
	public void setImage(BufferedImage image){
		this.image = image;
	}
	
	public static FIPImage checkCollisions(int x, int y, Main main){
		//To simulate depth, it will check entire array and return last one. It's LIFO instead of FIFO
		FIPImage result = null;
		for(int i = 0; i < images.size(); i++){
			if(x+main.xOffset > images.get(0).xOffset && x+main.xOffset < images.get(0).xOffset+images.get(0).width && y+main.yOffset > images.get(0).yOffset && y+main.yOffset < images.get(0).yOffset+images.get(0).height)
				result =  images.get(0);
		}
		
		return result;
	}
	
}
