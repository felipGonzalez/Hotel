package IU;

import java.awt.Dimension;
import java.awt.Graphics;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelHotel extends JPanel{

	public JButton jButtonDeleteHotel;
	public JButton jButtonModifyHotel;
	public JButton jButtonLoad;
	public JButton jButtonAdd;
	public JButton jButtonSave;
	public JButton jButtonExit;
	
	public JPanelHotel(){
		this.jButtonDeleteHotel = new JButton("Borrar");
		this.jButtonModifyHotel = new JButton("Modificar");
		this.jButtonLoad = new JButton("Cargar");
		this.jButtonSave = new  JButton ("Guardar");
		this.jButtonAdd = new JButton("Agregar");
		this.jButtonExit = new JButton("salir");
		
		init();
	}
	
	public void init(){
		this.add(jButtonAdd);
		this.add(jButtonDeleteHotel);
		this.add(jButtonModifyHotel);
		this.add(jButtonLoad);
		this.add(jButtonSave);
		this.add(jButtonExit);
	}
	@Override
	public void paintComponent(Graphics g) {
		Dimension size = getSize();
		ImageIcon imageIcon = new ImageIcon("/Hotel/src/imagen/hotel.jpg");
		System.out.println(""+imageIcon.getImage());
		g.drawImage(imageIcon.getImage(), 0, 0, size.width,size.height,null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
