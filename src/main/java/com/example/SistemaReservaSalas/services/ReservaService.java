package com.example.SistemaReservaSalas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.SistemaReservaSalas.models.ReservaSala;
import com.example.SistemaReservaSalas.repositories.ReservaSalaRepository;

@Service
public class ReservaService {

    private final ReservaSalaRepository reservaSalaRepository;

    public ReservaService(ReservaSalaRepository reservaSalaRepository) {
        this.reservaSalaRepository = reservaSalaRepository;
    }

    // Listar todas as reservas
    public List<ReservaSala> listarReservas() {
        return reservaSalaRepository.findAll();
    }

    // Buscar uma reserva específica pelo ID
    public Optional<ReservaSala> buscarReservaPorId(Long id) {
        return reservaSalaRepository.findById(id);
    }


    // Excluir uma reserva pelo ID
    public void excluirReserva(Long id) {   
        reservaSalaRepository.deleteById(id);
    }

    
    
}
