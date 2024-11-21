package com.example.SistemaReservaSalas.controllers;

import com.example.SistemaReservaSalas.models.Equipamento;
import com.example.SistemaReservaSalas.services.EquipamentoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    // Método que lida com a URL /equipamentos
    @GetMapping
    public ModelAndView equipamentos(Model model) {
        List<Equipamento> equipamentos = equipamentoService.listarEquipamentos();
        model.addAttribute("equipamentos", equipamentos); // Passa os equipamentos para o modelo
        return new ModelAndView("listaEquipamentos"); // Retorna o template Thymeleaf
    }

    @GetMapping("/json")
    @ResponseBody
    public List<Equipamento> listarEquipamentos() {
        return equipamentoService.listarEquipamentos();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Equipamento buscarEquipamentoPorId(@PathVariable Long id) {
        return equipamentoService.buscarEquipamentoPorId(id).orElse(null);
    }

    @PostMapping("/adicionar")
    public String adicionarEquipamento(@ModelAttribute Equipamento equipamento) {
        equipamentoService.salvar(equipamento);
        return "redirect:/equipamentos";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String excluirEquipamento(@PathVariable Long id) {
        equipamentoService.excluirEquipamento(id);
        return "Equipamento excluído com sucesso";
    }
}
