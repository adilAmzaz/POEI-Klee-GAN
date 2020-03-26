package poeiklee.RestaurantAmbulantBack.Controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    


    
}
