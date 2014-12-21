package com.FIP;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import Interfaces.Tool;
import Listeners.FIPComponentListener;
import Listeners.FIPMotionListener;
import Tools.TestTool;

/**
 * 
 * @author Garrett
 *
 * FIP is just a little Image Processing Project I was wanting to work on
 * Going to make a little tool that can make adjustments to pictures,
 * create pictures, and basic image editing tools. FIP (Free Image Processing)
 * 
 */
public class Main extends JPanel{

	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JMenu toolMenu;
	private JMenu fileMenu;
	private JMenuBar menuBar;
	private JMenuItem testItem;
	private JMenuItem openFromURLItem;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem exitItem;
	private JFileChooser fileChooser;
	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	private Tool curTool;
	static String Downloads = "Downloads/";
	public int xOffset = 0, yOffset = 0;
	
	public Main(){
		FIPMotionListener fipListener = new FIPMotionListener(this);
		
		initMenus();
		initDirectories();
		frame.addMouseMotionListener(fipListener);
		frame.addMouseListener(fipListener);
		frame.addComponentListener(new FIPComponentListener());
		FIPImage.images = new ArrayList<FIPImage>();
	}
	
	@Override
	 public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		
	      if(curTool != null)
	    	  curTool.paint(g, this);
	      if(FIPImage.images.size() > 0){
	    	  for(int i = 0; i < FIPImage.images.size(); i++)
	    		  g.drawImage(FIPImage.images.get(i).getImage(), FIPImage.images.get(i).getX()+xOffset, FIPImage.images.get(i).getY()+yOffset, this);
	      }
	 }
	
	 private Image createImageWithText(){
		  BufferedImage bufferedImage = new 
	      BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
	      Graphics g = bufferedImage.getGraphics();
	
	      g.drawString("Emma smells like dangus", 20,20);
	      return bufferedImage;
	 }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main.frame = new JFrame("FIP");
		Main.frame.getContentPane().add(new Main());
		
		Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main.frame.setSize(Main.WIDTH, Main.HEIGHT);
		Main.frame.setVisible(true);
		Main.frame.setLocationRelativeTo(null);
	}
	
	private void initMenus(){
		menuBar = new JMenuBar();
		
		//File Menu
		fileMenu = new JMenu("File");
		
		//File MenuItems
		openItem = new JMenuItem("Open");
		openItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF FIPImage.images", "jpg", "gif");
				fileChooser.setFileFilter(filter);
				int returnVal = fileChooser.showOpenDialog(Main.frame);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					System.out.println("Opening File... " + fileChooser.getSelectedFile().getName());
					try{
						FIPImage.images.add(new FIPImage(ImageIO.read(fileChooser.getSelectedFile()), xOffset, yOffset));
					}catch(Exception ex){
						System.err.println("Error reading the file: " + ex);
					}
					repaint();
					
				}
				
				
			}
			
		});
		
		openFromURLItem = new JMenuItem("Open From URL");
		openFromURLItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String result = (String) JOptionPane.showInputDialog(Main.frame,"Enter in the URL", "FIP", JOptionPane.PLAIN_MESSAGE,null, null, "Google.com");
				String fileName = result.substring(result.lastIndexOf("/"),result.length());
				//Download image and display it...
				System.out.println("Downloading Image From: " + result);
				System.out.println("Putting Image in Downloads/ Folder");
				try{
					URL url = new URL(result);
					InputStream inputStream = url.openStream();
					OutputStream outputStream = new FileOutputStream(Main.Downloads + fileName.substring(1, fileName.length()));
					byte[] buffer = new byte[2048];
					int length = 0;
					while((length = inputStream.read(buffer)) != -1){
						outputStream.write(buffer, 0, length);
					}
					inputStream.close();
					outputStream.close();
				}catch(Exception ex){
					System.err.println("Error downloading the image... " + ex);
				}
				
			}
			
		});
		
		saveItem = new JMenuItem("Save");
		saveItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.err.println("Not Implemented Yet");
			}
			
		});
		
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		fileMenu.add(openItem);
		fileMenu.add(openFromURLItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		
		//Tool Menu
		toolMenu = new JMenu("Tools");
		testItem = new JMenuItem("Test");
		testItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				curTool = new TestTool(createImageWithText());
				repaint();
			}
			
		});
		
		toolMenu.add(testItem);
		menuBar.add(toolMenu);
		
		
		Main.frame.setJMenuBar(menuBar);
	}
	
	private void initDirectories(){
		File downloadDir = new File(Main.Downloads);

		  // if the directory does not exist, create it
		  if (!downloadDir.exists()) {
		    System.out.println("Creating directory: " + Main.Downloads);
		    boolean result = false;

		    try{
		        downloadDir.mkdir();
		        result = true;
		     } catch(SecurityException se){
		        //handle it
		     }        
		     if(result) {    
		       System.out.println("Directory created");  
		     }
		  }
	}

	
	public void incrementOffsets(int x, int y){
		xOffset += x;
		yOffset += y;
	}
	
	public int getYOffset(){
		return yOffset;
	}
	
	public int getXOffset(){
		return xOffset;
	}
}
