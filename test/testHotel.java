package test;

import model.Hotel;
import model.OpenForm;
import persistence.FileOption;

public class testHotel {

	public static void main(String[] args) {
		FileOption fileOption = new FileOption("e:/Sitios/MyHotel.xyz");
		fileOption.open(OpenForm.WRITE);
		
		Hotel hotel = new Hotel("DonFelip", "DonFelip", "calle-1#12", null, "3222265431",
				"www.DonFelip.com.co", "afelipgb@gmail.com");
		Hotel hotel2 = new Hotel("DonFelip", "DonFelip", "calle-1#12", null, "3222265431",
				"www.DonFelip.com.co", "felipeevilt@gmail.com");
		
		fileOption.saveHotel(hotel, 0);
		fileOption.saveHotel(hotel2, 1);
		fileOption.close();
		
		fileOption.open(OpenForm.READ);
		for (int i = 0; i < 2; i++) {
			Hotel hotel3 = fileOption.loadHotel(i);
			System.out.println("Nombre : " + hotel3.getName());
			System.out.println("Email : " + hotel3.getEmail());
		}
		fileOption.close();
	}
	
}
