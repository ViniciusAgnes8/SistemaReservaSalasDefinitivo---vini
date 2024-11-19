package com.example.SistemaReservaSalas.controllers;

import com.example.SistemaReservaSalas.models.Sala;
import com.example.SistemaReservaSalas.services.SalaService;
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
    public Optional<Sala> buscarSalaPorId(@PathVariable Long id) {
        return salaService.buscarSalaPorId(id);
    }

    // Salvar uma nova sala
    @PostMapping("/salvar")
    public Sala salvarSala(@RequestBody Sala sala) {
        return salaService.salvarSala(sala);
    }

    // Excluir uma sala pelo ID
    @DeleteMapping("/excluir/{id}")
    public void excluirSala(@PathVariable Long id) {
        salaService.excluirSala(id);
    }
}
