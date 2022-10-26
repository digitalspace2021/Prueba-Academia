package com.academia.serviceImpl;

import com.academia.entity.EstudianteEntity;
import com.academia.repository.IEstudianteRepository;
import com.academia.repository.IGenericRepository;
import com.academia.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl extends CRUDImpl<EstudianteEntity, Integer> implements IEstudianteService {

    @Autowired
    private IEstudianteRepository repository;

    @Override
    protected IGenericRepository<EstudianteEntity, Integer> getRepository() {
        return repository;
    }

    @Override
    public List<EstudianteEntity> listarestudiantesPorMaestro(int id) {
        List<EstudianteEntity> entities = repository.listarestudiantesPorMaestro(id);

        if (entities == null) {
            return null;
        }
        return entities;
    }
}
