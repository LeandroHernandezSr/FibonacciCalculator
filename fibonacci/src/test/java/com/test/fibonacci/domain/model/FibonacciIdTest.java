package com.test.fibonacci.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciIdTest {

    @Test
    void testConstructorStoresId() {
        // given
        Long expectedId = 5L;

        // when
        FibonacciId fibonacciId = new FibonacciId(expectedId);

        // then
        assertEquals(expectedId, fibonacciId.getId());
    }

    @Test
    void testGetIdReturnsCorrectValue() {
        // given
        FibonacciId fibonacciId = new FibonacciId(99L);

        // when
        Long result = fibonacciId.getId();

        // then
        assertEquals(99L, result);
    }
}
