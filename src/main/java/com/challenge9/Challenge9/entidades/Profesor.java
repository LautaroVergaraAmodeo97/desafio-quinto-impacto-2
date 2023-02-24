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
@Table(name = "profesor")
public class Profesor {


    @Id
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "activo")
    private boolean activo = true;
    @OneToMany
    private ArrayList<Curso> cursos;



}
