package com.academia.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "maestros")
public class MaestroEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "id_estudiante_fk", referencedColumnName = "id")
    private EstudianteEntity estudiante;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
}
