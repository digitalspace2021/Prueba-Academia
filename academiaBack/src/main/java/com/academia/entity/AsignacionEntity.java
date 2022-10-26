package com.academia.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "asignaciones")
public class AsignacionEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "id_maestro_fk", referencedColumnName = "id")
    private MaestroEntity maestro;

    @ManyToOne()
    @JoinColumn(name = "id_estudiante_fk", referencedColumnName = "id")
    private EstudianteEntity estudiante;
}
