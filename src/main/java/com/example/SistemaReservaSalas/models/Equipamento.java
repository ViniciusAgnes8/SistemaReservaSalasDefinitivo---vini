package com.example.SistemaReservaSalas.models;

import jakarta.persistence.*;

@Entity
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

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
