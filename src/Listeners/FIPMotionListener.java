package Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.FIP.FIPImage;
import com.FIP.Main;

public class FIPMotionListener implements MouseMotionListener, MouseListener{

	private final int compare = -1000000000;
	private int lastX = compare;
	private int lastY = compare;
	private Main main;
	private FIPImage selectedImage = null;
	
	public FIPMotionListener(Main main){
		this.main = main;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(lastX != compare && lastY != compare){
			if(selectedImage == null){
				main.incrementOffsets(lastX-e.getX(), lastY - e.getY());
			}else{
				selectedImage.incX(lastX-e.getX());
				selectedImage.incY(lastY-e.getY());
			}
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Clicked");
		if(e.getButton() == MouseEvent.BUTTON1){
			selectedImage = FIPImage.checkCollisions(e.getX(), e.getY(), main);
			if(selectedImage != null){
				System.err.println("Hey!");
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
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
