package test;

import model.Room;
import model.RoomNumber;
import model.Service;
import model.Site;
import model.StatusRoom;

public class testFileObject {

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
	}
	
}
