package Listeners;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import com.FIP.Main;

public class FIPComponentListener implements ComponentListener {

	@Override
	public void componentResized(ComponentEvent e){
		Main.WIDTH = Main.frame.getWidth();
		Main.HEIGHT = Main.frame.getHeight();
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
