package model;

public class Hotel {
    
	private String name;// nombre
    private String namelarge;
    private String address;// direccion
    private Site  site;
    private String telephone;// telefono
    private String url;//direccion de pagina
    private String email;//email
	
    
     public Hotel() {
		}

	public Hotel(String name, String namelarge, String address, Site site, String telephone, String url, String email) {
		super();
		this.name = name;
		this.namelarge = namelarge;
		this.address = address;
		this.site = site;
		this.telephone = telephone;
		this.url = url;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamelarge() {
		return namelarge;
	}

	public void setNamelarge(String namelarge) {
		this.namelarge = namelarge;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		url = url;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		email = email;
	}
    
	
    
    
}
