package IU;

import javax.swing.JOptionPane;

public class ShowMessage {

	public void showMessage(JframeHotel jFrameViewPeople ,String message) {
		JOptionPane.showMessageDialog(jFrameViewPeople, message);
	}

	public int showOptionSelect(JframeHotel jFrameViewPeople ,String message) {
		return JOptionPane.showConfirmDialog(jFrameViewPeople, message);
	}
	
}
