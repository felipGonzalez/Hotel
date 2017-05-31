package test;

import model.Site;
import persistence.FileOption;

public class TestSite {

	public static void main(String[] args) {
		Site site0 = new Site(57, (byte) 1, "Colombia", "Col", null);
		Site site1 = new Site(15001, (byte) 3, "tunja", "TUN", null);
		Site site2 = new Site(15, (byte) 2, "Boyaca", "BYC", site0);
//		site1.setParent(site2);
//		System.out.println("max ");
		//System.out.println(site0.getFullCode() + "-->" + site0.getName());
		//System.out.println(site1.getFullCodeVer1() + "-->" + site1.getName());
		//System.out.println(site2.getFullCode() + "-->" + site2.getName());
		//System.out.println(site1.getFullCodeRecursive(0,(byte) 1, 1000));
		//System.out.println(site1.getFullCodeFabian() + "-->" + site1.getName());
		
		FileOption fileSite = new FileOption();
		System.out.println(fileSite.getAbreviate("Tunja")); 
		System.out.println(fileSite.getAbreviate("Bogota"));
		
	}
}
