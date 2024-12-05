package com.example.SistemaReservaSalas.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "equipamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservaSala> reservas = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    private StatusEquipamento status;

    public Equipamento() { }

     public Equipamento(Long id, String nome, StatusEquipamento status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }
   
    public Long getId() { return id; }
   
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public StatusEquipamento getStatus() { return status; }
    public void setStatus(StatusEquipamento status) { this.status = status; }

    public enum StatusEquipamento {
        DISPONIVEL,
        EM_MANUTENCAO,
        RESERVADO
    }
}
