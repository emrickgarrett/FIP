package Tools;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Interfaces.Tool;

public class TestTool implements Tool {

	private Image toDraw;
	private Image curImage;
	
	public TestTool(){
		toDraw = null;
	}
	
	public TestTool(Image curImage){
		this.curImage = curImage;
		toDraw = curImage;
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
		if(toDraw == null) return;
		
		g.drawImage(toDraw, 20, 20, panel);
	}
	
	@Override
	public void setImage(Image g){
		
		this.curImage = g;
	}

	@Override
	public Image getImage(){
		return curImage;
	}
	
}
