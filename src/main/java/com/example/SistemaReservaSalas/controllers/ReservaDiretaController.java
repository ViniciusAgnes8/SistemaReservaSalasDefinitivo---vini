package com.example.SistemaReservaSalas.controllers;

import com.example.SistemaReservaSalas.models.Equipamento;
import com.example.SistemaReservaSalas.models.Reserva;
import com.example.SistemaReservaSalas.models.ReservaDTO;
import com.example.SistemaReservaSalas.models.Sala;
import com.example.SistemaReservaSalas.services.EquipamentoService;
import com.example.SistemaReservaSalas.services.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reservar-direto")
public class ReservaDiretaController {

    private final EquipamentoService equipamentoService;
    private final ReservaService reservaS   2ervice;

    public ReservaDiretaController(EquipamentoService equipamentoService, ReservaService reservaService) {
        this.equipamentoService = equipamentoService;
        this.reservaService = reservaService;
    }




    // Salvar uma nova reserva
    @PostMapping("/salvar")
    public ResponseEntity<Reserva> salvarReserva(@RequestBody @Validated Reserva reserva) {
        Reserva novaReserva = reservaService.salvarReserva(reserva);
        return ResponseEntity.status(201).body(novaReserva);
    }

    // Salvar uma nova sala
    @PostMapping("/salas/salvar")
    public String salvarSala(@ModelAttribute Sala sala) {
        salaService.salvarSala(sala); // Chama o serviço para salvar a sala
        return "redirect:/reservas"; // Redireciona de volta para a página de reservas após salvar
    }



    @PostMapping("/equipamento/{id}")
    public String reservarEquipamento(@PathVariable("id") Long idEquipamento, @ModelAttribute ReservaDTO reservaDTO, Model model) {
        try {
            String message = reservaService.reservarEquipamento(idEquipamento, reservaDTO);
            model.addAttribute("message", message);
            return "redirect:/equipamentos"; // Redireciona para a página dos equipamentos
        } catch (Exception e) {
            model.addAttribute("message", "Erro ao realizar a reserva.");
            return "redirect:/equipamentos";
        }
    }

    @GetMapping("/equipamentos")
    public String listarEquipamentos(Model model) {
        List<Equipamento> equipamentos = equipamentoService.listarEquipamentos();
        model.addAttribute("equipamentos", equipamentos);
        return "equipamentos"; // Retorna para a página Thymeleaf que lista os equipamentos
    }
}
