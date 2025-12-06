package com.test.fibonacci.domain.ports.out;

import com.test.fibonacci.infrastructure.entities.FibonacciEntity;

public interface FibonacciRepository {
    FibonacciEntity saveFibonacciEntity(FibonacciEntity entity);
    FibonacciEntity getFibonnaciEntityByNumber(Integer number);
    
}
