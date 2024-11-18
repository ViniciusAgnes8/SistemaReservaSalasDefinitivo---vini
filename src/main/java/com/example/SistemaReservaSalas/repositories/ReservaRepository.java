package com.example.SistemaReservaSalas.repositories;

import com.example.SistemaReservaSalas.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {}
