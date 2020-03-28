package poeiklee.RestaurantAmbulantBack.Models;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
public class Company extends User {

	private String name;
	public Company(String email, String password, String phone, String adress, String zipcode,
			String city,String name) {
		super(email, password, phone, adress, zipcode, city);
		this.name = name;
	}
	
	public Company()
	{
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
