package com.test.fibonacci.infrastructure.adapters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.fibonacci.infrastructure.adapters.entities.FibonacciEntity;

import java.util.Optional;

public interface FibonacciJpaRepository extends JpaRepository<FibonacciEntity,Long> {
    @Query(value = "SELECT * FROM numbers WHERE number = :num", nativeQuery = true)
    Optional<FibonacciEntity> findByNumber(@Param("num") Integer num);
}
