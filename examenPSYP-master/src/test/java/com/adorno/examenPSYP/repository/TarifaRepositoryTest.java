package com.adorno.examenPSYP.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.adorno.examenPSYP.entity.Tarifa;

@DataJpaTest
class TarifaRepositoryTest {

    @Autowired
    private TarifaRepository tarifaRepository;

    @Test
    @DisplayName("Debería encontrar una tarifa por su nombre")
    void testFindByNombre() {
        // Given
        Tarifa tarifa = Tarifa.builder()
                .nombre("Gold")
                .precio(59.99)
                .descripcion("Acceso VIP")
                .build();
        tarifaRepository.save(tarifa);

        // When
        Optional<Tarifa> encontrada = tarifaRepository.findByNombre("Gold");

        // Then
        assertTrue(encontrada.isPresent());
        assertEquals(59.99, encontrada.get().getPrecio());
    }
}