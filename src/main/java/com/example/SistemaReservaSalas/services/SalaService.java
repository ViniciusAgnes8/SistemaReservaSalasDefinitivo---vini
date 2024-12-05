package com.example.SistemaReservaSalas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.SistemaReservaSalas.models.ReservaSala;
import com.example.SistemaReservaSalas.models.Sala;
import com.example.SistemaReservaSalas.repositories.ReservaSalaRepository;
import com.example.SistemaReservaSalas.repositories.SalaRepository;

@Service
public class SalaService {

    private final SalaRepository salaRepository;
    private final ReservaSalaRepository reservaSalaRepository;

    
    

    public SalaService(SalaRepository salaRepository, ReservaSalaRepository reservaSalaRepository) {
        this.salaRepository = salaRepository;
        this.reservaSalaRepository =reservaSalaRepository;
    }

    // Listar todas as salas
    public List<Sala> listarSalas() {
        return salaRepository.findAll();
    }

    // Buscar uma sala específica pelo ID
    public Optional<Sala> buscarSalaPorId(Long id) {
        return salaRepository.findById(id);
    }

    // Salvar ou atualizar uma sala
    public Sala salvarSala(Sala sala) {
        return salaRepository.save(sala);
    }

    // Excluir uma sala pelo ID
    public boolean excluirSala(Long id) {
        salaRepository.deleteById(id);
                return false;
    }

    // reserva sala
    public void salvarReserva(ReservaSala reservaSala) {
        reservaSalaRepository.save(reservaSala);
    }  // reserva sala
}
