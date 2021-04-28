package com.banque;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCompte {
    private String username;
	private String password;
	private float balance;
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
	public float getBalance() {
		return this.balance;
	}
	
}
