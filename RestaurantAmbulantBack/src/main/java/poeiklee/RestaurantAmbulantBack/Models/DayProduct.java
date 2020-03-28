package poeiklee.RestaurantAmbulantBack.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public enum DayProduct {
	MONDAY,TUESDAY,WEDNESDAY,
	THUTSDAY,FRIDAY,SATURDAY,SUNDAY;
	
	@Id
	private int id;
	@ManyToMany
	List<Product> products;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
