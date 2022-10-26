package com.academia.serviceImpl;

import com.academia.entity.MaestroEntity;
import com.academia.repository.IGenericRepository;
import com.academia.repository.IMaestroRepository;
import com.academia.service.IMaestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaestroServiceImpl extends CRUDImpl<MaestroEntity, Integer> implements IMaestroService {

    @Autowired
    private IMaestroRepository repository;

    @Override
    protected IGenericRepository<MaestroEntity, Integer> getRepository() {
        return repository;
    }
}
