package com.academia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ICRUDController<T, ID> {

    ResponseEntity<List<T>> listar() throws Exception;
    ResponseEntity<T> registrar(@RequestBody T t) throws Exception;
    ResponseEntity<T> actualizar(@RequestBody T t) throws Exception;
    ResponseEntity<T> buscarPorId(@PathVariable ID id) throws Exception;
    ResponseEntity<?> eliminar(@PathVariable ID id) throws Exception;

}
