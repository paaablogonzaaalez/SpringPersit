package com.adorno.examenPSYP.repository;

import com.adorno.examenPSYP.entity.HistoricoSuscripcion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class HistoricoSuscripcionRepositoryTest {

    @Autowired
    private HistoricoSuscripcionRepository historicoRepository;

    @Test
    void testFindByCodigoSuscripcion() {
        // Given
        HistoricoSuscripcion h1 = HistoricoSuscripcion.builder()
                .codigoSuscripcion("USER-01")
                .nombreTarifa("Basic")
                .build();
        HistoricoSuscripcion h2 = HistoricoSuscripcion.builder()
                .codigoSuscripcion("USER-01")
                .nombreTarifa("Premium")
                .build();
        
        historicoRepository.saveAll(List.of(h1, h2));

        // When
        List<HistoricoSuscripcion> lista = historicoRepository.findByCodigoSuscripcion("USER-01");

        // Then
        assertEquals(2, lista.size());
        assertTrue(lista.stream().anyMatch(h -> h.getNombreTarifa().equals("Premium")));
    }
}