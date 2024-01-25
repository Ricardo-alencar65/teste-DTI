package com.example.buscaPetshop.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "PET_SHOP")
public class Petshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "distancia")
    private double distancia;
    
    @Embedded
    private PrecoDia politicaPreco;

    public Petshop() {
    }

    public Petshop(String nome, double distancia, PrecoDia politicaPreco) {
        this.nome = nome;
        this.distancia = distancia;
        this.politicaPreco = politicaPreco;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public PrecoDia getPoliticaPreco() {
        return politicaPreco;
    }

    public void setPoliticaPreco(PrecoDia politicaPreco) {
        this.politicaPreco = politicaPreco;
    }
}
