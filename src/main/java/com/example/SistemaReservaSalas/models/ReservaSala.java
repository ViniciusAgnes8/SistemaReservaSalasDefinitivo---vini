package com.example.SistemaReservaSalas.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class ReservaSala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate data;

    @Column(name = "horario_entrada", nullable = false)
    private LocalTime horarioEntrada;

    @Column(name = "horario_saida", nullable = false)
    private LocalTime horarioSaida;

    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = true) 
    private Sala sala; 

    @ManyToOne
    @JoinColumn(name = "equipamento_id", nullable = true)
    private Equipamento equipamento;


    // Construtor padrão (necessário para o JPA)
    public ReservaSala() {
    }

    // Construtor com parâmetros
    public ReservaSala(Long id, String nome, String email, LocalDate data, LocalTime horarioEntrada,
            LocalTime horarioSaida, Sala sala) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.data = data;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.sala = sala;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReservaSala other = (ReservaSala) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ReservaSala{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", data=" + data +
                ", horarioEntrada=" + horarioEntrada +
                ", horarioSaida=" + horarioSaida +
                '}';
    }
}
