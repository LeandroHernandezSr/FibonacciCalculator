package com.test.fibonacci.infrastructure.adapters.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.fibonacci.domain.model.Fibonacci;
import com.test.fibonacci.domain.ports.out.FibonacciRepository;
import com.test.fibonacci.infrastructure.entrypoints.mapper.FibonacciMapper;

@Repository
public class FibonacciRepositoryImpl implements FibonacciRepository{

    private final FibonacciJpaRepository repository;
    private final FibonacciMapper mapper;

    public FibonacciRepositoryImpl(FibonacciJpaRepository repository,FibonacciMapper mapper){
        this.repository=repository;
        this.mapper=mapper;
    }

    @Override
    public Fibonacci saveFibonacciEntity(Fibonacci entity) {
        this.repository.save(mapper.modelToEntity(entity));
        return entity;
    }

    @Override
    public Fibonacci getFibonnaciEntityByNumber(Integer number) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFibonnaciEntityByNumber'");
    }

    @Override
    public List<Fibonacci> getAllEntities() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEntities'");
    }

}
