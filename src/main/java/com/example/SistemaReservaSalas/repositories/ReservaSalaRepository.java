package com.example.SistemaReservaSalas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaReservaSalas.models.ReservaSala;

@Repository
public interface ReservaSalaRepository extends JpaRepository<ReservaSala, Long> {
}
