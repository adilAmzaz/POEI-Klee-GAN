package poeiklee.RestaurantAmbulantBack.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import poeiklee.RestaurantAmbulantBack.Models.Individual;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Integer> {

	Individual findByEmail(String email);

}
