package com.example.SistemaReservaSalas.controllers;

import com.example.SistemaReservaSalas.models.Sala;
import com.example.SistemaReservaSalas.services.SalaService;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    // Exibição da lista de salas em uma página HTML
    @GetMapping
    public ModelAndView salas(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("listaSalas");
        modelAndView.addObject("salas", listarSalas());
        return modelAndView;
    }

    // Listar todas as salas
    @GetMapping("/listar")
    public List<Sala> listarSalas() {
        return salaService.listarSalas();
    }

    // Buscar uma sala específica pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscarSalaPorId(@PathVariable Long id) {
        Optional<Sala> sala = salaService.buscarSalaPorId(id);
        
        return sala.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.status(404).build()); // Retorna 404 se não encontrado
    }

    // Salvar uma nova sala
    @PostMapping("/salvar")
    public ResponseEntity<Sala> salvarSala(@RequestBody Sala sala) {
        Sala salaSalva = salaService.salvarSala(sala);
        return ResponseEntity.status(201).body(salaSalva);  // Retorna a sala salva com status 201
    }

    // Excluir uma sala pelo ID
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirSala(@PathVariable Long id) {
        boolean excluida = salaService.excluirSala(id);
        
        if (excluida) {
            return ResponseEntity.status(204).build();  // Retorna 204 No Content
        } else {
            return ResponseEntity.status(404).body("Sala não encontrada");
        }
    }
}
