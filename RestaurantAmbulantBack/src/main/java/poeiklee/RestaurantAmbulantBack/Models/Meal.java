package poeiklee.RestaurantAmbulantBack.Models;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Meal {
	@Id
	private int mealId;
	private String name;
	private LocalTime beginHour;
	private LocalTime endHour;
	@ManyToMany
	private List<Product> products;
	public Meal()
	{
		
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
