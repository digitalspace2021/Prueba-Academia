package com.academia.controller;

import com.academia.serviceImpl.CRUDImpl;
import com.cam.api.talleres.exeption.ModeloNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public abstract class CRUDControllerImpl<T, ID> implements ICRUDController<T, ID>{

    @Autowired
    private CRUDImpl<T, ID> service;

    @Override
    @PostMapping()
    public ResponseEntity<T> registrar(T t) throws Exception {
        return new ResponseEntity<T>(service.registrar(t), HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<T> actualizar(T t) throws Exception {
        return new ResponseEntity<T>(service.actualizar(t), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<T>> listar() throws Exception {
        return new ResponseEntity<List<T>>(service.listar(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<T> buscarPorId(ID id) throws Exception {
        T obj = service.buscarPorId(id);
        if(obj == null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
        }
        return new ResponseEntity<T>(obj, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminar(ID id) throws Exception {
        T obj = service.buscarPorId(id);
        if (obj == null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
