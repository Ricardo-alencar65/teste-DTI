package com.example.buscaPetshop.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.buscaPetshop.dto.PetShopCustoDTO;
import com.example.buscaPetshop.entities.Petshop;
import com.example.buscaPetshop.entities.PrecoDia;
import com.example.buscaPetshop.repository.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PetShopServicesTest {

    @Mock
    private Repository petShopRepository;

    @InjectMocks
    private PetShopServices petShopServices;

    @Test
    public void testPriceCalculation() {
        Petshop mockPetShop1 = mock(Petshop.class);
        Petshop mockPetShop2 = mock(Petshop.class);
        PrecoDia mockPrecoDia1 = mock(PrecoDia.class);
        PrecoDia mockPrecoDia2 = mock(PrecoDia.class);

        when(mockPetShop1.getPoliticaPreco()).thenReturn(mockPrecoDia1);
        when(mockPetShop2.getPoliticaPreco()).thenReturn(mockPrecoDia2);

        when(mockPrecoDia1.calcularPreco(any(), eq(2), eq(3))).thenReturn(160.0);
        when(mockPrecoDia2.calcularPreco(any(), eq(2), eq(3))).thenReturn(180.0);
        
        when(petShopRepository.findAll()).thenReturn(Arrays.asList(mockPetShop1, mockPetShop2));

        LocalDate testDate = LocalDate.of(2024, 1, 1); 
        int smallDogs = 2;
        int largeDogs = 3;

        List<PetShopCustoDTO> results = petShopServices.findBestOptions(testDate, smallDogs, largeDogs);

        assertNotNull(results);
        assertEquals(2, results.size());
        assertEquals(160.0, results.get(0).getCustoTotal());
        assertEquals(180.0, results.get(1).getCustoTotal());
    }
    @Test
    public void testEmptyRepositoryReturnsEmptyList() {
        when(petShopRepository.findAll()).thenReturn(Arrays.asList());

        LocalDate testDate = LocalDate.of(2024, 1, 1);
        int smallDogs = 2;
        int largeDogs = 3;

        List<PetShopCustoDTO> results = petShopServices.findBestOptions(testDate, smallDogs, largeDogs);

        assertTrue(results.isEmpty(), "A lista de resultados deve estar vazia");
    }
}
