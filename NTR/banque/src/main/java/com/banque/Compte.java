package com.banque;

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
public class Compte {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) //Automatique
	private int id;
	private String username;
	private String password;
	private float balance;	
	
	
	public int addBalance(float montant) {
		if (this.balance+montant>=0) {
			this.balance=this.balance+montant;
			return 0;
		}else {
			return 1;
		}
		
	}
}
