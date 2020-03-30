package poeiklee.RestaurantAmbulantBack.Models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Meal {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int mealId;
	private String name;
	private LocalTime beginHour;
	private LocalTime endHour;
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Product> products = new ArrayList<Product>();
	public Meal()
	{
		
	}

	public Meal(String name, LocalTime beginHour, LocalTime endHour) {
		this.name = name;
		this.beginHour = beginHour;
		this.endHour = endHour;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
		for (Product product : products)
			product.addMealNoLoop(this);
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
		product.addMealNoLoop(this);
	}
	public void addProductNoLoop(Product product) {
		this.products.add(product);
	}
	
	public void removeProduct(Product product) {
		this.products.remove(product);
		product.removeMealNoLoop(this);
	}
	public void removeProductNoLoop(Product product) {
		this.products.remove(product);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalTime getBeginHour() {
		return beginHour;
	}

	public void setBeginHour(LocalTime beginHour) {
		this.beginHour = beginHour;
	}

	public LocalTime getEndHour() {
		return endHour;
	}

	public void setEndHour(LocalTime endHour) {
		this.endHour = endHour;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Meal [getMealId()=");
		builder.append(getMealId());
		builder.append(", getName()=");
		builder.append(getName());
		builder.append(", getBeginHour()=");
		builder.append(getBeginHour());
		builder.append(", getEndHour()=");
		builder.append(getEndHour());
		builder.append("]");
		return builder.toString();
	}
	
	
}
