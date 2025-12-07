package com.test.fibonacci.application.usecases;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.test.fibonacci.domain.ports.in.CountNumberOccurrencesUseCase;
import com.test.fibonacci.domain.ports.out.FibonacciRepository;

@Component
public class CountNumberOccurrencesUseCaseImpl implements CountNumberOccurrencesUseCase{

    private final FibonacciRepository repository;

    public CountNumberOccurrencesUseCaseImpl(FibonacciRepository repository){
        this.repository=repository;
    }

    @Override
    public BigDecimal apply() {
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
    }

}
