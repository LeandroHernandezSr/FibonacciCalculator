package com.test.fibonacci.infrastructure.adapters.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.test.fibonacci.domain.model.Fibonacci;
import com.test.fibonacci.domain.ports.out.FibonacciRepository;
import com.test.fibonacci.infrastructure.mapper.FibonacciMapper;

@Repository
public class FibonacciRepositoryImpl implements FibonacciRepository{

    private final FibonacciJpaRepository repository;
    private final FibonacciMapper mapper;

    public FibonacciRepositoryImpl(FibonacciJpaRepository repository,FibonacciMapper mapper){
        this.repository=repository;
        this.mapper=mapper;
    }

    @Override
    public Optional<Fibonacci> saveFibonacciEntity(Fibonacci entity) {
        return Optional.of(entity)
            .map(mapper::modelToEntity)
            .map(repository::save)
            .map(mapper::entityToModel);
    }

    @Override
    public Optional<Fibonacci> getFibonnaciEntityByNumber(Integer number) {
        return this.repository.findByNumber(number).map(mapper::entityToModel);
    }

    @Override
    public List<Fibonacci> getAllEntities() {
        return this.repository.findAll().stream().map(mapper::entityToModel).toList();
    }
}
