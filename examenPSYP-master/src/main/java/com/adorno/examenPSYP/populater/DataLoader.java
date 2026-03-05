package com.adorno.examenPSYP.populater;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.adorno.examenPSYP.entity.HistoricoSuscripcion;
import com.adorno.examenPSYP.entity.Suscripcion;
import com.adorno.examenPSYP.entity.Tarifa;
import com.adorno.examenPSYP.repository.HistoricoSuscripcionRepository;
import com.adorno.examenPSYP.repository.SuscripcionRepository;
import com.adorno.examenPSYP.repository.TarifaRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {
//	public class DataLoader implements CommandLineRunner {

    private final TarifaRepository tarifaRepository;
    private final SuscripcionRepository suscripcionRepository;
    private final HistoricoSuscripcionRepository historicoSuscripcionRepository;

    public DataLoader(TarifaRepository tarifaRepository,
            SuscripcionRepository suscripcionRepository,
            HistoricoSuscripcionRepository historicoSuscripcionRepository) {
        this.tarifaRepository = tarifaRepository;
        this.suscripcionRepository = suscripcionRepository;
        this.historicoSuscripcionRepository = historicoSuscripcionRepository;
    }

//    @Override
//    public void run(String... args) throws Exception {
//        if (tarifaRepository.count() == 0) {
//            loadData();
//        }
//    }

    @PostConstruct    
    private void loadData() {
        // Tarifas
        Tarifa basic = Tarifa.builder()
                .nombre("Basic")
                .precio(29.99)
                .descripcion("Acceso sala de maquinas")
                .build();

        Tarifa premium = Tarifa.builder()
                .nombre("Premium")
                .precio(49.99)
                .descripcion("Acceso total + piscina")
                .build();

        tarifaRepository.saveAll(List.of(basic, premium));

        // Suscripciones
        Suscripcion sub1 = Suscripcion.builder()
                .codigoReferencia("SUB-001")
                .nombreSocio("Juan Perez")
                .tarifa(basic)
                .fechaInicio(LocalDate.parse("2025-01-01"))
                .diasAsistencia(30)
                .pagosAcumulados(89.97)
                .build();

        Suscripcion sub2 = Suscripcion.builder()
                .codigoReferencia("SUB-002")
                .nombreSocio("Maria Gomez")
                .tarifa(premium)
                .fechaInicio(LocalDate.parse("2025-02-15"))
                .diasAsistencia(10)
                .pagosAcumulados(49.99)
                .build();

        suscripcionRepository.saveAll(List.of(sub1, sub2));

        // Historicos
        HistoricoSuscripcion hist1 = HistoricoSuscripcion.builder()
                .codigoSuscripcion("SUB-001")
                .nombreTarifa("Premium")
                .diasAsistencia(60)
                .pagosRealizados(149.97)
                .fechaInicio(LocalDate.parse("2024-09-01"))
                .fechaFin(LocalDate.parse("2024-12-31"))
                .build();

        historicoSuscripcionRepository.save(hist1);

        System.out.println("Data loaded successfully.");
    }
}
