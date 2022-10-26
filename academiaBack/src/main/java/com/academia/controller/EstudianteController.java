package com.academia.controller;

import com.academia.entity.EstudianteEntity;
import com.academia.repository.IEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController extends CRUDControllerImpl<EstudianteEntity, Integer>{

    @Autowired
    private IEstudianteRepository service;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<List<EstudianteEntity>> listarestudiantesPorMaestro(@PathVariable int id) throws Exception {

        List<EstudianteEntity> entities = service.listarestudiantesPorMaestro(id);

        return new ResponseEntity<List<EstudianteEntity>>(entities, HttpStatus.OK);
    }
}
