package com.academia.service;

import com.academia.entity.EstudianteEntity;

import java.util.List;

public interface IEstudianteService extends ICRUD<EstudianteEntity, Integer> {

    List<EstudianteEntity> listarestudiantesPorMaestro(int id);
}
