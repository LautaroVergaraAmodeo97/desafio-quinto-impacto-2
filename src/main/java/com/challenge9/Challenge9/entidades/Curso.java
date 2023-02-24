package com.challenge9.Challenge9.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "curso")
public class Curso {

    @Id
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "turno")
    private String turno;

    @Column(name = "horario")
    private String horario;

    @Column(name = "activo")
    private boolean activo = true;



}
