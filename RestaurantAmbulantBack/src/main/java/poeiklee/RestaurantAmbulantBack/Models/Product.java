package poeiklee.RestaurantAmbulantBack.Models;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Product implements Comparable<Product> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int productId;
	private String label;
	private String imageRelativePath;
	private String composition;
	private double price;
	private int stock;
	private int count=0;
	@OneToMany(
		    mappedBy = "command",
		    cascade = CascadeType.ALL,
		    orphanRemoval = true
		)
	List<CommandLine> commandLine;
	@ManyToMany(fetch=FetchType.LAZY)
	List<Meal> meals;
	@ElementCollection
	List<DayOfWeek> days;
	public Product()
	{

	}


	public Product(String label, String imageRelativePath, String composition, double price, int stock) {
		this.label = label;
		this.imageRelativePath = imageRelativePath;
		this.composition = composition;
		this.price = price;
		this.stock = stock;
		meals = new ArrayList<Meal>();
		days = new ArrayList<DayOfWeek>();
	}
	public Product(String label, String imageRelativePath, String composition, double price, int stock, ArrayList<Meal> meals, ArrayList<DayOfWeek> days) {
		this.label = label;
		this.imageRelativePath = imageRelativePath;
		this.composition = composition;
		this.price = price;
		this.stock = stock;
		setMeals(meals);
		this.days = days;
	}
	public Product(String label, String imageRelativePath, String composition, double price, int stock, int count, ArrayList<Meal> meals, ArrayList<DayOfWeek> days) {
		this.label = label;
		this.imageRelativePath = imageRelativePath;
		this.composition = composition;
		this.price = price;
		this.stock = stock;
		this.count = count;
		setMeals(meals);
		this.days = days;
	}
	public Product(String label, String imageRelativePath, String composition, double price, int stock, int count, ArrayList<Meal> meals, DayOfWeek day) {
		this.label = label;
		this.imageRelativePath = imageRelativePath;
		this.composition = composition;
		this.price = price;
		this.stock = stock;
		this.count = count;
		setMeals(meals);
		days = new ArrayList<DayOfWeek>();
		days.add(day);
	}
	public List<CommandLine> getCommandLine() {
		return commandLine;
	}


	public void setCommandLine(List<CommandLine> commandLine) {
		this.commandLine = commandLine;
	}


	public List<Meal> getMeals() {
		return meals;
	}


	public void setMeals(List<Meal> meals) {
		this.meals = meals;
		for (Meal meal : meals)
			meal.addProductNoLoop(this);
	}
	
	public void addMeal(Meal meal) {
		this.meals.add(meal);
		meal.addProductNoLoop(this);
	}
	public void addMealNoLoop(Meal meal) {
		this.meals.add(meal);
	}
	
	public void removeMeal(Meal meal) {
		this.meals.remove(meal);
		meal.removeProductNoLoop(this);
	}
	public void removeMealNoLoop(Meal meal) {
		this.meals.remove(meal);
	}



	private void incrementCount()
	{
		count++;
	}

	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getProductId() {
		return productId;
	}


<<<<<<< HEAD
	public void setProductId(int id) {
=======
	public void setId(int id) {
>>>>>>> 18051abfa6aee1290516dfb6cf22158723099bb6
		productId = id;
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


	public List<DayOfWeek> getDays() {
		return days;
	}


	public void setDays(List<DayOfWeek> days) {
		this.days = days;
	}


	public void addDay(DayOfWeek day) {
		this.days.add(day);
	}
	
	public void removeDay(DayOfWeek day) {
		this.days.remove(day);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
<<<<<<< HEAD
		builder.append("Product [getId()=");
=======
		builder.append("Product [getProductId()=");
>>>>>>> 18051abfa6aee1290516dfb6cf22158723099bb6
		builder.append(getProductId());
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


	@Override
	public int compareTo(Product o) {
		return ((Integer)o.count).compareTo(this.count);
	}
	
}
