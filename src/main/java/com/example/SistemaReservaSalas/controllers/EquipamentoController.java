package com.example.SistemaReservaSalas.controllers;

import com.example.SistemaReservaSalas.models.Equipamento;
import com.example.SistemaReservaSalas.services.EquipamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {
    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @GetMapping
    public List<Equipamento> listarEquipamentos() {
        return equipamentoService.listarEquipamentos();
    }

    @GetMapping("/{id}")
    public Optional<Equipamento> buscarEquipamentoPorId(@PathVariable Long id) {
        return equipamentoService.buscarEquipamentoPorId(id);
    }

    @PostMapping
    public Equipamento salvarEquipamento(@RequestBody Equipamento equipamento) {
        return equipamentoService.salvarEquipamento(equipamento);
    }

    @DeleteMapping("/{id}")
    public void excluirEquipamento(@PathVariable Long id) {
        equipamentoService.excluirEquipamento(id);
    }
}
