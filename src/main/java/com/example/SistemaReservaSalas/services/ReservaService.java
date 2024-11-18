package com.example.SistemaReservaSalas.services;

import com.example.SistemaReservaSalas.models.Reserva;
import com.example.SistemaReservaSalas.repositories.ReservaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> buscarReservaPorId(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva salvarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void excluirReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
