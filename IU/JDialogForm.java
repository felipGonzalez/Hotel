package IU;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Site;

public class JDialogForm extends JDialog{

	public JButton jButtonOk;
	public JButton jButtonCancel;
	private JLabel jLabelName;
	private JLabel jLabelNameLarge;
	private JLabel jLabelAddress;
	private JLabel jLabelSite;
	private JLabel jLabelTelephone;
	private JLabel jLabelUrl;
	private JLabel jLabelEmail;
	private JComboBox<Site> comboBoxSite;
	
	private JTextField jTextFieldName;
	private JTextField jTextFieldNameLarge;
	private JTextField jTextFieldAddress;
	private JTextField jTextFieldSite;
	private JTextField jTextFieldTelephone;
	private JTextField jTextFieldUrl;
	private JTextField jTextFieldEmail;

	private JPanel panelPrincipal;
	private JPanel panelInfo;
	private JPanel panelBoton;
	public static final int WIDTH_PANEL = 400;
	public static final int HEIGHT_PANEL= 600;

	public JDialogForm() {
		super(new Frame(), "Administrador Hotel", true);
		jButtonOk = new JButton("Aceptar");
		jButtonCancel = new JButton("Cancelar");
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);// opcional revisar por que el florez es un marica
	}
	
	public void initJpanel() {
		panelPrincipal = new JPanel(new BorderLayout());
		panelInfo = new JPanel(new GridLayout(14, 1,20,0));
		panelBoton = new JPanel(new FlowLayout());
		jLabelName = new JLabel("Nombre");
		jLabelNameLarge = new JLabel("Nombre La");
		jLabelAddress = new JLabel("dirrecion");
		jLabelSite = new JLabel("ciuddad");
		jLabelTelephone = new JLabel("telefono");
		jLabelUrl = new JLabel("url");
		jLabelEmail = new JLabel("email");

		jTextFieldName = new JTextField();
		jTextFieldNameLarge = new JTextField();
		jTextFieldAddress = new JTextField();
		jTextFieldSite = new JTextField();
		jTextFieldTelephone = new JTextField();
		jTextFieldUrl = new JTextField();
		jTextFieldEmail = new JTextField();
		comboBoxSite = new JComboBox<Site>();
		init();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	public void init() {
		panelBoton.add(jButtonOk);
		panelBoton.add(jButtonCancel);
		panelInfo.add(jLabelName);
		panelInfo.add(jTextFieldName);
		panelInfo.add(jLabelNameLarge);
		panelInfo.add(jTextFieldNameLarge);
		panelInfo.add(jLabelAddress);
		panelInfo.add(jTextFieldAddress);
		panelInfo.add(jLabelSite);
		panelInfo.add(jTextFieldSite);
		panelInfo.add(jLabelTelephone);
		panelInfo.add(jTextFieldTelephone);
		panelInfo.add(jLabelUrl);
		panelInfo.add(jTextFieldUrl);
		panelInfo.add(jLabelEmail);
		panelInfo.add(jTextFieldEmail);
		panelPrincipal.add("Center", panelInfo);
		panelPrincipal.add("South", panelBoton);
		this.getContentPane().add(panelPrincipal);
		this.setSize(WIDTH_PANEL, HEIGHT_PANEL);
		

	}

	public String getjTextFieldName() {
		return jTextFieldName.getText();
	}

	public void setjTextFieldName(JTextField jTextFieldName) {
		this.jTextFieldName = jTextFieldName;
	}

	public String getjTextFieldNameLarge() {
		return jTextFieldNameLarge.getText();
	}

	public void setjTextFieldNameLarge(JTextField jTextFieldNameLarge) {
		this.jTextFieldNameLarge = jTextFieldNameLarge;
	}

	public String getjTextFieldAddress() {
		return jTextFieldAddress.getText();
	}

	public void setjTextFieldAddress(JTextField jTextFieldAddress) {
		this.jTextFieldAddress = jTextFieldAddress;
	}

	public String getjTextFieldSite() {
		return jTextFieldSite.getText();
	}

	public void setjTextFieldSite(JTextField jTextFieldSite) {
		this.jTextFieldSite = jTextFieldSite;
	}

	public String getjTextFieldTelephone() {
		return jTextFieldTelephone.getText();
	}

	public void setjTextFieldTelephone(JTextField jTextFieldTelephone) {
		this.jTextFieldTelephone = jTextFieldTelephone;
	}

	public String getjTextFieldUrl() {
		return jTextFieldUrl.getText();
	}

	public void setjTextFieldUrl(JTextField jTextFieldUrl) {
		this.jTextFieldUrl = jTextFieldUrl;
	}

	public String getjTextFieldEmail() {
		return jTextFieldEmail.getText();
	}

	public void setjTextFieldEmail(JTextField jTextFieldEmail) {
		this.jTextFieldEmail = jTextFieldEmail;
	}

	public void cleanJText(){
		this.jTextFieldName.setText("");
		this.jTextFieldNameLarge.setText(""); 
		this.jTextFieldAddress.setText("");
		this.jTextFieldSite.setText("");
		this.jTextFieldTelephone.setText("");
		this.jTextFieldUrl.setText("");
		this.jTextFieldEmail.setText("");
	}
	
}