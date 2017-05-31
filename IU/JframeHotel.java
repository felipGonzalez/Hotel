package IU;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JframeHotel extends JFrame{

	public static final int WIDTH_APP = 500;
	public static final int HEIGHT_APP = 500;
	
	private JPanelHotel jPanelHotel;
	private JPanel jPanelMain;
	public JMenuBarHotel jMenuBarHotel;
	
	public JframeHotel() {
		jPanelHotel = new JPanelHotel();
		jPanelMain = new JPanel(); 
		jMenuBarHotel = new JMenuBarHotel();
		init();
	}
	
	public void init(){
		this.setJMenuBar(jMenuBarHotel);
		this.add(jPanelHotel);
		this.setSize(WIDTH_APP, HEIGHT_APP);
		this.setTitle("Hotel Manager");
		this.setLocationRelativeTo(null);
		this.setResizable(false); 
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		
	}

	public JPanelHotel getjPanelHotel() {
		return jPanelHotel;
	}

	
	
	
}
