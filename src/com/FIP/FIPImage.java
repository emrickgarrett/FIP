package com.FIP;

import java.awt.image.BufferedImage;

public class FIPImage{

	private BufferedImage image;
	private int xOffset = 0;
	private int yOffset = 0;
	
	public FIPImage(BufferedImage image, int x, int y){
		this.image = image;
		this.xOffset = x;
		this.yOffset = y;
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
	
}
