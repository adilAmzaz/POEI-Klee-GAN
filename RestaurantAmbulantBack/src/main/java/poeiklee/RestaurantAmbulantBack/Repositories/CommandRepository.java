package poeiklee.RestaurantAmbulantBack.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poeiklee.RestaurantAmbulantBack.Models.Command;

public interface CommandRepository extends JpaRepository<Command, Integer>{
	  @Query("select c from Command c where c.user.email = :emailAdresse ")
	  List<Command> findByEmailAddress(@Param("emailAdresse") String emailAdresse);	
}
