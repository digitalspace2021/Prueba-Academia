package com.academia.serviceImpl;

import com.academia.repository.IGenericRepository;
import com.academia.service.ICRUD;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    @Autowired
    protected abstract IGenericRepository<T, ID> getRepository();

    @Override
    public T registrar(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public T actualizar(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public List<T> listar() throws Exception {
        return getRepository().findAll();
    }

    @Override
    public T buscarPorId(ID id) throws Exception {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public void eliminar(ID id) throws Exception {
        getRepository().deleteById(id);
    }
}
