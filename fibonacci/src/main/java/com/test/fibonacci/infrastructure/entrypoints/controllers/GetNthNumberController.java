package com.test.fibonacci.infrastructure.entrypoints.controllers;

import com.test.fibonacci.infrastructure.entrypoints.dtos.FibonacciDto;
import com.test.fibonacci.infrastructure.entrypoints.handlers.FibonacciHandler;
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
    public ResponseEntity<?> getNthNumber(@RequestBody FibonacciDto dto) {
        return this.handler.getNthNumber(dto);
    }
}
