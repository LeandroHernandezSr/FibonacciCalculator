package com.test.fibonacci.infrastructure.entrypoints.dtos;

public record FibonacciResponseDto(
        Integer number,
        Integer occurrences
) {
}
