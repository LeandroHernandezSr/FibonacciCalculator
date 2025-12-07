package com.test.fibonacci.infrastructure.adapters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.fibonacci.infrastructure.adapters.entities.FibonacciEntity;

public interface FibonacciJpaRepository extends JpaRepository<FibonacciEntity,Long> {
    @Query(value = "SELECT * FROM fibonacci_numbers WHERE number = :num", nativeQuery = true)
    FibonacciEntity findByNumber(@Param("num") Integer num);
}
