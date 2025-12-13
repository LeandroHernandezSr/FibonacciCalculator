package com.test.fibonacci.infrastructure.entrypoints.controllers;

import com.test.fibonacci.infrastructure.entrypoints.dtos.ApiResponseDto;
import com.test.fibonacci.infrastructure.entrypoints.dtos.FibonacciResponseDto;
import com.test.fibonacci.infrastructure.entrypoints.handlers.FibonacciHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fibonacci")
public class GetNumberOccurrencesOrderBy {

    private final FibonacciHandler handler;

    public GetNumberOccurrencesOrderBy(FibonacciHandler handler) {
        this.handler = handler;
    }

    @GetMapping("/occurrences")
    @Operation(
            summary = "Get Fibonacci numbers ordered by occurrences",
            description = "Returns a list of Fibonacci numbers sorted by the number of times they were requested."
    )
    @ApiResponse(responseCode = "200", description = "Occurrences retrieved successfully")
    public ResponseEntity<ApiResponseDto<List<FibonacciResponseDto>>> getNumberOccurrences() {
        return this.handler.getOccurrencesOrderBy();
    }
}
