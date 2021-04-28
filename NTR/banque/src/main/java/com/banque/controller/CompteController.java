package com.banque.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.banque.*;
import com.banque.repositories.CompteRepository;



@RestController
public class CompteController {

	@Autowired
    CompteRepository compteRepository;

	/**
	 * récupère la liste de tous les comptes
	 * @return liste des comptes
	 */
	@GetMapping("comptes")
	public List<Compte> getAllComptes(){
		return compteRepository.findAll();
	}

	/**
	 * ajoute un compte dans la base de données
	 * @param compte
	 * @return le compte ajouté
	 */
	@PostMapping("comptes")
	public Compte createCompte(@Validated @RequestBody CreateCompte compte) {
	    return compteRepository.save(
	        Compte
	        .builder()
	        .username(compte.getUsername())
	        .password(compte.getPassword())
	        .balance(compte.getBalance())
            .build()
	    );
	}

	/**
	 * Augmente ou réduit le solde d'un compte
	 * @param id : l'ID du compte qu'on veut modifier
	 * @param montant : le montant qu'on veut ajouter ou soustraire au compte
	 * @return le compte modifié
	 */
	@PutMapping("/comptes/{id}/{montant}")
	public Optional<Compte> replaceCompteById(@PathVariable int id, @PathVariable float montant) {
		return compteRepository.findById(id)
	      .map(Compte -> {
	      Compte.addBalance(montant);
	      return compteRepository.save(Compte);
	    });
	}

	/**
	 * récupère un compte en fonction de son ID
	 * @param id : l'ID du compte qu'on veut récupérer
	 * @return le compte récupéré
	 */
	@GetMapping("comptes/{id}")
	public Optional<Compte> getCompteById(@PathVariable Integer id){
		return compteRepository.findById(id);
	}
	
	@GetMapping("comptes/{username}/{password}")
	public Optional<Compte> authentificate(@PathVariable String username, String password){
		return compteRepository.authentificate(username,password);
	}
}