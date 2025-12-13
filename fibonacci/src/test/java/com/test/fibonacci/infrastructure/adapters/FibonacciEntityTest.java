package com.test.fibonacci.infrastructure.adapters;

import com.test.fibonacci.domain.model.Fibonacci;
import com.test.fibonacci.domain.model.FibonacciId;
import com.test.fibonacci.domain.model.FibonacciNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FibonacciEntityTest {

    @Mock
    private FibonacciId fibonacciId;

    @Mock
    private FibonacciNumber fibonacciNumber;

    private Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        // Mockito ya inicializó los mocks antes de entrar acá
        fibonacci = new Fibonacci(fibonacciId, fibonacciNumber);
    }

    @Test
    void testGetIdDelegatesToFibonacciId() {
        // given
        when(fibonacciId.getId()).thenReturn(10L);

        // when
        Long result = fibonacci.getId();

        // then
        assertEquals(10L, result);
        verify(fibonacciId).getId();
    }

    @Test
    void testGetNthNumberDelegatesToFibonacciNumber() {
        when(fibonacciNumber.getNthNumber()).thenReturn(21L);

        Long result = fibonacci.getNthNumber();

        assertEquals(21, result);
        verify(fibonacciNumber).getNthNumber();
    }

    @Test
    void testGetEnteredNumberDelegatesToFibonacciNumber() {
        when(fibonacciNumber.getNumber()).thenReturn(8);

        Integer result = fibonacci.getEnteredNumber();

        assertEquals(8, result);
        verify(fibonacciNumber).getNumber();
    }
}
