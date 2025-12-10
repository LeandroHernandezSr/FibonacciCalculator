package com.test.fibonacci.infrastructure.adapters;

import com.test.fibonacci.domain.model.Fibonacci;
import com.test.fibonacci.domain.model.FibonacciId;
import com.test.fibonacci.domain.model.FibonacciNumber;
import com.test.fibonacci.infrastructure.adapters.entities.FibonacciEntity;
import com.test.fibonacci.infrastructure.adapters.repositories.FibonacciJpaRepository;
import com.test.fibonacci.infrastructure.adapters.repositories.FibonacciRepositoryImpl;
import com.test.fibonacci.infrastructure.mapper.FibonacciMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FibonacciRepositoryTest {

    @Mock
    private FibonacciJpaRepository jpaRepository;

    @Mock
    private FibonacciMapper mapper;

    @InjectMocks
    private FibonacciRepositoryImpl repository;

    private Fibonacci model;
    private FibonacciEntity entity;

    @BeforeEach
    void setup() {
        model = new Fibonacci(new FibonacciId(1L), new FibonacciNumber(6, 8,8));
        entity = new FibonacciEntity();
        entity.setId(1L);
        entity.setNumber(6);
        entity.setNthNumber(8);
        entity.setOccurrences(8);
    }

    @Test
    void testSaveFibonacciEntity() {
        // given
        when(mapper.modelToEntity(model)).thenReturn(entity);
        when(jpaRepository.save(entity)).thenReturn(entity);
        when(mapper.entityToModel(entity)).thenReturn(model);

        // when
        Optional<Fibonacci> result = repository.saveFibonacciEntity(model);

        // then
        assertTrue(result.isPresent());
        assertEquals(model, result.get());

        verify(mapper).modelToEntity(model);
        verify(jpaRepository).save(entity);
        verify(mapper).entityToModel(entity);
    }

    @Test
    void testGetFibonnaciEntityByNumber() {
        // given
        when(jpaRepository.findByNumber(6)).thenReturn(Optional.of(entity));
        when(mapper.entityToModel(entity)).thenReturn(model);

        // when
        Optional<Fibonacci> result = repository.getFibonnaciEntityByNumber(6);

        // then
        assertTrue(result.isPresent());
        assertEquals(model, result.get());

        verify(jpaRepository).findByNumber(6);
        verify(mapper).entityToModel(entity);
    }

    @Test
    void testGetAllEntities() {
        // given
        List<FibonacciEntity> entities = List.of(entity);
        List<Fibonacci> models = List.of(model);

        when(jpaRepository.findAll()).thenReturn(entities);
        when(mapper.entityToModel(entity)).thenReturn(model);

        // when
        List<Fibonacci> result = repository.getAllEntities();

        // then
        assertEquals(1, result.size());
        assertEquals(model, result.get(0));

        verify(jpaRepository).findAll();
        verify(mapper).entityToModel(entity);
    }
}
