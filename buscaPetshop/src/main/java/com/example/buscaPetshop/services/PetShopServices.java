package com.example.buscaPetshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buscaPetshop.dto.PetShopCustoDTO;
import com.example.buscaPetshop.entities.Petshop;
import com.example.buscaPetshop.repository.Repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetShopServices {

	private final Repository petShopRepository;

	@Autowired
	public PetShopServices(Repository petShopRepository) {
		this.petShopRepository = petShopRepository;
	}

	public List<PetShopCustoDTO> findBestOptions(LocalDate date, int numberOfSmallDogs, int numberOfLargeDogs) {
        List<Petshop> petShops = petShopRepository.findAll();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return petShops.stream()
            .map(petShop -> new PetShopCustoDTO(
                petShop, 
                petShop.getPoliticaPreco().calcularPreco(dayOfWeek, numberOfSmallDogs, numberOfLargeDogs)
            ))
            .sorted(Comparator.comparingDouble(PetShopCustoDTO::getCustoTotal)
                .thenComparingDouble(dto -> dto.getPetShop().getDistancia()))
            .collect(Collectors.toList());
    }
}
