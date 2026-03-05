package com.adorno.examenPSYP.repository;

import com.adorno.examenPSYP.entity.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuscripcionRepository extends JpaRepository<Suscripcion, Long> {
    Optional<Suscripcion> findByCodigoReferencia(String codigoReferencia);
}
