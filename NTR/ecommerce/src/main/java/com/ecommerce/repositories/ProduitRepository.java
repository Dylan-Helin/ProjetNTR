package com.ecommerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.ecommerce.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer>{
	Optional<Produit> findById(Integer id);
}
