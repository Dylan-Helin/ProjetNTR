package com.ecommerce;

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
public class CreateProduit {
    private String name;
	private int quantity;
	private float price;
	public String getName() {
		return this.name;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public float getPrice() {
		return this.price;
	}
	
}
