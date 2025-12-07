package com.test.fibonacci.domain.ports.in;

import java.util.Optional;

import com.test.fibonacci.domain.model.Fibonacci;

public interface GetNumberByExactMatchUseCase {
    Optional<Fibonacci> apply(Integer number);
}
