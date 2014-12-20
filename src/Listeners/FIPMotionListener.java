package Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.FIP.Main;

public class FIPMotionListener implements MouseMotionListener, MouseListener{

	private final int compare = -1000000000;
	private int lastX = compare;
	private int lastY = compare;
	private Main main;
	
	public FIPMotionListener(Main main){
		this.main = main;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(lastX != compare && lastY != compare){
			main.incrementOffsets(lastX-e.getX(), lastY - e.getY());
		}
		lastX = e.getX();
		lastY = e.getY();
		main.invalidate();
		main.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		lastX = compare;
		lastY = compare;
		main.invalidate();
		main.repaint();
	}

}
