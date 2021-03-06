package Interfaces;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import com.FIP.Main;

public interface Tool {
	
	public boolean undo();
	public boolean close();
	public boolean apply();
	public boolean save();
	public boolean export();
	public void setImage(Image g);
	public Image getImage();
	public void paint(Graphics g, Main main);
	
}
