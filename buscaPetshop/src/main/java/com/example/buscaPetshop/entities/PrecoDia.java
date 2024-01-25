package com.example.buscaPetshop.entities;

import java.time.DayOfWeek;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;

@Embeddable
public class PrecoDia {
    @Column(name = "preco_dia_util_pequeno")
    private double precoDiaUtilPequeno;
    
    @Column(name = "preco_dia_util_grande")
    private double precoDiaUtilGrande;
    
    @Column(name = "preco_fim_semana_pequeno")
    private double precoFimSemanaPequeno;
    
    @Column(name = "preco_fim_semana_grande")
    private double precoFimSemanaGrande;

    public PrecoDia() {
    }

    public PrecoDia(double precoDiaUtilPequeno, double precoDiaUtilGrande, double precoFimSemanaPequeno, double precoFimSemanaGrande) {
        this.precoDiaUtilPequeno = precoDiaUtilPequeno;
        this.precoDiaUtilGrande = precoDiaUtilGrande;
        this.precoFimSemanaPequeno = precoFimSemanaPequeno;
        this.precoFimSemanaGrande = precoFimSemanaGrande;
    }

    public double getPrecoDiaUtilPequeno() {
        return precoDiaUtilPequeno;
    }

    public void setPrecoDiaUtilPequeno(double precoDiaUtilPequeno) {
        this.precoDiaUtilPequeno = precoDiaUtilPequeno;
    }

    public double getPrecoDiaUtilGrande() {
        return precoDiaUtilGrande;
    }

    public void setPrecoDiaUtilGrande(double precoDiaUtilGrande) {
        this.precoDiaUtilGrande = precoDiaUtilGrande;
    }

    public double getPrecoFimSemanaPequeno() {
        return precoFimSemanaPequeno;
    }

    public void setPrecoFimSemanaPequeno(double precoFimSemanaPequeno) {
        this.precoFimSemanaPequeno = precoFimSemanaPequeno;
    }

    public double getPrecoFimSemanaGrande() {
        return precoFimSemanaGrande;
    }

    public void setPrecoFimSemanaGrande(double precoFimSemanaGrande) {
        this.precoFimSemanaGrande = precoFimSemanaGrande;
    }

    public double calcularPreco(DayOfWeek diaSemana, int numeroCachorroPequeno, int numeroCachorroGrande) {
        double totalCusto = 0;
        if (diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY) {
            totalCusto += numeroCachorroPequeno * precoFimSemanaPequeno;
            totalCusto += numeroCachorroGrande * precoFimSemanaGrande;
        } else {
            totalCusto += numeroCachorroPequeno * precoDiaUtilPequeno;
            totalCusto += numeroCachorroGrande * precoDiaUtilGrande;
        }
        return totalCusto;
    }
}
