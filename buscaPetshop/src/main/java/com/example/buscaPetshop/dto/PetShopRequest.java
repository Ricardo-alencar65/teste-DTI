package com.example.buscaPetshop.dto;

import java.time.LocalDate;

public class PetShopRequest {
    private LocalDate data;
    private int quantidadeCaesPequenos;
    private int quantidadeCaesGrandes;

    // Getters e Setters
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getQuantidadeCaesPequenos() {
        return quantidadeCaesPequenos;
    }

    public void setQuantidadeCaesPequenos(int quantidadeCaesPequenos) {
        this.quantidadeCaesPequenos = quantidadeCaesPequenos;
    }

    public int getQuantidadeCaesGrandes() {
        return quantidadeCaesGrandes;
    }

    public void setQuantidadeCaesGrandes(int quantidadeCaesGrandes) {
        this.quantidadeCaesGrandes = quantidadeCaesGrandes;
    }
}