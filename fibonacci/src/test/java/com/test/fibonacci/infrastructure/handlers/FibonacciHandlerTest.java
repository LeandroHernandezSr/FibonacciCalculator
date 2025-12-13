package com.test.fibonacci.infrastructure.handlers;

import com.test.fibonacci.domain.model.Fibonacci;
import com.test.fibonacci.domain.model.FibonacciId;
import com.test.fibonacci.domain.model.FibonacciNumber;
import com.test.fibonacci.domain.ports.in.GetNumberByExactMatchUseCase;
import com.test.fibonacci.domain.ports.in.GetNumberOccurrencesUseCase;
import com.test.fibonacci.domain.ports.in.SaveNthNumberUseCase;
import com.test.fibonacci.infrastructure.entrypoints.dtos.ApiResponseDto;
import com.test.fibonacci.infrastructure.entrypoints.dtos.FibonacciDto;
import com.test.fibonacci.infrastructure.entrypoints.dtos.NthNumberResponseDto;
import com.test.fibonacci.infrastructure.entrypoints.handlers.FibonacciHandler;
import com.test.fibonacci.infrastructure.mapper.FibonacciMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FibonacciHandlerTest {

    @Mock
    private SaveNthNumberUseCase saveNthNumberUseCase;

    @Mock
    private GetNumberByExactMatchUseCase getNumberByExactMatchUseCase;

    @Mock
    private GetNumberOccurrencesUseCase getNumberOccurrencesUseCase;

    @Mock
    private FibonacciMapper mapper;

    private FibonacciHandler handler;

    @BeforeEach
    void setUp() {
        handler = new FibonacciHandler(
                saveNthNumberUseCase,
                getNumberByExactMatchUseCase,
                getNumberOccurrencesUseCase,
                mapper
        );
    }

    @Test
    void testGetNthNumber_WhenNumberDoesNotExist() {
        // given
        FibonacciDto dto = new FibonacciDto(10);

        Fibonacci mapped = new Fibonacci(
                new FibonacciId(1L),
                new FibonacciNumber(10, 55L, 8)
        );
        Fibonacci saved = new Fibonacci(
                new FibonacciId(2L),
                new FibonacciNumber(10, 55L, 8)
        );

        when(getNumberByExactMatchUseCase.apply(10)).thenReturn(Optional.empty());
        when(mapper.dtoToModel(dto)).thenReturn(mapped);
        when(saveNthNumberUseCase.apply(mapped)).thenReturn(saved);

        // when
        ResponseEntity<ApiResponseDto<NthNumberResponseDto>> response =
                handler.getNthNumber(dto);

        // then
        ApiResponseDto<NthNumberResponseDto> body = response.getBody();

        assertEquals(55L, body.data().nthNumber());
        assertEquals("Operation finished succesfully", body.message());
        assertTrue(body.success());
        assertNull(body.errors());
        assertNotNull(body.timeStamp());

        verify(getNumberByExactMatchUseCase).apply(10);
        verify(mapper).dtoToModel(dto);
        verify(saveNthNumberUseCase).apply(mapped);
    }

}
