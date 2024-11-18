package com.example.SistemaReservaSalas.services;

import com.example.SistemaReservaSalas.models.Equipamento;
import com.example.SistemaReservaSalas.repositories.EquipamentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {
    private final EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<Equipamento> listarEquipamentos() {
        return equipamentoRepository.findAll();
    }

    public Optional<Equipamento> buscarEquipamentoPorId(Long id) {
        return equipamentoRepository.findById(id);
    }

    public Equipamento salvarEquipamento(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    public void excluirEquipamento(Long id) {
        equipamentoRepository.deleteById(id);
    }
}
