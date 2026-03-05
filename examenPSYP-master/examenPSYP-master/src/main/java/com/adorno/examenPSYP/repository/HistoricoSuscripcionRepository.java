package com.adorno.examenPSYP.repository;

import com.adorno.examenPSYP.entity.HistoricoSuscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoSuscripcionRepository extends JpaRepository<HistoricoSuscripcion, Long> {
    List<HistoricoSuscripcion> findByCodigoSuscripcion(String codigoSuscripcion);
}
