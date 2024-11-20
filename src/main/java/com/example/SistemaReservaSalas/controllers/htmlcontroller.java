package com.example.SistemaReservaSalas.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("page")
public class htmlcontroller {
    @GetMapping("/home")
    public ModelAndView loginForm(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/salas")
    public ModelAndView salas(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("listaSalas");
        return modelAndView;
    }

    @GetMapping("/reservas")
    public ModelAndView reservas(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("listaReservas");
        return modelAndView;
    }

    @GetMapping("/usuarios")
    public ModelAndView usuarios(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usuarios");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/relatorios")
    public ModelAndView relatorio(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("relatorios");
        return modelAndView;
    }
    
}
    
