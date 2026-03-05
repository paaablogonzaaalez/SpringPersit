package com.adorno.examenPSYP.repository;

import com.adorno.examenPSYP.entity.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
    Optional<Tarifa> findByNombre(String nombre);
}
