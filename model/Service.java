package model;

import java.io.Serializable;

public class Service implements Serializable{
	private String name;

	public Service(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
