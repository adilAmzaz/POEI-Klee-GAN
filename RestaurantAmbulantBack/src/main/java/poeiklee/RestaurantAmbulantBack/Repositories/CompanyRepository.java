package poeiklee.RestaurantAmbulantBack.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import poeiklee.RestaurantAmbulantBack.Models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

	Company findByEmail(String email);

}
