package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Constant.Constant;
import IU.JDialogForm;
import IU.JframeHotel;
import IU.ShowMessage;
import model.Hotel;
import model.HotelManager;
import model.OpenForm;
import persistence.DaoHotel;
import persistence.DaoSite;
import persistence.FileManager;
import persistence.FileOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;;

/**
 * 
 * @author Felipe Gonzalez Controllador
 *
 */
public class Controller implements ActionListener{

	private JframeHotel jframeHotel;// Frame principal
	private Hotel hotel;
	private FileOption fileOption;
	private DaoHotel daoHotel;
	private DaoSite daoSite;
	private HotelManager hotelManager;
	private ShowMessage message;
	private JDialogForm jDialogForm;
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public Controller(JframeHotel jframeHotel) {
		this.jframeHotel = jframeHotel;
		hotelManager = new HotelManager();
		message = new ShowMessage();
		initJdialogFrom();
		init();
	}

	public void init() {
		jframeHotel.getjPanelHotel().jButtonAdd.addActionListener(this);
		jframeHotel.getjPanelHotel().jButtonDeleteHotel.addActionListener(this);
		jframeHotel.getjPanelHotel().jButtonExit.addActionListener(this);
		jframeHotel.getjPanelHotel().jButtonLoad.addActionListener(this);
		jframeHotel.getjPanelHotel().jButtonSave.addActionListener(this);
		jframeHotel.getjPanelHotel().jButtonModifyHotel.addActionListener(this);
		
	}
	
	public void initJdialogFrom(){
		
		jDialogForm = new JDialogForm();
		jDialogForm.jButtonCancel.addActionListener(this);
		jDialogForm.jButtonOk.addActionListener(this);
	}
	
	public void loadSite() {
		FileOption fileOption = new FileOption("/Hotel/src/archive/MySitios.xyz");
		for (int i = 0; i < fileOption.getFile().length()/DaoSite.RECORD_SIZE; i++) {
			
		}
		
	}
	
	/**
	 * Captura los eventos del teclado
	 */
		public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jframeHotel.getjPanelHotel().jButtonAdd) {
			btAddDateActionPerformed();
		} else if (e.getSource() == jframeHotel.getjPanelHotel().jButtonExit) {
			jframeHotel.dispose();
		} else if (e.getSource() == jframeHotel.getjPanelHotel().jButtonLoad) {
			btloadDateActionPerformed();
		} else if (e.getSource() == jframeHotel.getjPanelHotel().jButtonSave) {
			btSaveAsActionPerformed();
		} else if (e.getSource() == jframeHotel.getjPanelHotel().jButtonModifyHotel) {

		} else if (e.getSource() == jframeHotel.getjPanelHotel().jButtonDeleteHotel) {

		} else if (e.getSource() == jDialogForm.jButtonCancel) {
			jDialogForm.dispose();
			initJdialogFrom();
		} else if (e.getSource() == jDialogForm.jButtonOk) {
			btOkDateActionPerformed();
		}

	}

	public void btAddDateActionPerformed() {
		jDialogForm.initJpanel();

	}

	public void btloadDateActionPerformed() {
		try {
			fileOption = new FileOption();
			fileOption.openFile();
			fileOption.open(OpenForm.READ);
			for (int i = 0; i < fileOption.getFile().length() / DaoHotel.RECORD_SIZE; i++) {
				hotelManager.add(fileOption.loadHotel(i));
			}
			if (hotelManager.getListHotel().length == fileOption.getFile().length() / DaoHotel.RECORD_SIZE) {
				message.showMessage(null, Constant.MESAGGE_CHARGE_COMPLETED);
			}
			fileOption.close();
		} catch (Exception e) {
			message.showMessage(null, "Error al cargar el archivo");
		}
	}

	public void btOkDateActionPerformed() {
		Boolean flag = true;
		if (!this.jDialogForm.getjTextFieldName().equals("") && !this.jDialogForm.getjTextFieldNameLarge().equals("")
				&& !this.jDialogForm.getjTextFieldAddress().equals("")
				&& !this.jDialogForm.getjTextFieldSite().equals("")
				&& !this.jDialogForm.getjTextFieldUrl().equals("")) {
			if (validateEmail(jDialogForm.getjTextFieldEmail())) {
				if (hotelManager.getValidationInt(this.jDialogForm.getjTextFieldTelephone())) {
					hotelManager.add(new Hotel(jDialogForm.getjTextFieldName(), jDialogForm.getjTextFieldNameLarge(),
							jDialogForm.getjTextFieldAddress(), null, jDialogForm.getjTextFieldTelephone(),
							this.jDialogForm.getjTextFieldUrl(), jDialogForm.getjTextFieldEmail()));
					jDialogForm.cleanJText();
					jDialogForm.dispose();
					message.showMessage(null, "Agregado correctamente");
				} else {
					message.showMessage(null, "Por favor verifique el Telefono");
				}

			} else {
				message.showMessage(null, "Por favor verifique el email");
			}
		} else {
			message.showMessage(null, "Por favor llene todos los datos");
		}
	}

	public boolean validateEmail(String regex) {
		Pattern pattern = Pattern.compile(PATTERN_EMAIL);
		Matcher matcher = pattern.matcher(regex);
		return matcher.matches();
	}

	/**
	 * guardar como
	 */
	public void btSaveAsActionPerformed() {
		fileOption = new FileOption();
		fileOption.savePaht();
		fileOption.open(OpenForm.WRITE);
		System.out.println(fileOption.getFile().getPath());
		if (fileOption.isSave()) {
			for (int i = 0; i < hotelManager.getListHotel().length; i++) {
				System.out.println(hotelManager.getListHotel()[i].getName());
				fileOption.saveHotel(hotelManager.getListHotel()[i], i);
			}
		} else {
			message.showMessage(null, "Error al guardar");
		}
		fileOption.close();
	}

	
}
