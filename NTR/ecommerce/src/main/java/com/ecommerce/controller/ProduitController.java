package com.ecommerce.controller;

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

import com.ecommerce.*;
import com.ecommerce.repositories.ProduitRepository;


@RestController
public class ProduitController {

	@Autowired
    ProduitRepository produitsRepository;

	/**
	 * récupère la liste de tous les produits
	 * @return liste des produits
	 */
	@GetMapping("produits")
	public List<Produit> getAllProduits(){
		return produitsRepository.findAll();
	}

	/**
	 * ajoute un produit dans la base de données
	 * @param produit
	 * @return le produit ajouté
	 */
	@PostMapping("produits")
	public Produit createProduit(@Validated @RequestBody CreateProduit produit) {
	    return produitsRepository.save(
	        Produit
	        .builder()
	        .name(produit.getName())
	        .quantity(produit.getQuantity())
	        .price(produit.getPrice())
            .build()
	    );
	}

	/**
	 * réduit la quantité d'un produit
	 * @param id : l'ID du produit qu'on veut modifier
	 * @param montant : le montant qu'on veut soustraire a un produit
	 * @return le compte modifié
	 */
	@PutMapping("/produits/{id}/{montant}")
	public Optional<Produit> replaceProduitById(@PathVariable int id, @PathVariable int montant) {
		return produitsRepository.findById(id)
	      .map(Produit -> {
	      Produit.reduceQuantity(montant);
	      return produitsRepository.save(Produit);
	    });
	}

	/**
	 * récupère un produit en fonction de son ID
	 * @param id : l'ID du produit qu'on veut récupérer
	 * @return le produit récupéré
	 */
	@GetMapping("produits/{id}")
	public Optional<Produit> getProduitById(@PathVariable Integer id){
		return produitsRepository.findById(id);
	}
}