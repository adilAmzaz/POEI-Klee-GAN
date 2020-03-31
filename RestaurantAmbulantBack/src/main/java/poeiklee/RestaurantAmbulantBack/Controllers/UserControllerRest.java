package poeiklee.RestaurantAmbulantBack.Controllers;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poeiklee.RestaurantAmbulantBack.Models.Company;
import poeiklee.RestaurantAmbulantBack.Models.Individual;
import poeiklee.RestaurantAmbulantBack.Models.User;
import poeiklee.RestaurantAmbulantBack.Repositories.CommandLineRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.CommandRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.CompanyRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.IndividualRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.ProductRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllerRest {

	@Autowired
	CompanyRepository companyRepo;
	
	@Autowired
	IndividualRepository individualRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CommandRepository commandRepo;
	
	@Autowired
	CommandLineRepository clr;
	@Autowired
	ProductRepository productRep;
	
	
	@RequestMapping("/remplir")
	public String hello(Model model)
	{

		return "Done";
	}

    @GetMapping(value = "/getindividuals")
    public List<Individual> getIndividuals() {

        List<Individual> individuals = individualRepo.findAll();

        return individuals;
    }

    @GetMapping(value = "/getusers")
    public List<User> getUsers() {

        List<User> users = userRepo.findAll();

        return users;
    }

    @GetMapping(value = "/getcompanies")
    public List<Company> getCompanies() {

        List<Company> companies = companyRepo.findAll();

        return companies;
    }

    @GetMapping("/getcompany/{email}")  
    public Company getCompanyByEmail(@PathVariable("email") String email)
    {
    	return companyRepo.findByEmail(email);
    }

    @GetMapping("/getuser/{email}")  
    public User getUserByEmail(@PathVariable("email") String email)
    {
    	return userRepo.findByEmail(email);
    }

    @GetMapping("/getindividual/{email}")  
    public Individual getIndividualById(@PathVariable("email") String email)
    {
    	
    	return individualRepo.findByEmail(email);
    }
    @GetMapping("/getuser-id/{id}")  
    public User getUserByEmail(@PathVariable("id") int id)
    {
    	Optional<User> user = userRepo.findById(id);
    	if (user.isPresent())
    		return user.get();
    	else
    		return null;
    }
    

    @PostMapping("/addUser")
    public ResponseEntity<Object> addUser(/*@Valid*/ @RequestBody User reqUser)
    {
    	System.out.println(">>> Create new User: " + reqUser);
    	if (reqUser.getEmail().isEmpty())
			return  new ResponseEntity<>("Email Obligatory", HttpStatus.BAD_REQUEST);
    	userRepo.save(reqUser);
		return new ResponseEntity<>("Added successfully",HttpStatus.OK);
    }
    
	@PostMapping("/addIndividual")
	public ResponseEntity<Object> addIndividual(@Valid @RequestBody Individual reqIndividual ) {

		if(reqIndividual.getEmail().isEmpty() )
			return  new ResponseEntity<>("Email Obligatory", HttpStatus.BAD_REQUEST);
		if( individualRepo.findById(reqIndividual.getUserId()).isPresent() )
			return  new ResponseEntity<>("Id already exist", HttpStatus.BAD_REQUEST);

		individualRepo.save(reqIndividual);
		return new ResponseEntity<>("added successfully",HttpStatus.OK);
	}

	@PostMapping("/addCompany")
	public ResponseEntity<Object> addCompany(@Valid @RequestBody Company reqCompany ) {
		if(reqCompany.getEmail().isEmpty())
			return  new ResponseEntity<>("Email Obligatory", HttpStatus.BAD_REQUEST);

		companyRepo.save(reqCompany);
		return new ResponseEntity<>("added successfully",HttpStatus.OK);
	}

	@DeleteMapping("/deleteuser")
	ResponseEntity<Object> deleteUser(@PathVariable int id) {
		Optional<User> u = userRepo.findById(id);
		if(u.isPresent()) {
			userRepo.deleteById(id);
			return new ResponseEntity<>("user deleted"+u.toString(),HttpStatus.OK);
		}
		return new ResponseEntity<>("user not found",HttpStatus.OK);
	}

	@PutMapping("/modifyindividual/{id}")
	ResponseEntity<?> replaceIndividual(@RequestBody Individual newUser, @PathVariable int id)  {
		 Optional<Company> company;
		 Optional<Individual> individual;
		/*if(newUser instanceof Company) {
			company=  companyRepo.findById(id);
			if(!company.isPresent())
				return ResponseEntity.notFound().build();
			newUser.setUserId(id);
			companyRepo.save((Company) newUser);
			return new ResponseEntity<>("new user added successfully : "+(Company)newUser,HttpStatus.OK);
		}*/
		if(newUser instanceof Individual) {
			individual = individualRepo.findById(id);
			if(!individual.isPresent())
				  return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
			//newUser.setUserId(id);
			individualRepo.save((Individual)newUser);
			return new ResponseEntity<>("new user added successfully : "+(Individual)newUser,HttpStatus.OK);
		}
	  return new ResponseEntity<>("Accept only Individual entity",HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/modifycompany/{id}")
	ResponseEntity<?> replaceCompany(@RequestBody Company newUser, @PathVariable int id)  {
		 Optional<Company> company;
		 Optional<Individual> individual;
		if(newUser instanceof Company) {
			company=  companyRepo.findById(id);
			if(!company.isPresent())
				return ResponseEntity.notFound().build();
			//newUser.setUserId(id);
			companyRepo.save((Company) newUser);
			return new ResponseEntity<>("new user added successfully : "+(Company)newUser,HttpStatus.OK);
		}
		/*if(newUser instanceof Individual) {
			individual = individualRepo.findById(id);
			if(!individual.isPresent())
				  return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
			newUser.setUserId(id);
			individualRepo.save((Individual)newUser);
			return new ResponseEntity<>("new user added successfully : "+(Individual)newUser,HttpStatus.OK);
		}*/
	  return new ResponseEntity<>("Accept only  company entity",HttpStatus.BAD_REQUEST);

	}

    
}
