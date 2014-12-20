package Tools;

import java.awt.Graphics;
import java.awt.Image;

import com.FIP.Main;

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
	public void paint(Graphics g, Main main) {
		if(toDraw == null) return;
		
		g.drawImage(toDraw, 20+main.getXOffset(), 20+main.getYOffset(), main);
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
