package com.example.SistemaReservaSalas.controllers;

import com.example.SistemaReservaSalas.models.Equipamento;
import com.example.SistemaReservaSalas.services.EquipamentoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    // Renderiza a página de equipamentos com a lista completa
    @GetMapping
    public ModelAndView equipamentos() {
        ModelAndView modelAndView = new ModelAndView("listaEquipamentos");
        modelAndView.addObject("equipamentos", listarEquipamentos());
        return modelAndView;
    }

    // Retorna a lista de equipamentos em formato JSON (API REST)
    @GetMapping("/json")
    @ResponseBody
    public List<Equipamento> listarEquipamentos() {
        return equipamentoService.listarEquipamentos();
    }

    // Busca um equipamento por ID em formato JSON (API REST)
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Equipamento> buscarEquipamentoPorId(@PathVariable Long id) {
        return equipamentoService.buscarEquipamentoPorId(id);
    }

    // Adiciona um novo equipamento e redireciona para a página de equipamentos
    @PostMapping("/adicionar")
    public String adicionarEquipamento(@ModelAttribute Equipamento equipamento) {
        equipamentoService.salvar(equipamento);
        return "redirect:/equipamentos";
    }

    // Exclui um equipamento por ID
    @DeleteMapping("/{id}")
    @ResponseBody
    public String excluirEquipamento(@PathVariable Long id) {
        equipamentoService.excluirEquipamento(id);
        return "Equipamento excluído com sucesso";
    }
}
