package com.test.fibonacci.infrastructure.entrypoints.controllers;

import com.test.fibonacci.infrastructure.entrypoints.dtos.FibonacciDto;
import com.test.fibonacci.infrastructure.entrypoints.dtos.NthNumberResponseDto;
import com.test.fibonacci.infrastructure.entrypoints.handlers.FibonacciHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fibonacci")
public class GetNthNumberController {

    private final FibonacciHandler handler;

    public GetNthNumberController(FibonacciHandler handler) {
        this.handler = handler;
    }

    @PostMapping("/get-nth-number")
    @Operation(
            summary = "Get Nth Fibonacci number",
            description = "Returns the Fibonacci number corresponding to the provided N value."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Fibonacci number calculated successfully",
            content = @Content(schema = @Schema(implementation = NthNumberResponseDto.class))
    )
    public ResponseEntity<NthNumberResponseDto> getNthNumber(
            @RequestBody FibonacciDto dto) {
        return this.handler.getNthNumber(dto);
    }
}
