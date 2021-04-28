package com.banque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.banque.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer>{
	Optional<Compte> findById(Integer id);
	
	@Query("SELECT c FROM Compte bc WHERE c.username = ?1 and c.password = ?2")
	Optional<Compte> authentificate(String username, String password);
}
