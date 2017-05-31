package IU;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import Constant.Constant;

/**
 * crea el menu de opciones con sus items
 * @author Felipe Gonzalez
 *
 */
public class JMenuBarHotel extends JMenuBar{

	private static final long serialVersionUID = 2615971885304632276L;
	public JMenu jMenuArchive;
	public JMenu jMenuHelp;
	public JMenu jMenuSee;
	public JMenu jMenuEdition;
	
	public JMenuItem jItemExit;
	public JMenuItem jItemAdd;
	public JMenuItem jItemSave;
	public JMenuItem jItemLoad;
	public JMenuItem jItemDelete;
	public JMenuItem jItemModify;
	public JMenuItem jItemSearch;
	public JMenuItem jItemAbout;
	public JMenuItem jItemSpanish;
	public JMenuItem jItemEnglish;
	public JMenuItem jMenuItemHelp;
	
	public JMenuBarHotel() {
		init();
		setShortcut();
	}
	
	public void init(){
		this.jMenuArchive = new JMenu();
		this.jMenuEdition = new JMenu();
		this.jMenuSee = new JMenu();
		this.jMenuHelp = new JMenu();
		this.jItemExit = new JMenuItem();
		this.jItemAdd = new JMenuItem();
		this.jItemSave = new JMenuItem();
		this.jItemLoad = new JMenuItem();
		this.jItemDelete = new JMenuItem();
		this.jItemModify = new JMenuItem();
		this.jItemSearch = new JMenuItem();
		this.jItemAbout = new JMenuItem();
		this.jItemSpanish = new JMenuItem();
		this.jItemEnglish = new JMenuItem();
		this.jMenuItemHelp = new JMenuItem();
		
		this.jMenuArchive.setText(Constant.ARCHIVE);  
		this.jMenuEdition.setText(Constant.EDITION);
		this.jMenuSee.setText(Constant.SEE);
		this.jMenuHelp.setText(Constant.HELP);
		this.jItemExit.setText(Constant.EXIT);
		this.jItemAdd.setText(Constant.ADD);
		this.jItemSave.setText(Constant.SAVE);
		this.jItemLoad.setText(Constant.LOAD);
		this.jItemDelete.setText(Constant.DELETE);
		this.jItemModify.setText(Constant.MODIFY);
		this.jItemSearch.setText(Constant.SEARCH);
		this.jItemAbout.setText(Constant.ABOUT);
		this.jItemSpanish.setText(Constant.SPANISH);
		this.jItemEnglish.setText(Constant.ENGLISH);
		this.jMenuItemHelp.setText(Constant.HELP);
		
		this.add(jMenuArchive);
		this.add(jMenuEdition);
		this.add(jMenuSee);
		this.add(jMenuHelp);
		
		this.jMenuArchive.add(jItemSearch);
		this.jMenuArchive.add(jItemSave);
		this.jMenuArchive.add(jItemLoad);
		this.jMenuArchive.addSeparator();
		this.jMenuArchive.add(jItemExit);
		
		this.jMenuEdition.add(jItemAdd);
		this.jMenuEdition.add(jItemModify);
		this.jMenuEdition.add(jItemDelete);
		
		this.jMenuSee.add(jItemAbout);
		this.jMenuHelp.add(jMenuItemHelp);
		}
	/**
	 * agrega los atajos
	 */
	public void setShortcut(){
		this.jItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
		this.jItemAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		this.jItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		this.jItemLoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		this.jItemDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		this.jItemModify.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		this.jItemSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		this.jItemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, InputEvent.ALT_DOWN_MASK));
		this.jItemSpanish.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
		this.jItemEnglish.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_DOWN_MASK));
		this.jMenuItemHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
	}
	
}
