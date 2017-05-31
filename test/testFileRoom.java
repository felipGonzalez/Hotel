package test;

import model.Room;
import model.RoomNumber;
import model.Service;
import model.Site;
import model.StatusRoom;
import persistence.FileRoom;
import persistence.FileSite;
import persistence.OpenForm;

public class testFileRoom {
	
	public static void main(String[] args) {
		Service [] services = {new Service("Videobeam"),
				new Service("Aire Acondicionado")};
		Room room = new Room(new RoomNumber("RA", (byte)3, 2),
				0,"Sala informatica", StatusRoom.AVAILABLE,15, 
				services);
		
		Service [] services2 = {new Service("Televisor"),
				new Service("Incomodidad")};
		Room room2 = new Room(new RoomNumber("L", (byte)3, 3),
				0,"Sala informatica", StatusRoom.AVAILABLE,15, 
				services);
		
		Site site0 = new Site(57, (byte) 1, "Colombia", "Col", null);
		Site site1 = new Site(15001, (byte) 3, "tunja", "TUN", null);
		Site site2 = new Site(15, (byte) 2, "Boyaca", "BYC", site0);
		
//		FileRoom fileRoom = new FileRoom("d:/prueba/room.obj", OpenForm.WRITE);
//		fileRoom.open();
//		fileRoom.save(room);
//		fileRoom.save(room2);
//		fileRoom.close();
//		fileRoom = new FileRoom("d:/prueba/room.obj", OpenForm.READ);
//		fileRoom.open();
//		Room auxRoom = fileRoom.read();
//		System.out.println("nombre  " + auxRoom.getName() + "  estado " + auxRoom.getStatusRoom() + "  servicios " + auxRoom.getServices()[0].getName()+ " - "
//		+ auxRoom.getServices()[1].getName()+ " Numero de cuarto " + auxRoom.getRoomNumber().getBuilding() + "-" +auxRoom.getRoomNumber().getLevel() + "-" + auxRoom.getRoomNumber().getNumber());
//		auxRoom = fileRoom.read();
//		System.out.println("nombre  " + auxRoom.getName() + "  estado " + auxRoom.getStatusRoom() + "  servicios " + auxRoom.getServices()[0].getName()+ " - "
//				+ auxRoom.getServices()[1].getName()+ " Numero de cuarto " + auxRoom.getRoomNumber().getBuilding() + "-" +auxRoom.getRoomNumber().getLevel() + "-" + auxRoom.getRoomNumber().getNumber());
//		fileRoom.close();
		
		FileSite fileSite = new FileSite("e:/prueba/site.obj", OpenForm.WRITE);
		fileSite.open();
		fileSite.save(site1);
		fileSite.save(site2);
		fileSite.save(site0);
		fileSite.close();
		fileSite.setOpenForm(OpenForm.READ);
		fileSite.open();
		Site siteAux = fileSite.read();
		
		
		System.out.println("codigo " + siteAux.getCode()+ " tipo "+siteAux.getType()  
		+ " nombre " +siteAux.getName() + "  abreviatura " + siteAux.getAbreviate()+
		" level " +siteAux.getLevel() + " parent " + siteAux.getFullCodeVer1());
		siteAux = fileSite.read();
		System.out.println("-------------------------------------------------------");
		System.out.println("codigo " + siteAux.getCode()+ " tipo "+siteAux.getType()  
		+ " nombre " +siteAux.getName() + "  abreviatura " + siteAux.getAbreviate()+
		" level " +siteAux.getLevel() + " parent " +siteAux.getFullCodeVer1());
		System.out.println("-------------------------------------------------------");
		siteAux = fileSite.read();
		System.out.println("codigo " + siteAux.getCode()+ " tipo "+siteAux.getType()  
		+ " nombre " +siteAux.getName() + "  abreviatura " + siteAux.getAbreviate()+
		" level " +siteAux.getLevel() + " parent " +siteAux.getFullCodeVer1());
	}
	
	
}
