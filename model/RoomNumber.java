package model;

import java.io.Serializable;

public class RoomNumber implements Serializable{

	private String building;
	private byte level;
	private int number;
	public RoomNumber(String building, byte level, int number) {
		super();
		this.building = building;
		this.level = level;
		this.number = number;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public byte getLevel() {
		return level;
	}
	public void setLevel(byte level) {
		this.level = level;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}
