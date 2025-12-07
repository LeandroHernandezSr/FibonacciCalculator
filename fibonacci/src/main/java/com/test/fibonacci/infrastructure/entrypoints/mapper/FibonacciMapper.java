package com.test.fibonacci.infrastructure.entrypoints.mapper;

import org.springframework.stereotype.Component;

import com.test.fibonacci.domain.model.Fibonacci;
import com.test.fibonacci.domain.model.FibonacciId;
import com.test.fibonacci.domain.model.FibonacciNumber;
import com.test.fibonacci.infrastructure.adapters.entities.FibonacciEntity;
import com.test.fibonacci.infrastructure.entrypoints.dtos.FibonacciDto;

@Component
public class FibonacciMapper {

    public Fibonacci dtoToModel(FibonacciDto dto) {
        return new Fibonacci(new FibonacciId(dto.id() != null ? dto.id() : null), new FibonacciNumber(dto.number()));
    }

    public FibonacciEntity modelToEntity(Fibonacci fibonacci) {
        FibonacciEntity entity=new FibonacciEntity();

        if (fibonacci.getId() != null){
            entity.setId(fibonacci.getId());
        }

        entity.setNthNumber(fibonacci.getNthNumber());
        entity.setNumber(fibonacci.getEnteredNumber());

        return new FibonacciEntity();
    }

    

}