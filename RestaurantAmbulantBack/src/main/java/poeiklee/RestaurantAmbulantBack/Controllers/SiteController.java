package poeiklee.RestaurantAmbulantBack.Controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poeiklee.RestaurantAmbulantBack.Models.Company;
import poeiklee.RestaurantAmbulantBack.Models.Individual;
import poeiklee.RestaurantAmbulantBack.Repositories.CompanyRepository;

@Controller
public class SiteController {

	@Autowired
	CompanyRepository cr;
	
	@RequestMapping("/acc")
	public String hello(Model model)
	{
		Company c = new Company(1, "company", "123", "phone", "addess", "zipecode", "city", "name");
		Individual i = new Individual(2, "email", "password", "phone", "address", "zipecode", "city", "latname", "fristname", true,   LocalDate.now(), true);
		System.out.println(c);
		System.out.println(i);
		cr.save(c);
		return "site/acc";
	}
}
