package poeiklee.RestaurantAmbulantBack.Controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
import poeiklee.RestaurantAmbulantBack.Repositories.CompanyRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.IndividualRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.UserRepository;

@RestController
public class UserControllerRest {

	@Autowired
	CompanyRepository companyRepo;
	
	@Autowired
	IndividualRepository individualRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/remplir")
	public String hello(Model model)
	{
		Company c = new Company(1, "company", "123", "phone", "addess", "zipecode", "city", "name");
		Company c2 = new Company(2, "company2", "123", "phone", "addess", "zipecode", "city", "name");
		Company c3 = new Company(3, "company3", "123", "phone", "addess", "zipecode", "city", "name");
		Company c4 = new Company(4, "company4", "123", "phone", "addess", "zipecode", "city", "name");

		Individual i1 = new Individual(5, "email1", "password", "phone", "address", "zipecode", "city", "latname", "fristname", true,   LocalDate.now(), true);
		Individual i3 = new Individual(6, "email3", "password", "phone", "address", "zipecode", "city", "latname", "fristname", true,   LocalDate.now(), true);
		Individual i4 = new Individual(7, "email4", "password", "phone", "address", "zipecode", "city", "latname", "fristname", true,   LocalDate.now(), true);
		Individual i5 = new Individual(9, "email5", "password", "phone", "address", "zipecode", "city", "latname", "fristname", true,   LocalDate.now(), true);

		companyRepo.save(c2);
		companyRepo.save(c);
		companyRepo.save(c3);
		companyRepo.save(c4);
		
		//individualRepo.save(i);
		individualRepo.save(i1);
		individualRepo.save(i3);
		individualRepo.save(i4);
		individualRepo.save(i5);


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
    
    
	@PostMapping("/addIndividual")
	public ResponseEntity<Object> addIndividual(@Valid @RequestBody Individual reqIndividual ) {

		if(reqIndividual.getEmail().isEmpty())
			return  new ResponseEntity<>("Email Obligaory", HttpStatus.BAD_REQUEST);

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
	ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
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
			newUser.setUserId(id);
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
			newUser.setUserId(id);
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
