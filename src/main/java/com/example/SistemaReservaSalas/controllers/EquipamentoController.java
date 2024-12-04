package com.example.SistemaReservaSalas.controllers;

import com.example.SistemaReservaSalas.models.Equipamento;
import com.example.SistemaReservaSalas.services.EquipamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @GetMapping
    public String listarEquipamentos(Model model) {
        List<Equipamento> equipamentos = equipamentoService.listarEquipamentos();
        model.addAttribute("equipamentos", equipamentos);
        return "listaequipamentos";
    }

    @GetMapping("/json")
    @ResponseBody
    public List<Equipamento> listarEquipamentosJson() {
        return equipamentoService.listarEquipamentos();
    }

    @PostMapping("/adicionar")
    public String adicionarEquipamento(@ModelAttribute Equipamento equipamento) {
        equipamentoService.salvarEquipamento(equipamento);
        return "redirect:/equipamentos";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String excluirEquipamento(@PathVariable Long id) {
        equipamentoService.excluirEquipamento(id);
        return "Equipamento excluído com sucesso";
    }
}
