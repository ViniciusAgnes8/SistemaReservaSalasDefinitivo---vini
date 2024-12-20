package com.example.SistemaReservaSalas.controllers;

import com.example.SistemaReservaSalas.models.Reserva;
import com.example.SistemaReservaSalas.services.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservar-direto")
public class ReservaDiretaController {

    private final ReservaService reservaService;

    public ReservaDiretaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

   
}
