package arq.domain;

import javax.persistence.Entity;

@Entity
public class Shop extends AbstractEntity {

	//Variables
	private String name;
	private String location;
	private String address;
	private double latitude;
	private double longitude;

	//Constructor vacio.
	public Shop() {
	}

	//Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
