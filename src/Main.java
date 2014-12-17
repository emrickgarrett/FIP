import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Interfaces.Tool;
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
	static JFrame frame;
	private JMenu toolMenu;
	private JMenu fileMenu;
	private JMenuBar menuBar;
	private JMenuItem testItem;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem exitItem;
	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	private Tool curTool;
	
	public Main(){
		initMenus();
	}
	
	@Override
	 public void paint(Graphics g) {
	      if(curTool != null)
	    	  curTool.paint(g, this);
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
				// TODO Auto-generated method stub
				System.err.println("Not Implemented Yet");
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
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		
		//Tool Menu
		toolMenu = new JMenu("Tools");
		testItem = new JMenuItem("Test");
		testItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				curTool = new TestTool();
				repaint();
			}
			
		});
		toolMenu.add(testItem);
		menuBar.add(toolMenu);
		
		
		Main.frame.setJMenuBar(menuBar);
	}

}
