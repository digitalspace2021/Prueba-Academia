package com.academia.repository;

import com.academia.entity.EstudianteEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEstudianteRepository extends IGenericRepository<EstudianteEntity, Integer>{

    @Query("SELECT e FROM EstudianteEntity e INNER JOIN MaestroEntity m ON e.id = m.estudiante.id " +
            "WHERE m.id = :id")
    List<EstudianteEntity> listarestudiantesPorMaestro(int id);
}
