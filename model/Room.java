package model;

import java.io.Serializable;

public class Room implements Serializable{

	private RoomNumber roomNumber;
	private int type;// sencillo, suite, apto
	private String name;
	private StatusRoom statusRoom;
	private int capacity;
	private Service [] services;
	
	public Room(RoomNumber roomNumber, int type, String name, StatusRoom statusRoom, int capacity, Service[] services) {
		super();
		this.roomNumber = roomNumber;
		this.type = type;
		this.name = name;
		this.statusRoom = statusRoom;
		this.capacity = capacity;
		this.services = services;
	}

	public RoomNumber getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(RoomNumber roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StatusRoom getStatusRoom() {
		return statusRoom;
	}

	public void setStatusRoom(StatusRoom statusRoom) {
		this.statusRoom = statusRoom;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Service[] getServices() {
		return services;
	}

	public void setServices(Service[] services) {
		this.services = services;
	}
	
	
	
	
	
}
