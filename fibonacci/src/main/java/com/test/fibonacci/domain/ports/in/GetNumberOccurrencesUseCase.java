package com.test.fibonacci.domain.ports.in;

import com.test.fibonacci.domain.model.Fibonacci;

import java.util.List;

public interface GetNumberOccurrencesUseCase {
    List<Fibonacci> apply();
}
