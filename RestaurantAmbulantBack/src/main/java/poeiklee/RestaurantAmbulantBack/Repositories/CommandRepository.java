package poeiklee.RestaurantAmbulantBack.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import poeiklee.RestaurantAmbulantBack.Models.Command;

public interface CommandRepository extends JpaRepository<Command, Integer>{

}
