package com.test.fibonacci.domain.ports.in;

import com.test.fibonacci.domain.model.Fibonacci;

public interface SaveNthNumberUseCase {
    Fibonacci apply(Fibonacci fibonacci);
}
