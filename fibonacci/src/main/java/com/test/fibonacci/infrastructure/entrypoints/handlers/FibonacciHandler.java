package com.test.fibonacci.infrastructure.entrypoints.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.test.fibonacci.domain.ports.in.GetNumberByExactMatchUseCase;
import com.test.fibonacci.domain.ports.in.SaveNthNumberUseCase;
import com.test.fibonacci.infrastructure.entrypoints.dtos.FibonacciDto;
import com.test.fibonacci.infrastructure.mapper.FibonacciMapper;


@Component
public class FibonacciHandler {

    private final SaveNthNumberUseCase saveNthNumberUseCase;
    private final GetNumberByExactMatchUseCase getNumberByExactMatchUseCase;
    private final FibonacciMapper mapper;

    public FibonacciHandler(SaveNthNumberUseCase saveNthNumberUseCase,GetNumberByExactMatchUseCase getNumberByExactMatchUseCase,FibonacciMapper mapper){
        this.saveNthNumberUseCase=saveNthNumberUseCase;
        this.getNumberByExactMatchUseCase=getNumberByExactMatchUseCase;
        this.mapper=mapper;
    }
    
    public ResponseEntity<Integer> getNthNumber(FibonacciDto dto){
        var number=getNumberByExactMatchUseCase.apply(dto.number());

        if (number.isPresent()){
            return ResponseEntity.ok(number.get().getNthNumber());
        }

        var nthNumber=saveNthNumberUseCase.apply(mapper.dtoToModel(dto));

        return ResponseEntity.ok(nthNumber.getNthNumber());
    }

}
