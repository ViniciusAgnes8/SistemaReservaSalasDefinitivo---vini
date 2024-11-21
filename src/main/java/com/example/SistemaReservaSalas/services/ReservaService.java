package com.example.SistemaReservaSalas.services;

import com.example.SistemaReservaSalas.models.Reserva;
import com.example.SistemaReservaSalas.models.ReservaDTO;
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

    // Listar todas as reservas
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    // Buscar uma reserva específica pelo ID
    public Optional<Reserva> buscarReservaPorId(Long id) {
        return reservaRepository.findById(id);
    }

    // Salvar uma nova reserva
    public Reserva salvarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Excluir uma reserva pelo ID
    public void excluirReserva(Long id) {   
        reservaRepository.deleteById(id);
    }

    public String reservarEquipamento(Long idEquipamento, ReservaDTO reservaDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reservarEquipamento'");
    }
}
