package com.academia.serviceImpl;

import com.academia.entity.AsignacionEntity;
import com.academia.repository.IAsignacionRepository;
import com.academia.repository.IGenericRepository;
import com.academia.service.IAsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionServiceImpl extends CRUDImpl<AsignacionEntity, Integer> implements IAsignacionService {

    @Autowired
    private IAsignacionRepository repository;

    @Override
    protected IGenericRepository<AsignacionEntity, Integer> getRepository() {
        return repository;
    }
}
