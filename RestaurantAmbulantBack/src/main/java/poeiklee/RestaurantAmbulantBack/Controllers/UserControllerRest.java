package poeiklee.RestaurantAmbulantBack.Controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

import poeiklee.RestaurantAmbulantBack.Models.Command;
import poeiklee.RestaurantAmbulantBack.Models.CommandLine;
import poeiklee.RestaurantAmbulantBack.Models.Company;
import poeiklee.RestaurantAmbulantBack.Models.Individual;
import poeiklee.RestaurantAmbulantBack.Models.Product;
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
		Company c = new Company("company", "123", "phone", "addess", "zipecode", "city", "name");
		Company c2 = new Company("company2", "123", "phone", "addess", "zipecode", "city", "name");
		Company c3 = new Company("company3", "123", "phone", "addess", "zipecode", "city", "name");
		Company c4 = new Company("company4", "123", "phone", "addess", "zipecode", "city", "name");

		Individual i1 = new Individual("email1", "password", "phone", "address", "zipecode", "city", "latname", "fristname", true,   LocalDate.now(), true);
		Individual i3 = new Individual("email3", "password", "phone", "address", "zipecode", "city", "latname", "fristname", true,   LocalDate.now(), true);
		Individual i4 = new Individual("email4", "password", "phone", "address", "zipecode", "city", "latname", "fristname", true,   LocalDate.now(), true);
		Individual i5 = new Individual("email5", "password", "phone", "address", "zipecode", "city", "latname", "fristname", true,   LocalDate.now(), true);


		Command c1 = new Command(1, LocalDateTime.now(), LocalDateTime.now(), false, LocalDateTime.now(), false, "address", "zipeCode", "city");
		Command c6 = new Command(3, LocalDateTime.now(), LocalDateTime.now(), false, LocalDateTime.now(), false, "address", "zipeCode", "city");
		Command c7 = new Command(4, LocalDateTime.now(), LocalDateTime.now(), false, LocalDateTime.now(), false, "address", "zipeCode", "city");
		Command c5 = new Command(5, LocalDateTime.now(), LocalDateTime.now(), false, LocalDateTime.now(), false, "address", "zipeCode", "city");
		c1.setUser(i3);
		c6.setUser(c3);
		c7.setUser(c3);
		c5.setUser(c3);
		Product p1 = new Product("label", "imageRelp", "comp", 12.0, 10);
		Product p2 = new Product("label", "imageRelp", "comp", 12.0, 10);
		Product p3 = new Product("label", "imageRelp", "comp", 12.0, 10);

		CommandLine cl = new CommandLine();
		cl.setCommand(c1);
		cl.setCommandLineId(1);
		cl.setEffectivePrice(10.2);
		cl.setProduct(p1);
		cl.setQuantity(2);
		
		CommandLine cl2 = new CommandLine();
		cl2.setCommand(c1);
		cl2.setCommandLineId(2);
		cl2.setEffectivePrice(10.2);
		cl2.setProduct(p1);
		cl2.setQuantity(2);		
		
	
		productRep.save(p1);
		productRep.save(p2);
		productRep.save(p3);
		individualRepo.save(i3);

		companyRepo.save(c2);
		companyRepo.save(c);
		companyRepo.save(c3);
		companyRepo.save(c4);
		
		//individualRepo.save(i);
		individualRepo.save(i1);
		individualRepo.save(i3);
		individualRepo.save(i4);
		individualRepo.save(i5);
		commandRepo.save(c1);
		commandRepo.save(c6);
		commandRepo.save(c7);
		commandRepo.save(c5);
		
		clr.save(cl);
		clr.save(cl2);
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
