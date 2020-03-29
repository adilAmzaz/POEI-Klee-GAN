package poeiklee.RestaurantAmbulantBack.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(nullable=false,unique = true, length = 50)
	private String email;
	private String password;
	private String phone;
	private String address;
	private String zipcode;
	private String city;
	@JsonBackReference
	@Basic(fetch=FetchType.LAZY)
	@OneToMany(
		    mappedBy = "user",
		    cascade = CascadeType.ALL,
		    orphanRemoval = true,
		    fetch = FetchType.LAZY
		)
	private List<Command> commands = new ArrayList<Command>();
	
	
	public User(String email, String password, String phone, String adress, String zipcode, String city) {
		super();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	
	
	public List<Command> getCommands() {
		return commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
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
		builder.append(", getAddress()=");
		builder.append(getAddress());
		builder.append(", getZipcode()=");
		builder.append(getZipcode());
		builder.append(", getCity()=");
		builder.append(getCity());
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
