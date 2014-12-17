package Tools;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Interfaces.Tool;

public class TestTool implements Tool {

	private Image toDraw;
	
	public TestTool(){
		toDraw = createImageWithText();
	}
	
	 private Image createImageWithText(){
		  BufferedImage bufferedImage = new 
	      BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
	      Graphics g = bufferedImage.getGraphics();
	
	      g.drawString("Emma smells like dangus", 20,20);
	      return bufferedImage;
	 }
	
	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean close() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean apply() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean export() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void paint(Graphics g, JPanel panel) {
		// TODO Auto-generated method stub
		g.drawImage(toDraw, 20, 20, panel);
	}

}
