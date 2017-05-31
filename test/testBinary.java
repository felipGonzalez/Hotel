package test;

import model.OpenForm;
import model.Site;
import persistence.FileManager;
import persistence.FileOption;

public class testBinary {

	public static void main(String[] args) {
		Site site0 = new Site(57, (byte)1, "Colomnia", "Col", null);
		FileOption fileSite = new FileOption("d:/prueba/MySitios.txt");
		fileSite.open(OpenForm.WRITE);
		fileSite.save(site0, 0);
		
		
		
		
		fileSite.close();
	}
	
}
