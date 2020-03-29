package poeiklee.RestaurantAmbulantBack.Models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Command {
	
	@Id
	private int commandId;
	@Basic(fetch=FetchType.LAZY)
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	private LocalDateTime orderDate;
	private LocalDateTime deliveryDate;
	private boolean delivered;
	private LocalDateTime deliverdDate;
	private boolean homeDelivery;
	private String address;
	private String zipecode;
	private String city;
	@OneToMany(
		    mappedBy = "command",
		    cascade = CascadeType.ALL,
		    orphanRemoval = true
		)
	List<CommandLine> commandLine;
	

	
	public Command() {
		
	}

	public Command(int commandId, LocalDateTime orderDate, LocalDateTime deliveryDate, boolean delivered,	
		LocalDateTime deliverdDate, boolean homeDelivery, String address, String zipecode, String city) {
		super();
		this.commandId = commandId;
		//this.userId = userId;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.delivered = delivered;
		this.deliverdDate = deliverdDate;
		this.homeDelivery = homeDelivery;
		this.address = address;
		this.zipecode = zipecode;
		this.city = city;
	}

	public List<CommandLine> getCommandLine() {
		return commandLine;
	}

	public void setCommandLine(List<CommandLine> commandLine) {
		this.commandLine = commandLine;
	}

	public int getCommandId() {
		return commandId;
	}

	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}
/*
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
*/
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public LocalDateTime getDeliverdDate() {
		return deliverdDate;
	}

	public void setDeliverdDate(LocalDateTime deliverdDate) {
		this.deliverdDate = deliverdDate;
	}

	public boolean isHomeDelivery() {
		return homeDelivery;
	}

	public void setHomeDelivery(boolean homeDelivery) {
		this.homeDelivery = homeDelivery;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipecode() {
		return zipecode;
	}

	public void setZipecode(String zipecode) {
		this.zipecode = zipecode;
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
		builder.append("Command [getCommandId()=");
		builder.append(getCommandId());
		builder.append(", getUser()=");
		builder.append(getUser());
		builder.append(", getOrderDate()=");
		builder.append(getOrderDate());
		builder.append(", getDeliveryDate()=");
		builder.append(getDeliveryDate());
		builder.append(", isDelivered()=");
		builder.append(isDelivered());
		builder.append(", getDeliverdDate()=");
		builder.append(getDeliverdDate());
		builder.append(", isHomeDelivery()=");
		builder.append(isHomeDelivery());
		builder.append(", getAddress()=");
		builder.append(getAddress());
		builder.append(", getZipecode()=");
		builder.append(getZipecode());
		builder.append(", getCity()=");
		builder.append(getCity());
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
