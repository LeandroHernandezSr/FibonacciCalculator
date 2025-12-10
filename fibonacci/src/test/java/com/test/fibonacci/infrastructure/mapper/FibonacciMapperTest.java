package com.test.fibonacci.infrastructure.mapper;

import com.test.fibonacci.domain.model.Fibonacci;
import com.test.fibonacci.domain.model.FibonacciId;
import com.test.fibonacci.domain.model.FibonacciNumber;
import com.test.fibonacci.infrastructure.adapters.entities.FibonacciEntity;
import com.test.fibonacci.infrastructure.entrypoints.dtos.FibonacciDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciMapperTest {

    private final FibonacciMapper mapper = new FibonacciMapper();

    @Test
    void testDtoToModel() {
        FibonacciDto dto = new FibonacciDto( 8);

        Fibonacci model = mapper.dtoToModel(dto);

        assertNotNull(model);
        assertEquals(8, model.getEnteredNumber());
    }

    @Test
    void testDtoToModelWhenIdIsNull() {
        FibonacciDto dto = new FibonacciDto( 13);

        Fibonacci model = mapper.dtoToModel(dto);

        assertNotNull(model);
        assertEquals(13, model.getEnteredNumber());
    }

    @Test
    void testModelToEntity() {
        Fibonacci model = new Fibonacci(
                new FibonacciId(10L),
                new FibonacciNumber(6, 8,8)
        );

        FibonacciEntity entity = mapper.modelToEntity(model);

        assertNotNull(entity);
        assertEquals(10L, entity.getId());
        assertEquals(6, entity.getNumber());
        assertEquals(8, entity.getNthNumber());
        assertEquals(8,entity.getOccurrences());
    }

    @Test
    void testEntityToModel() {
        FibonacciEntity entity = new FibonacciEntity();
        entity.setId(22L);
        entity.setNumber(7);
        entity.setNthNumber(13);

        Fibonacci model = mapper.entityToModel(entity);

        assertNotNull(model);
        assertEquals(22L, model.getId());
        assertEquals(7, model.getEnteredNumber());
        assertEquals(13, model.getNthNumber());
    }
}
