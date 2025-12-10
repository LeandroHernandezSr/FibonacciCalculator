package com.test.fibonacci.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciNumberTest {

    @Test
    void testConstructorThrowsExceptionWhenNumberIsNull() {
        // then
        assertThrows(IllegalArgumentException.class, () -> new FibonacciNumber(null, null));
    }

    @Test
    void testGetNumberReturnsCorrectValue() {
        FibonacciNumber fn = new FibonacciNumber(7, null);
        assertEquals(7, fn.getNumber());
    }

    @Test
    void testGetNthNumberUsesProvidedValue() {
        FibonacciNumber fn = new FibonacciNumber(8, 100); // nthNumber viene dado
        assertEquals(100, fn.getNthNumber());
    }

    @Test
    void testCalculateFibonacciForZero() {
        FibonacciNumber fn = new FibonacciNumber(0, null);
        assertEquals(0, fn.getNthNumber());
    }

    @Test
    void testCalculateFibonacciForOne() {
        FibonacciNumber fn = new FibonacciNumber(1, null);
        assertEquals(1, fn.getNthNumber());
    }

    @Test
    void testCalculateFibonacciForFive() {
        // Fibonacci(5) = 5
        FibonacciNumber fn = new FibonacciNumber(5, null);
        assertEquals(5, fn.getNthNumber());
    }

    @Test
    void testCalculateFibonacciForTen() {
        // Fibonacci(10) = 55
        FibonacciNumber fn = new FibonacciNumber(10, null);
        assertEquals(55, fn.getNthNumber());
    }

    @Test
    void testCalculateFibonacciForLargeNumber() {
        // Fibonacci(15) = 610
        FibonacciNumber fn = new FibonacciNumber(15, null);
        assertEquals(610, fn.getNthNumber());
    }
}
