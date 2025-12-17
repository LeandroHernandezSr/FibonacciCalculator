package com.test.fibonacci.application.usecases;

import java.util.Optional;

import org.springframework.stereotype.Component;

import org.springframework.cache.annotation.Cacheable;

import com.test.fibonacci.domain.model.Fibonacci;
import com.test.fibonacci.domain.ports.in.GetNumberByExactMatchUseCase;
import com.test.fibonacci.domain.ports.out.FibonacciRepository;

@Component
public class GetNumberByExactMatchUseCaseImpl implements GetNumberByExactMatchUseCase{

    private final FibonacciRepository repository;

    public GetNumberByExactMatchUseCaseImpl(FibonacciRepository repository){
        this.repository=repository;
    }

    @Override
    @Cacheable(
        cacheNames = "fibonacci-by-number",
        key = "#number"
    )   
    public Optional<Fibonacci> apply(Integer number) {
        return repository.getFibonnaciEntityByNumber(number);
    }

}
