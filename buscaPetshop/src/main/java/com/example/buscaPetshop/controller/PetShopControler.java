package com.example.buscaPetshop.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.buscaPetshop.dto.PetShopCustoDTO;
import com.example.buscaPetshop.services.PetShopServices;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PetShopControler {

    private final PetShopServices petShopService;

    @Autowired
    public PetShopControler(PetShopServices petShopService) {
        this.petShopService = petShopService;
    }

    @GetMapping("/best-options")
    public List<PetShopCustoDTO> findBestOptions(
        @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, 
        @RequestParam("cachorroPequeno") int numberOfSmallDogs, 
        @RequestParam("cachorroGrande") int numberOfLargeDogs) {
        return petShopService.findBestOptions(date, numberOfSmallDogs, numberOfLargeDogs);
    }
}

