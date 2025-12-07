package com.test.fibonacci.infrastructure.adapters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.fibonacci.infrastructure.adapters.entities.FibonacciEntity;

public interface FibonacciJpaRepository extends JpaRepository<FibonacciEntity,Long> {}
