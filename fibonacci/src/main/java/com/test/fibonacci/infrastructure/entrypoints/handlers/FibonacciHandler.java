package com.test.fibonacci.infrastructure.entrypoints.handlers;

import com.test.fibonacci.domain.ports.in.GetNumberOccurrencesUseCase;
import com.test.fibonacci.infrastructure.entrypoints.dtos.FibonacciResponseDto;
import com.test.fibonacci.infrastructure.entrypoints.dtos.NthNumberResponseDto;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.test.fibonacci.domain.ports.in.GetNumberByExactMatchUseCase;
import com.test.fibonacci.domain.ports.in.SaveNthNumberUseCase;
import com.test.fibonacci.infrastructure.entrypoints.dtos.ApiResponseDto;
import com.test.fibonacci.infrastructure.entrypoints.dtos.FibonacciDto;
import com.test.fibonacci.infrastructure.mapper.FibonacciMapper;
import com.test.fibonacci.infrastructure.utils.GlobalConstants;

import java.util.List;

@Component
public class FibonacciHandler {

    private final SaveNthNumberUseCase saveNthNumberUseCase;
    private final GetNumberByExactMatchUseCase getNumberByExactMatchUseCase;
    private final GetNumberOccurrencesUseCase getNumberOccurrencesUseCase;
    private final FibonacciMapper mapper;

    public FibonacciHandler(SaveNthNumberUseCase saveNthNumberUseCase,
            GetNumberByExactMatchUseCase getNumberByExactMatchUseCase,
            GetNumberOccurrencesUseCase getNumberOccurrencesUseCase, FibonacciMapper mapper) {
        this.saveNthNumberUseCase = saveNthNumberUseCase;
        this.getNumberByExactMatchUseCase = getNumberByExactMatchUseCase;
        this.getNumberOccurrencesUseCase = getNumberOccurrencesUseCase;
        this.mapper = mapper;
    }

    public ResponseEntity<ApiResponseDto<NthNumberResponseDto>> getNthNumber(FibonacciDto dto) {
        try {
            var number = getNumberByExactMatchUseCase.apply(dto.number());

            if (number.isPresent()) {
                number.get().incrementOccurrences();
                saveNthNumberUseCase.apply(number.get());
                return ResponseEntity
                        .ok(new ApiResponseDto<>(new NthNumberResponseDto(number.get().getNthNumber()), GlobalConstants.COMPLETE_OPERATION_MESSAGE));
            }

            var nthNumber = saveNthNumberUseCase.apply(mapper.dtoToModel(dto));

            return ResponseEntity.ok(new ApiResponseDto<>(new NthNumberResponseDto(nthNumber.getNthNumber()), GlobalConstants.COMPLETE_OPERATION_MESSAGE));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponseDto<>(List.of(e.getMessage()), GlobalConstants.ERROR_MESSAGE));
        }
    }

    public ResponseEntity<ApiResponseDto<List<FibonacciResponseDto>>> getOccurrencesOrderBy() {
        try{
            return ResponseEntity.ok(new ApiResponseDto<>(
                this.getNumberOccurrencesUseCase.apply()
                .stream()
                .map(o -> new FibonacciResponseDto(
                        o.getEnteredNumber(),
                        o.getOccurrences()))
                .toList(), GlobalConstants.COMPLETE_OPERATION_MESSAGE));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new ApiResponseDto<>(List.of(e.getMessage()), GlobalConstants.ERROR_MESSAGE));
        }
    }

}
