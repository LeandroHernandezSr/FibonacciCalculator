package com.test.fibonacci.infrastructure.controllers;

import com.test.fibonacci.infrastructure.entrypoints.controllers.GetNthNumberController;
import com.test.fibonacci.infrastructure.entrypoints.dtos.FibonacciDto;
import com.test.fibonacci.infrastructure.entrypoints.dtos.NthNumberResponseDto;
import com.test.fibonacci.infrastructure.entrypoints.handlers.FibonacciHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GetNthNumberControllerTest {

    @Mock
    private FibonacciHandler handler;

    private GetNthNumberController controller;

    @BeforeEach
    void setUp() {
        controller = new GetNthNumberController(handler);
    }

    @Test
    void testGetNthNumberDelegatesToHandler() {
        // given
        FibonacciDto dto = new FibonacciDto( 8);
        ResponseEntity<NthNumberResponseDto> expectedResponse = ResponseEntity.ok(new NthNumberResponseDto(21));

        when(handler.getNthNumber(dto)).thenReturn(expectedResponse);

        // when
        ResponseEntity<NthNumberResponseDto> response = controller.getNthNumber(dto);

        // then
        assertEquals(expectedResponse, response);
        verify(handler).getNthNumber(dto);
    }

}
