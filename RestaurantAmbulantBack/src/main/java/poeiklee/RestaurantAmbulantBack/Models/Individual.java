package poeiklee.RestaurantAmbulantBack.Models;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Individual extends User {

	private String lastName;
	private String firstName;
	private boolean female;
	private LocalDate birthDate;
	private boolean adminRights;
	
	public Individual()
	{
		
	}
	public Individual(int userId, String email, String password, String phone, String adress, String zipcode,
			String city, String lastName, String firstName, boolean female, LocalDate birthday,boolean adminRights) {
		super(userId, email, password, phone, adress, zipcode, city);
		this.lastName = lastName;
		this.firstName = firstName;
		this.female = female;
		this.birthDate = birthday;
		this.adminRights = adminRights;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public boolean isFemale() {
		return female;
	}
	public void setFemale(boolean female) {
		this.female = female;
	}
	public LocalDate getBirthday() {
		return birthDate;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthDate = birthday;
	}
	public boolean isAdminRights() {
		return adminRights;
	}
	public void setAdminRights(boolean adminRights) {
		this.adminRights = adminRights;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Individual [getLastName()=");
		builder.append(getLastName());
		builder.append(", getFirstName()=");
		builder.append(getFirstName());
		builder.append(", isFemale()=");
		builder.append(isFemale());
		builder.append(", getBirthday()=");
		builder.append(getBirthday());
		builder.append(", isAdminRights()=");
		builder.append(isAdminRights());
		builder.append(", getUserId()=");
		builder.append(getUserId());
		builder.append(", getEmail()=");
		builder.append(getEmail());
		builder.append(", getPassword()=");
		builder.append(getPassword());
		builder.append(", getPhone()=");
		builder.append(getPhone());
		builder.append(", getAdress()=");
		builder.append(getAdress());
		builder.append(", getZipcode()=");
		builder.append(getZipcode());
		builder.append(", getCity()=");
		builder.append(getCity());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append("]");
		return builder.toString();
	}
	
	

}
