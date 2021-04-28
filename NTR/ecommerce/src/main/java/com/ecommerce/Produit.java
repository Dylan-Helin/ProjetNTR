package com.ecommerce;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Produit {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) //Automatique
	private int id;
	private String name;
	private int quantity;
	private float price;	
	
	
	public int reduceQuantity(int montant) {
		if (this.quantity-montant>=0) {
			this.quantity=this.quantity-montant;
			return 0;
		}else {
			return 1;
		}
		
	}
}
