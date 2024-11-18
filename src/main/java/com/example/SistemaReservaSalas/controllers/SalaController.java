package com.example.SistemaReservaSalas.controllers;

import com.example.SistemaReservaSalas.models.Sala;
import com.example.SistemaReservaSalas.services.SalaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salas")
public class SalaController {
    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public List<Sala> listarSalas() {
        return salaService.listarSalas();
    }

    @GetMapping("/{id}")
    public Optional<Sala> buscarSalaPorId(@PathVariable Long id) {
        return salaService.buscarSalaPorId(id);
    }

    @PostMapping
    public Sala salvarSala(@RequestBody Sala sala) {
        return salaService.salvarSala(sala);
    }

    @DeleteMapping("/{id}")
    public void excluirSala(@PathVariable Long id) {
        salaService.excluirSala(id);
    }
}
