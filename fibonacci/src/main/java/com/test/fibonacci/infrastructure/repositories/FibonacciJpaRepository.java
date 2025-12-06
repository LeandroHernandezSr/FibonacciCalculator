package com.test.fibonacci.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.fibonacci.infrastructure.entities.FibonacciEntity;

public interface FibonacciJpaRepository extends JpaRepository<FibonacciEntity,Long> {}
