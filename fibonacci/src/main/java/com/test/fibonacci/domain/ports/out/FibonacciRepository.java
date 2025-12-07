package com.test.fibonacci.domain.ports.out;

import java.util.List;

import com.test.fibonacci.domain.model.Fibonacci;

public interface FibonacciRepository {
    Fibonacci saveFibonacciEntity(Fibonacci entity);
    Fibonacci getFibonnaciEntityByNumber(Integer number);
    List<Fibonacci>getAllEntities();
}
