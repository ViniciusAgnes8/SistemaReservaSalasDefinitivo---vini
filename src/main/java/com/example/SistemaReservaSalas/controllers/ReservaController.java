package com.example.SistemaReservaSalas.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SistemaReservaSalas.models.Equipamento;
import com.example.SistemaReservaSalas.models.Reserva;
import com.example.SistemaReservaSalas.models.Sala;
import com.example.SistemaReservaSalas.services.EquipamentoService;
import com.example.SistemaReservaSalas.services.ReservaService;
import com.example.SistemaReservaSalas.services.SalaService;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;
    private final SalaService salaService;
    private final EquipamentoService equipamentoService;  // Injeção do serviço de Equipamento

    public ReservaController(ReservaService reservaService, SalaService salaService, EquipamentoService equipamentoService) {
        this.reservaService = reservaService;
        this.salaService = salaService;
        this.equipamentoService = equipamentoService;  // Inicializando o EquipamentoService
    }

    // Exibição da lista de reservas e salas em uma página HTML
    @GetMapping
    public String reservas(Model model) {
        model.addAttribute("reservas", listarReservas());
        model.addAttribute("salas", salaService.listarSalas());  // Adicionando lista de salas
        model.addAttribute("equipamentos", equipamentoService.listarEquipamentos()); // Lista de equipamentos
        model.addAttribute("sala", new Sala()); // Criando um objeto Sala vazio para o modal
        model.addAttribute("equipamento", new Equipamento()); // Criando um objeto Equipamento vazio para o modal
        
        return "listaReservas";  // Nome da view Thymeleaf
    }

    // Listar todas as reservas
    @GetMapping("/listar")
    public List<Reserva> listarReservas() {
        return reservaService.listarReservas();
    }

    // Buscar uma reserva específica pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarReservaPorId(@PathVariable Long id) {
        return reservaService.buscarReservaPorId(id)
                .map(reserva -> ResponseEntity.ok(reserva))
                .orElse(ResponseEntity.notFound().build());
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

    // Salvar um novo equipamento
    @PostMapping("/equipamento/salvar")
    public String salvarEquipamento(@ModelAttribute Equipamento equipamento) {
        equipamentoService.salvarEquipamento(equipamento); // Chama o serviço para salvar o equipamento
        return "redirect:/reservas"; // Redireciona de volta para a página de reservas após salvar
    }

    // Excluir uma reserva pelo ID
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirReserva(@PathVariable Long id) {
        if (reservaService.buscarReservaPorId(id).isPresent()) {
            reservaService.excluirReserva(id);
            return ResponseEntity.noContent().build();  // 204 - No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 - Not Found
        }
    }
}
