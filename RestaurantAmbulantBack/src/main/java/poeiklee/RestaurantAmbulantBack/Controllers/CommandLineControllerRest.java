package poeiklee.RestaurantAmbulantBack.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import poeiklee.RestaurantAmbulantBack.Models.CommandLine;
import poeiklee.RestaurantAmbulantBack.Models.Product;
import poeiklee.RestaurantAmbulantBack.Repositories.CommandLineRepository;

@RestController
public class CommandLineControllerRest {

	@Autowired
	CommandLineRepository clr;
	
	@GetMapping("/getcommandLines")
	public List<CommandLine> getCLR()
	{
		List<CommandLine> cl = clr.findAll();
		return cl;
	}
	
	@GetMapping("/getclbyid/{id}")
	public Optional<CommandLine> getProductById(@PathVariable("id") int id)
	{
		return clr.findById(id);
	}
	
	@PostMapping("/addcl")
	public ResponseEntity<Object> addIndividual(@Valid @RequestBody CommandLine reqCL ) {
		clr.save(reqCL);
		return new ResponseEntity<>("added successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecl/{id}")
	ResponseEntity<Object> deleteCL(@PathVariable int id) {
		Optional<CommandLine> u = clr.findById(id);
		if(u.isPresent()) {
			clr.deleteById(id);
			return new ResponseEntity<>("CL deleted"+u.toString(),HttpStatus.OK);
		}
		return new ResponseEntity<>("CL not found",HttpStatus.OK);
	}
	
	@PutMapping("/modifycl/{id}")
	ResponseEntity<?> replaceCL(@RequestBody CommandLine newCL, @PathVariable int id)  {
		 Optional<CommandLine> cl;
		if(newCL instanceof CommandLine) {
			cl=  clr.findById(id);
			if(!cl.isPresent())
				return ResponseEntity.notFound().build();
			newCL.setCommandLineId(id);
			clr.save(newCL);
			return new ResponseEntity<>("new CL added successfully : "+newCL,HttpStatus.OK);
		}

	  return new ResponseEntity<>("Accept only  CL entity",HttpStatus.BAD_REQUEST);

	}
}
