package com.example.SistemaReservaSalas.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.SistemaReservaSalas.models.ReservaSala;
import com.example.SistemaReservaSalas.models.Sala;
import com.example.SistemaReservaSalas.services.SalaService;

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
        Sala sala = new Sala(); // instancia objeto sala
        ReservaSala reservaSala = new ReservaSala(); // instancia objeto reserva sala
        reservaSala.setSala(sala); // adiciona objeto sala ao reserva sala

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("listaSalas");
        modelAndView.addObject("salas", listarSalas());
        modelAndView.addObject("reservaSala", new ReservaSala()); //envia o objeto reserva sala para o front
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
        Sala sala = salaService.buscarSalaPorId(id);
        
        return ResponseEntity.ok(sala);
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
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(404).body("Sala não encontrada");
        }
    }


     // metodo para salvar reserva de sala
    @PostMapping("/salvar-reserva")
    public ModelAndView salvarReserva(@ModelAttribute ReservaSala reserva, Model model) {
        
        if(reserva.getSala().getId() != null){
            Sala updateSala = salaService.buscarSalaPorId(reserva.getSala().getId());
            updateSala.setStatus(Sala.StatusSala.OCUPADA);
            salaService.salvarSala(updateSala);
        }
       // Salvar a reserva
        salaService.salvarReserva(reserva);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/reservas");  // Isso irá redirecionar para o endpoint "/salas"
    
        return modelAndView;
    }
}