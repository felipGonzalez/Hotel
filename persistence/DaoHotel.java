package persistence;

import model.Hotel;
import model.Site;

public class DaoHotel {

	 public static final int RECORD_SIZE = 96;
	 public static final int NAME_LENGHT = 15;
	    public static final int NAME_LARGE_LENGHT = 15;
	    public static final int ADDRESS_LENGHT = 15;
	    public static final int TELEPHONE_LENGHT = 10;
	    public static final int URL_LENGHT = 26;
	    public static final int EMAIL_LENGHT = 15;
	    public static final int RECORD_NULL = -1;	
	    
	    private byte[] name;// nombre   15
	    private byte[] namelarge; //      15
	    private byte[] address;// direccion 15
	    //private Site  site;
	    private byte[] telephone;// telefono 10
	    private byte[] url;//direccion de pagina 26
	    private byte[] email;//email    15
	    
	    
	    public DaoHotel() {
	    	
	    }
	    
	    public DaoHotel(Hotel hotel) {
	    	this.name = stringToArray(hotel.getName() , NAME_LENGHT);;
			this.namelarge =stringToArray(hotel.getNamelarge(), NAME_LARGE_LENGHT);
			this.address = stringToArray(hotel.getAddress(), ADDRESS_LENGHT);
			this.telephone = stringToArray(hotel.getTelephone(), TELEPHONE_LENGHT);
			this.url =stringToArray(hotel.getUrl(), URL_LENGHT);
			this.email = stringToArray(hotel.getEmail(), EMAIL_LENGHT);
	    }
	    
	    

	    public DaoHotel(String name, String namelarge,String address, String telephone, String url, String email) {
			this.name =stringToArray( name, NAME_LENGHT);
			this.namelarge =stringToArray(namelarge, NAME_LARGE_LENGHT);
			this.address = stringToArray(address, ADDRESS_LENGHT);
			this.telephone = stringToArray(telephone, TELEPHONE_LENGHT);
			
			this.url =stringToArray(url, URL_LENGHT);
			this.email = stringToArray(email, EMAIL_LENGHT);
		}

		private  byte [] stringToArray(String string, int size){
	    	byte [] array = new byte[size];
	    	for (int i = 0; i < Math.min(string.length(), size); i++) {
	    		array[i] = (byte)string.charAt(i);
	        }
	    	
	    	return array;
	    }
	    
	    private String arrayToString(byte [] array, int size) {
	    	String string = "";
	    	for (int i = 0; i < size; i++) {
	            string += (char)array[i];
	        }
	    	return string;
	    }
	    
	    
	   public Hotel getHotel() {
		   return new Hotel(getNameString(),getNamelargeString(),getAddressString(),
				   null,getTelephoneString(), getUrlString(), getEmailString());
	   }

	public byte[] getName() {
		return name;
	}

	public String getNameString() {
		return arrayToString(name, NAME_LENGHT);
	}
	
	public void setName(String name) {
		this.name = stringToArray( name, NAME_LENGHT);
	}

	public byte[] getNamelarge() {
		return namelarge;
	}

	public String getNamelargeString() {
		return arrayToString(namelarge,NAME_LARGE_LENGHT );
	}
	
	public void setNamelarge(String namelarge) {
		this.namelarge = stringToArray(namelarge, NAME_LARGE_LENGHT);
	}

	public byte[] getAddress() {
		return address;
	}

	public String getAddressString() {
		return arrayToString(address, ADDRESS_LENGHT);
	}
	
	public void setAddress(String address) {
		this.address = stringToArray(address, ADDRESS_LENGHT);
	}

	public byte[] getTelephone() {
		return telephone;
	}

	public String getTelephoneString() {
		return arrayToString(telephone,TELEPHONE_LENGHT );
	}
	
	public void setTelephone(String telephone) {
		this.telephone = stringToArray(telephone, TELEPHONE_LENGHT);
	}

	public byte[] getUrl() {
		return url;
	}

	public String getUrlString() {
		return arrayToString(url, URL_LENGHT);
	}
	
	public void setUrl(String  url) {
		this.url = stringToArray(url, URL_LENGHT);
	}

	public byte[] getEmail() {
		return email;
	}

	public String getEmailString() {
		return arrayToString(email, EMAIL_LENGHT);
	}
	
	public void setEmail(String email) {
		this.email =  stringToArray(email, EMAIL_LENGHT);
	}

	public void setNameArray(byte[] name) {
		this.name = name;
	}

	public void setNamelargeArray(byte[] namelarge) {
		this.namelarge = namelarge;
	}

	public void setAddressArray(byte[] address) {
		this.address = address;
	}

	public void setTelephoneArray(byte[] telephone) {
		this.telephone = telephone;
	}

	public void setUrlArray(byte[] url) {
		this.url = url;
	}

	public void setEmailArray(byte[] email) {
		this.email = email;
	}
	    
	    
	
	
}
