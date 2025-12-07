package com.test.fibonacci.domain.model;

public class Fibonacci {

    private FibonacciId fibonacciId;
    private FibonacciNumber number;
    private Boolean wasCalculated;

    public Fibonacci(FibonacciId fibonacciId,FibonacciNumber number){
        this.number=number;
        this.wasCalculated=true;
        this.fibonacciId=fibonacciId;
    }

    public Integer getNthNumber() {
        return number.calculateNthFibonacci();
    }

    public Boolean getWasCalculated() {
        return wasCalculated;
    }

    public Long getId(){
        return this.fibonacciId.getId();
    }
    
    public Integer getEnteredNumber(){
        return this.number.getNumber();
    }

}   
