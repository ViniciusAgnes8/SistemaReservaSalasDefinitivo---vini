package com.example.SistemaReservaSalas.models;

import jakarta.persistence.*;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int capacidade;

    @Enumerated(EnumType.STRING)
    private StatusSala status;

    // Construtor padrão
    public Sala() { }

    // Construtor com parâmetros
    public Sala(Long id, String nome, int capacidade, StatusSala status) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.status = status;
    }

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getCapacidade() { return capacidade; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    public StatusSala getStatus() { return status; }
    public void setStatus(StatusSala status) { this.status = status; }

    // Enum para Status da Sala
    public enum StatusSala {
        DISPONIVEL,
        EM_MANUTENCAO,
        OCUPADA
    }
}
