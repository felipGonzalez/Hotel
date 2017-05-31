package model;

public class HotelManager {

	private Hotel [] listHotel;
	
	public HotelManager() {
		listHotel = new Hotel[0];
	}

	
	
	public void add(Hotel holtel) {
		Hotel [] auxHotel = new Hotel[listHotel.length + 1];
		for (int i = 0; i < listHotel.length; i++) {
			auxHotel[i] = listHotel[i];
		}
		auxHotel[auxHotel.length -1] = holtel;
		this.listHotel = auxHotel;
	}
	
		
	public Hotel[] getListHotel() {
		return listHotel;
	}

	public void setListHotel(Hotel[] listHotel) {
		this.listHotel = listHotel;
	}
	
	public boolean getValidationInt(String line) {
		boolean flag;
		int i = 0;
		flag = true;
		while (i < line.length() && flag) {
			if (line.charAt(i) < 48 || line.charAt(i) > 58) {
				if (line.charAt(i) != 46 && line.charAt(i) != 69) {
					flag = false;
				}
			}
			i++;
		}
		return flag;
	}
	
}
