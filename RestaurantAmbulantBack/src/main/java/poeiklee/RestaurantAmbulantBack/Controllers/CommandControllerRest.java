package poeiklee.RestaurantAmbulantBack.Controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import poeiklee.RestaurantAmbulantBack.Models.Command;
import poeiklee.RestaurantAmbulantBack.Models.Company;
import poeiklee.RestaurantAmbulantBack.Models.Individual;
import poeiklee.RestaurantAmbulantBack.Repositories.CommandRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.CompanyRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.IndividualRepository;

@RestController
public class CommandControllerRest {

	@Autowired
	CommandRepository commandRepo;
	@Autowired
	CompanyRepository companyRep;
	@Autowired
	IndividualRepository individualRepo;
	@RequestMapping("/remplircommandes")
	public String remplir()
{	


		
		return "Done";
	}
	
	@GetMapping("/getcommands")
	public List<Command> getCommands()
	{
		List<Command> commands = commandRepo.findAll();
		return commands;
	}
	
	@GetMapping("/getcommandbyid/{id}")
	public Optional<Command> getCommandById(@PathVariable("id") int id)
	{
		return commandRepo.findById(id);
	}
	
	
	@PostMapping("/addcommand")
	public ResponseEntity<Object> addIndividual(@Valid @RequestBody Command reqCommand ) {
		commandRepo.save(reqCommand);
		return new ResponseEntity<>("added successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecommand/{id}")
	ResponseEntity<Object> deleteCommand(@PathVariable int id) {
		Optional<Command> u = commandRepo.findById(id);
		if(u.isPresent()) {
			commandRepo.deleteById(id);
			return new ResponseEntity<>("command deleted"+u.toString(),HttpStatus.OK);
		}
		return new ResponseEntity<>("command not found",HttpStatus.OK);
	}
	
	@PutMapping("/modifycommand/{id}")
	ResponseEntity<?> replaceCommand(@RequestBody Command newCommand, @PathVariable int id)  {
		 Optional<Command> command;
		if(newCommand instanceof Command) {
			command=  commandRepo.findById(id);
			if(!command.isPresent())
				return ResponseEntity.notFound().build();
			newCommand.setCommandId(id);
			commandRepo.save(newCommand);
			return new ResponseEntity<>("new command added successfully : "+newCommand,HttpStatus.OK);
		}

	  return new ResponseEntity<>("Accept only  product entity",HttpStatus.BAD_REQUEST);

	}
	
	
}
