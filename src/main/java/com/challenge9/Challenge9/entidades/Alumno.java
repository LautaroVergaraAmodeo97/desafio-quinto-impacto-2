package com.challenge9.Challenge9.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "alumno")
public class Alumno {


    @Id
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "historia")
    private String historia;

    @Column (name = "activo")
    private boolean activo = true;
    @ManyToMany
    private ArrayList<Curso> cursos;










}
