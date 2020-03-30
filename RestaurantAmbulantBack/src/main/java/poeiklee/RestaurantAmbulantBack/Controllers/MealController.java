package poeiklee.RestaurantAmbulantBack.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import poeiklee.RestaurantAmbulantBack.Models.Meal;
import poeiklee.RestaurantAmbulantBack.Repositories.MealRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MealController {

	@Autowired
	MealRepository mealRepo;
	@GetMapping("/getmeals")
	public List<Meal> getProducts()
	{
		List<Meal> meals = mealRepo.findAll();
		return meals;
	}
	
	@GetMapping("/getmealbyid/{id}")
	public Optional<Meal> getProductById(@PathVariable("id") int id)
	{
		return mealRepo.findById(id);
	}
	
	@DeleteMapping("/deletemeal/{id}")
	ResponseEntity<Object> deleteProduct(@PathVariable int id) {
		Optional<Meal> u = mealRepo.findById(id);
		if(u.isPresent()) {
			mealRepo.deleteById(id);
			return new ResponseEntity<>("meal deleted"+u.toString(),HttpStatus.OK);
		}
		return new ResponseEntity<>("meal not found",HttpStatus.OK);
	}
	
	@PutMapping("/modifymeal/{id}")
	ResponseEntity<?> replaceProduct(@RequestBody Meal newMeal, @PathVariable int id)  {
		 Optional<Meal> meal;
		if(newMeal instanceof Meal) {
			meal=  mealRepo.findById(id);
			if(!meal.isPresent())
				return ResponseEntity.notFound().build();
			newMeal.setMealId(id);
			mealRepo.save(newMeal);
			return new ResponseEntity<>("new meal added successfully : "+meal,HttpStatus.OK);
		}

	  return new ResponseEntity<>("Accept only  meal entity",HttpStatus.BAD_REQUEST);

	}
}
