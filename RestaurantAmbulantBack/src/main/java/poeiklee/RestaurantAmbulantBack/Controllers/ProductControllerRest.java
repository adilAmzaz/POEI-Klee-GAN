package poeiklee.RestaurantAmbulantBack.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poeiklee.RestaurantAmbulantBack.Models.Actuality;
import poeiklee.RestaurantAmbulantBack.Models.Product;
import poeiklee.RestaurantAmbulantBack.Repositories.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductControllerRest {

	@Autowired
	ProductRepository productRepo;
	
	@RequestMapping("/remplirproduct")
	public String hello()
	{
		Product p1 = new Product("label", "imageRelativePath", "Composition", 10.0, 40);
		Product p2 = new Product("label2", "imageRelativePath", "Composition", 10.0, 40);
		Product p3 = new Product("label3", "imageRelativePath", "Composition", 10.0, 40);
		Product p4 = new Product("label4", "imageRelativePath", "Composition", 10.0, 40);
		Product p5 = new Product("label5", "imageRelativePath", "Composition", 10.0, 40);
		productRepo.save(p1);
		productRepo.save(p2);
		productRepo.save(p3);
		productRepo.save(p4);
		productRepo.save(p5);

		return "done";
	}
	@GetMapping("/products/all")
	public List<Product> getProducts()
	{
		List<Product> products = productRepo.findAll();
		return products;
	}
	
	@GetMapping("/products/{from}/{to}")
	public List<Product> findBetween(@PathVariable("from") int from, @PathVariable("to") int to) {
		List<Product> productsList = productRepo.findAll();
		productsList.sort(null);
		
		return productsList.subList(Math.min(from, productsList.size()), Math.min(to, productsList.size()));
	}
	
	@GetMapping("/products/{mealId}/{from}/{to}")
	public List<Product> findForBetween(@PathVariable("mealId") int mealId, @PathVariable("from") int from, @PathVariable("to") int to) {
		List<Product> productsList = productRepo.findAllByMeals_mealId(mealId);
		productsList.sort(null);
		
		return productsList.subList(Math.min(from, productsList.size()), Math.min(to, productsList.size()));
	}
	
	@GetMapping("/getproductbyid/{id}")
	public Optional<Product> getProductById(@PathVariable("id") int id)
	{
		return productRepo.findById(id);
	}
	
	@GetMapping("/getproductbylabel/{label}")
	public Optional<Product> getProductByLabel(@PathVariable("label") String label)
	{
		return productRepo.findByLabel(label);
	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<Object> addIndividual(@Valid @RequestBody Product reqProduct ) {
		productRepo.save(reqProduct);
		return new ResponseEntity<>("added successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	ResponseEntity<Object> deleteProduct(@PathVariable int id) {
		Optional<Product> u = productRepo.findById(id);
		if(u.isPresent()) {
			productRepo.deleteById(id);
			return new ResponseEntity<>("user deleted"+u.toString(),HttpStatus.OK);
		}
		return new ResponseEntity<>("user not found",HttpStatus.OK);
	}
	
	@PutMapping("/modifyproduct/{id}")
	ResponseEntity<?> replaceProduct(@RequestBody Product newProduct, @PathVariable int id)  {
		 Optional<Product> product;
		if(newProduct instanceof Product) {
			product=  productRepo.findById(id);
			if(!product.isPresent())
				return ResponseEntity.notFound().build();
			newProduct.setId(id);
			productRepo.save(newProduct);
			return new ResponseEntity<>("new product added successfully : "+newProduct,HttpStatus.OK);
		}

	  return new ResponseEntity<>("Accept only  product entity",HttpStatus.BAD_REQUEST);

	}
}
