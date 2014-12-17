package Interfaces;

import java.awt.Graphics;

import javax.swing.JPanel;

public interface Tool {
	
	public boolean undo();
	public boolean close();
	public boolean apply();
	public boolean save();
	public boolean export();
	public void paint(Graphics g, JPanel panel);
	
}
