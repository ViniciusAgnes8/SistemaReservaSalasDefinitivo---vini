package com.example.SistemaReservaSalas.controllers;

import com.example.SistemaReservaSalas.models.Equipamento;
import com.example.SistemaReservaSalas.models.ReservaDTO;
import com.example.SistemaReservaSalas.services.EquipamentoService;
import com.example.SistemaReservaSalas.services.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reservar-direto")
public class ReservaDiretaController {

    private final EquipamentoService equipamentoService;
    private final ReservaService reservaService;

    public ReservaDiretaController(EquipamentoService equipamentoService, ReservaService reservaService) {
        this.equipamentoService = equipamentoService;
        this.reservaService = reservaService;
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
