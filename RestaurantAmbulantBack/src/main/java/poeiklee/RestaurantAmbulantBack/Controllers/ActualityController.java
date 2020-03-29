package poeiklee.RestaurantAmbulantBack.Controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import poeiklee.RestaurantAmbulantBack.Models.Actuality;
import poeiklee.RestaurantAmbulantBack.Repositories.ActualityRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ActualityController {

	@Autowired
	ActualityRepository actualityRepository;
	
	@GetMapping("/actuality/count")
	public long count() {
		return actualityRepository.count();
	}
	
	@GetMapping("/actuality/all")
	public List<Actuality> findAll() {
		List<Actuality> actualitiesList = actualityRepository.findAll();
		actualitiesList.sort(null);
		return actualitiesList;
	}
	
	@GetMapping("actuality/ids")
	public List<Integer> ids() {
		List<Actuality> actualitiesList = actualityRepository.findAll();
		actualitiesList.sort(null);
		return actualitiesList.stream().map(actuality -> actuality.getActualityId()).collect(Collectors.toList());
	}
	
	@GetMapping("/actuality/{from}/{to}")
	public List<Actuality> findBetween(@PathVariable("from") int from, @PathVariable("to") int to) {
		List<Actuality> actualitiesList = actualityRepository.findAll();
		actualitiesList.sort(null);
		return actualitiesList.subList(Math.min(from, actualitiesList.size()), Math.min(to, actualitiesList.size()));
	}
	
	@GetMapping("/actuality/{id}")
	public Optional<Actuality> findById(@PathVariable("id") int id) {
		return actualityRepository.findById(id);
	}
}
