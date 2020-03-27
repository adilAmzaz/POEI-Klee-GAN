package poeiklee.RestaurantAmbulantBack.Models;

import javax.persistence.Entity;

@Entity
public class Product {
	@javax.persistence.Id
	private int Id;
	private String label;
	private String imageRelativePath;
	private String composition;
	private double price;
	private int stock;
	
	
	public Product()
	{
		
	}


	public Product(int id, String label, String imageRelativePath, String composition, double price, int stock) {
		super();
		Id = id;
		this.label = label;
		this.imageRelativePath = imageRelativePath;
		this.composition = composition;
		this.price = price;
		this.stock = stock;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getImageRelativePath() {
		return imageRelativePath;
	}


	public void setImageRelativePath(String imageRelativePath) {
		this.imageRelativePath = imageRelativePath;
	}


	public String getComposition() {
		return composition;
	}


	public void setComposition(String composition) {
		this.composition = composition;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [getId()=");
		builder.append(getId());
		builder.append(", getLabel()=");
		builder.append(getLabel());
		builder.append(", getImageRelativePath()=");
		builder.append(getImageRelativePath());
		builder.append(", getComposition()=");
		builder.append(getComposition());
		builder.append(", getPrice()=");
		builder.append(getPrice());
		builder.append(", getStock()=");
		builder.append(getStock());
		builder.append("]");
		return builder.toString();
	}
	
}
