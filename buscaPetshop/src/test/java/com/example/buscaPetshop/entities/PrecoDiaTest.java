package com.example.buscaPetshop.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;

public class PrecoDiaTest {

    @Test
    public void testaCalculoPrecoDiasDeSemana() {
        PrecoDia precoDia = new PrecoDia(20.0, 40.0, 24.0, 48.0); 

        DayOfWeek quartaFeira = DayOfWeek.WEDNESDAY;

        int numeroCaesPequenos = 2;
        int numeroCaesGrandes = 3;

        double totalEsperado = numeroCaesPequenos * 20.0 + numeroCaesGrandes * 40.0;

        double totalCalculado = precoDia.calcularPreco(quartaFeira, numeroCaesPequenos, numeroCaesGrandes);


        assertEquals(totalEsperado, totalCalculado);
    }
    @Test
    public void testaCalculoPrecoFinaisDeSemana() {
        PrecoDia precoDia = new PrecoDia(20.0, 40.0, 24.0, 48.0); 
        
        DayOfWeek sabado = DayOfWeek.SATURDAY;

        int numeroCaesPequenos = 2;
        int numeroCaesGrandes = 3;

        double totalEsperado = numeroCaesPequenos * 24.0 + numeroCaesGrandes * 48.0;

        double totalCalculado = precoDia.calcularPreco(sabado, numeroCaesPequenos, numeroCaesGrandes);

        assertEquals(totalEsperado, totalCalculado);
    }
    
    @Test
    public void testaCalculoPrecoTransicaoSextaParaSabado() {
        PrecoDia precoDia = new PrecoDia(20.0, 40.0, 24.0, 48.0); 

        DayOfWeek sexta = DayOfWeek.FRIDAY;
        DayOfWeek sabado = DayOfWeek.SATURDAY;

        int numeroCaesPequenos = 2;
        int numeroCaesGrandes = 3;

        double totalEsperadoSexta = numeroCaesPequenos * 20.0 + numeroCaesGrandes * 40.0;
        double totalEsperadoSabado = numeroCaesPequenos * 24.0 + numeroCaesGrandes * 48.0;

        double totalCalculadoSexta = precoDia.calcularPreco(sexta, numeroCaesPequenos, numeroCaesGrandes);
        double totalCalculadoSabado = precoDia.calcularPreco(sabado, numeroCaesPequenos, numeroCaesGrandes);

        assertEquals(totalEsperadoSexta, totalCalculadoSexta);
        assertEquals(totalEsperadoSabado, totalCalculadoSabado);
    }

    @Test
    public void testaCalculoPrecoTransicaoDomingoParaSegunda() {
        PrecoDia precoDia = new PrecoDia(20.0, 40.0, 24.0, 48.0); 

        DayOfWeek domingo = DayOfWeek.SUNDAY;
        DayOfWeek segunda = DayOfWeek.MONDAY;

        int numeroCaesPequenos = 2;
        int numeroCaesGrandes = 3;

        double totalEsperadoDomingo = numeroCaesPequenos * 24.0 + numeroCaesGrandes * 48.0;
        double totalEsperadoSegunda = numeroCaesPequenos * 20.0 + numeroCaesGrandes * 40.0;

        double totalCalculadoDomingo = precoDia.calcularPreco(domingo, numeroCaesPequenos, numeroCaesGrandes);
        double totalCalculadoSegunda = precoDia.calcularPreco(segunda, numeroCaesPequenos, numeroCaesGrandes);

        assertEquals(totalEsperadoDomingo, totalCalculadoDomingo);
        assertEquals(totalEsperadoSegunda, totalCalculadoSegunda);
    }

}

