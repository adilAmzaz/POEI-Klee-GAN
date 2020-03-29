package poeiklee.RestaurantAmbulantBack.Models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class CommandLine {
	
	@Id
	private int commandLineId;
	@Basic(fetch=FetchType.LAZY)
	@ManyToOne
	private Product product;
	@JsonBackReference
	@Basic(fetch=FetchType.LAZY)
	@ManyToOne
	private Command command;
	private int quantity;
	private double effectivePrice;
	
	public CommandLine()
	{
		
	}
	public int getCommandLineId() {
		return commandLineId;
	}
	public void setCommandLineId(int commandLineId) {
		this.commandLineId = commandLineId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getEffectivePrice() {
		return effectivePrice;
	}
	public void setEffectivePrice(double effectivePrice) {
		this.effectivePrice = effectivePrice;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommandLine [getCommandLineId()=");
		builder.append(getCommandLineId());
		builder.append(", getProduct()=");
		builder.append(getProduct());
		builder.append(", getCommand()=");
		builder.append(getCommand());
		builder.append(", getQuantity()=");
		builder.append(getQuantity());
		builder.append(", getEffectivePrice()=");
		builder.append(getEffectivePrice());
		builder.append("]");
		return builder.toString();
	}
	
	
}
