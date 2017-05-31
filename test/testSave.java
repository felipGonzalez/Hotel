package test;

import model.OpenForm;
import model.Site;
import persistence.FileOption;

public class testSave {

	public static void main(String[] args) {
		Site site0 = new Site(57, (byte) 1, "Colombia", "Col", null);
		Site site1 = new Site(15001, (byte) 3, "Tunja", "TUN", null);
		Site site2 = new Site(15, (byte) 2, "Boyaca", "BYC", site0);
		Site site4 = new Site(15001, (byte) 1, "Bogota", "BOG", null);
		site1.setParent(site2);
		
		FileOption fileSite = new FileOption("e:/prueba/sitios.bin");
		fileSite.open(OpenForm.WRITE);
		fileSite.save(site0, 0);
		fileSite.save(site1, 1);
		fileSite.save(site2, 2);
		fileSite.save(site4, 3);
		fileSite.close();
		
		fileSite.bubleSort();
		//leer...
		fileSite.open(OpenForm.READ);
		Site site;
		for (int i = 0; i < 4; i++) {
			System.out.println("--------------------");
			System.out.println("ento " + i);
			
			System.out.println("tamaño " + fileSite.getFile().length());
			site = fileSite.load(i);
			
			System.out.println("registro " + i);
			System.out.println("Codigo " + site.getCode());
			System.out.println("Nivel " + site.getLevel());
			System.out.println("Nombre " + site.getName());
			System.out.println("Abreviado " + site.getAbreviate());
			System.out.println("padre " + site.getParent());
			//System.out.println("Codigo completo " + site.getFullCodeVer1());
			
		}
		fileSite.close();
	}
	
}
