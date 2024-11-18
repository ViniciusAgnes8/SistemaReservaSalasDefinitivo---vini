package com.example.SistemaReservaSalas.controllers;

import com.example.SistemaReservaSalas.models.Reserva;
import com.example.SistemaReservaSalas.services.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.listarReservas();
    }

    @GetMapping("/{id}")
    public Optional<Reserva> buscarReservaPorId(@PathVariable Long id) {
        return reservaService.buscarReservaPorId(id);
    }

    @PostMapping
    public Reserva salvarReserva(@RequestBody Reserva reserva) {
        return reservaService.salvarReserva(reserva);
    }

    @DeleteMapping("/{id}")
    public void excluirReserva(@PathVariable Long id) {
        reservaService.excluirReserva(id);
    }
}
