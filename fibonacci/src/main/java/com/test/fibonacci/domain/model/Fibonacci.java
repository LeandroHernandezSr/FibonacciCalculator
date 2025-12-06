package com.test.fibonacci.domain.model;

public class Fibonacci {

    private FibonacciNumber number;
    private Boolean wasCalculated;

    public Fibonacci(FibonacciNumber number){
        this.number=number;
        this.wasCalculated=true;
    }

    public Integer getNthNumber() {
        return number.calculateNthFibonacci();
    }

    public Boolean getWasCalculated() {
        return wasCalculated;
    }
    
}   
