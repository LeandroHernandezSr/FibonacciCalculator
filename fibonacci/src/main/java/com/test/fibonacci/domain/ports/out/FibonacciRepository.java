package com.test.fibonacci.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.test.fibonacci.domain.model.Fibonacci;

public interface FibonacciRepository {
    Optional<Fibonacci> saveFibonacciEntity(Fibonacci entity);
    Fibonacci getFibonnaciEntityByNumber(Integer number);
    List<Fibonacci>getAllEntities();
}
