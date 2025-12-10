package com.test.fibonacci.application.usecases;

import com.test.fibonacci.domain.model.Fibonacci;
import com.test.fibonacci.domain.ports.in.GetNumberOccurrencesUseCase;
import com.test.fibonacci.domain.ports.out.FibonacciRepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class GetNumberOccurrencesUseCaseImpl implements GetNumberOccurrencesUseCase {

    private final FibonacciRepository repository;

    public GetNumberOccurrencesUseCaseImpl(FibonacciRepository repository){
        this.repository=repository;
    }

    @Override
    public List<Fibonacci> apply() {
        return repository.getAllEntities()
                .stream()
                .sorted(Comparator.comparing(Fibonacci::getOccurrences).reversed())
                .toList();
    }

}
