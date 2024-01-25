package com.example.buscaPetshop.dto;

import com.example.buscaPetshop.entities.Petshop;

public class PetShopCustoDTO {
	 private Petshop petShop;
	    private double custoTotal;

	    public PetShopCustoDTO(Petshop petShop, double custoTotal) {
	        this.petShop = petShop;
	        this.custoTotal = custoTotal;
	    }
		

		public Petshop getPetShop() {
			return petShop;
		}

		public void setPetShop(Petshop petShop) {
			this.petShop = petShop;
		}

		public double getCustoTotal() {
			return custoTotal;
		}

		public void setCustoTotal(double custoTotal) {
			this.custoTotal = custoTotal;
		}
}
