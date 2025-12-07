package com.test.fibonacci.infrastructure.entrypoints.handlers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.test.fibonacci.domain.ports.in.GetNumberByExactMatchUseCase;
import com.test.fibonacci.domain.ports.in.SaveNthNumberUseCase;
import com.test.fibonacci.infrastructure.entrypoints.dtos.FibonacciDto;


@Component
public class FibonacciHandler {

    private final SaveNthNumberUseCase saveNthNumberUseCase;
    private final GetNumberByExactMatchUseCase getNumberByExactMatchUseCase;

    public FibonacciHandler(SaveNthNumberUseCase saveNthNumberUseCase,GetNumberByExactMatchUseCase getNumberByExactMatchUseCase){
        this.saveNthNumberUseCase=saveNthNumberUseCase;
        this.getNumberByExactMatchUseCase=getNumberByExactMatchUseCase;
    }
    
    public ResponseEntity<?> getNthNumber(FibonacciDto dto){
        var number=getNumberByExactMatchUseCase.apply(dto.number());

        if (!number.isEmpty()){
            return ResponseEntity.ok(number.get().getNthNumber());
        }

        return null;
    }

}
