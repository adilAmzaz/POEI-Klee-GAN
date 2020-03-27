package poeiklee.RestaurantAmbulantBack.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private int userId;
	@Column(nullable=false,unique = true, length = 50)
	private String email;
	private String password;
	private String phone;
	private String address;
	private String zipcode;
	private String city;
	
	
	
	public User(int userId, String email, String password, String phone, String adress, String zipcode, String city) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = adress;
		this.zipcode = zipcode;
		this.city = city;
	}
	
	public User()
	{
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return address;
	}
	public void setAdress(String adress) {
		this.address = adress;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [getUserId()=");
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
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
