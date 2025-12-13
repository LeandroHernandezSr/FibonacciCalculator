package com.test.fibonacci.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FibonacciTest {

    @Mock
    private FibonacciId fibonacciId;

    @Mock
    private FibonacciNumber fibonacciNumber;

    private Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = new Fibonacci(fibonacciId, fibonacciNumber);
    }

    @Test
    void testGetNthNumberDelegatesToFibonacciNumber() {
        // given
        when(fibonacciNumber.getNthNumber()).thenReturn(21L);

        // when
        Long result = fibonacci.getNthNumber();

        // then
        assertEquals(21, result);
        verify(fibonacciNumber).getNthNumber();
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
    void testGetEnteredNumberDelegatesToFibonacciNumber() {
        // given
        when(fibonacciNumber.getNumber()).thenReturn(8);

        // when
        Integer result = fibonacci.getEnteredNumber();

        // then
        assertEquals(8, result);
        verify(fibonacciNumber).getNumber();
    }
}
