package poeiklee.RestaurantAmbulantBack.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import poeiklee.RestaurantAmbulantBack.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
