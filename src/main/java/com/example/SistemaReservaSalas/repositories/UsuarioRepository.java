package com.example.SistemaReservaSalas.repositories;

import com.example.SistemaReservaSalas.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
