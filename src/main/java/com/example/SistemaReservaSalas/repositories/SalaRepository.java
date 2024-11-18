package com.example.SistemaReservaSalas.repositories;

import com.example.SistemaReservaSalas.models.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {}
