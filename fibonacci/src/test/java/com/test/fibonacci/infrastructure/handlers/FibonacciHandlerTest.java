package com.test.fibonacci.infrastructure.handlers;

import com.test.fibonacci.domain.model.Fibonacci;
import com.test.fibonacci.domain.model.FibonacciId;
import com.test.fibonacci.domain.model.FibonacciNumber;
import com.test.fibonacci.domain.ports.in.GetNumberByExactMatchUseCase;
import com.test.fibonacci.domain.ports.in.GetNumberOccurrencesUseCase;
import com.test.fibonacci.domain.ports.in.SaveNthNumberUseCase;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void testGetNthNumber_WhenNumberExists() {
        // given
        FibonacciDto dto = new FibonacciDto( 8);

        Fibonacci existing = new Fibonacci(new FibonacciId(1L), new FibonacciNumber(8, 21L, 8));

        when(getNumberByExactMatchUseCase.apply(8)).thenReturn(Optional.of(existing));

        // when
        ResponseEntity<NthNumberResponseDto> response = handler.getNthNumber(dto);

        // then
        assertEquals(new NthNumberResponseDto(21L), response.getBody());

        verify(getNumberByExactMatchUseCase).apply(8);
        verify(saveNthNumberUseCase).apply(existing);
        verifyNoMoreInteractions(saveNthNumberUseCase);
    }


    @Test
    void testGetNthNumber_WhenNumberDoesNotExist() {
        // given
        FibonacciDto dto = new FibonacciDto( 10);

        Fibonacci mapped = new Fibonacci(new FibonacciId(1L), new FibonacciNumber(10, 55L,8));
        Fibonacci saved  = new Fibonacci(new FibonacciId(2L), new FibonacciNumber(10, 55L,8));

        when(getNumberByExactMatchUseCase.apply(10)).thenReturn(Optional.empty());
        when(mapper.dtoToModel(dto)).thenReturn(mapped);
        when(saveNthNumberUseCase.apply(mapped)).thenReturn(saved);

        // when
        ResponseEntity<NthNumberResponseDto> response = handler.getNthNumber(dto);

        // then
        assertEquals(new NthNumberResponseDto(55L), response.getBody());

        verify(getNumberByExactMatchUseCase).apply(10);
        verify(mapper).dtoToModel(dto);
        verify(saveNthNumberUseCase).apply(mapped);
    }
}
