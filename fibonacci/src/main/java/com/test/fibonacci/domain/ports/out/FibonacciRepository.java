package com.test.fibonacci.domain.ports.out;

import java.util.List;

import com.test.fibonacci.infrastructure.entities.FibonacciEntity;

public interface FibonacciRepository {
    FibonacciEntity saveFibonacciEntity(FibonacciEntity entity);
    FibonacciEntity getFibonnaciEntityByNumber(Integer number);
    List<FibonacciEntity>getAllEntities();
}
