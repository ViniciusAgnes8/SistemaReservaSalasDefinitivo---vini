package com.example.SistemaReservaSalas.services;

import com.example.SistemaReservaSalas.models.Sala;
import com.example.SistemaReservaSalas.repositories.SalaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public List<Sala> listarSalas() {
        return salaRepository.findAll();
    }

    public Optional<Sala> buscarSalaPorId(Long id) {
        return salaRepository.findById(id);
    }

    public Sala salvarSala(Sala sala) {
        return salaRepository.save(sala);
    }

    public void excluirSala(Long id) {
        salaRepository.deleteById(id);
    }
}
