package poeiklee.RestaurantAmbulantBack.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import poeiklee.RestaurantAmbulantBack.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Optional<Product> findByLabel(String label);
	List<Product> findAllByMeals_mealId(int mealId);

}
