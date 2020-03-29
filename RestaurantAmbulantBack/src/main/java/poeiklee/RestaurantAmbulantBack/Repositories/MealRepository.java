package poeiklee.RestaurantAmbulantBack.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import poeiklee.RestaurantAmbulantBack.Models.Meal;

public interface MealRepository extends JpaRepository<Meal, Integer>{

}
