package com.example.SistemaReservaSalas.controllers;

import com.example.SistemaReservaSalas.models.Reserva;
import com.example.SistemaReservaSalas.services.ReservaService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // Exibição da lista de reservas em uma página HTML
    @GetMapping
    public ModelAndView reservas(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("listaReservas");
        modelAndView.addObject("reservas", listarReservas());
        return modelAndView;
    }

    // Listar todas as reservas
    @GetMapping("/listar")
    public List<Reserva> listarReservas() {
        return reservaService.listarReservas();
    }

    // Buscar uma reserva específica pelo ID
    @GetMapping("/{id}")
    public Optional<Reserva> buscarReservaPorId(@PathVariable Long id) {
        return reservaService.buscarReservaPorId(id);
    }

    // Salvar uma nova reserva
    @PostMapping("/salvar")
    public Reserva salvarReserva(@RequestBody Reserva reserva) {
        return reservaService.salvarReserva(reserva);
    }

    // Excluir uma reserva pelo ID
    @DeleteMapping("/excluir/{id}")
    public void excluirReserva(@PathVariable Long id) {
        reservaService.excluirReserva(id);
    }
}
