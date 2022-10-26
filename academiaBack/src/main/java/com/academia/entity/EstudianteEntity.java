package com.academia.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "estudiantes")
public class EstudianteEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
}
