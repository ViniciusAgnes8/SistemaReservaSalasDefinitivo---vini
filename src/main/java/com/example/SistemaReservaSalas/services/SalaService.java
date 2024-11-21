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
    }
}
