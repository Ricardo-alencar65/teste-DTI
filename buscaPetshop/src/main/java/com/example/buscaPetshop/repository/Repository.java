package com.example.buscaPetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.buscaPetshop.entities.Petshop;


public interface Repository extends JpaRepository<Petshop, Long> {

}

