package com.test.fibonacci.application.usecases;


import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

import com.test.fibonacci.domain.model.Fibonacci;
import com.test.fibonacci.domain.ports.in.SaveNthNumberUseCase;
import com.test.fibonacci.domain.ports.out.FibonacciRepository;

@Component
public class SaveNthNumberUseCaseImpl implements SaveNthNumberUseCase{

    private final FibonacciRepository repository;

    public SaveNthNumberUseCaseImpl(FibonacciRepository repository){
        this.repository=repository;
    }

    @Override
    @CachePut(
        cacheNames = "fibonacci-by-number",
        key = "#fibonacci.enteredNumber"
    )
    public Fibonacci apply(Fibonacci fibonacci) {
        return repository
                .saveFibonacciEntity(fibonacci)
                .orElseThrow(() -> new IllegalStateException("Error saving Fibonacci!"));
    }

}
