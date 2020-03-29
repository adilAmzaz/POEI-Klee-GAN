package poeiklee.RestaurantAmbulantBack.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import poeiklee.RestaurantAmbulantBack.Models.DayProduct;
import poeiklee.RestaurantAmbulantBack.Repositories.DayProductRepository;

@RestController
public class DayProductController {

	@Autowired
	DayProductRepository dpr;
	
	@GetMapping("/getdps")
	public List<DayProduct> getProducts()
	{
		List<DayProduct> dps = dpr.findAll();
		return dps;
	}
	
	@GetMapping("/getdpbyid/{id}")
	public Optional<DayProduct> getProductById(@PathVariable("id") int id)
	{
		return dpr.findById(id);
	}
	
	@DeleteMapping("/deletedp/{id}")
	ResponseEntity<Object> deleteProduct(@PathVariable int id) {
		Optional<DayProduct> u = dpr.findById(id);
		if(u.isPresent()) {
			dpr.deleteById(id);
			return new ResponseEntity<>("DayProduct deleted"+u.toString(),HttpStatus.OK);
		}
		return new ResponseEntity<>("DayProduct not found",HttpStatus.OK);
	}
	
	@PutMapping("/modifydp/{id}")
	ResponseEntity<?> replaceProduct(@RequestBody DayProduct newDayProduct, @PathVariable int id)  {
		 Optional<DayProduct> dp;
		if(newDayProduct instanceof DayProduct) {
			dp=  dpr.findById(id);
			if(!dp.isPresent())
				return ResponseEntity.notFound().build();
			newDayProduct.setId(id);
			dpr.save(newDayProduct);
			return new ResponseEntity<>("new dayproduct added successfully : "+newDayProduct,HttpStatus.OK);
		}

	  return new ResponseEntity<>("Accept only  dayproduct entity",HttpStatus.BAD_REQUEST);

	}
}
