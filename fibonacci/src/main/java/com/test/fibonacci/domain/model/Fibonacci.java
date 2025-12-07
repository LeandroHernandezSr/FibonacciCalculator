package com.test.fibonacci.domain.model;

public class Fibonacci {

    private FibonacciId fibonacciId;
    private FibonacciNumber number;

    public Fibonacci(FibonacciId fibonacciId,FibonacciNumber number){
        this.number=number;
        this.fibonacciId=fibonacciId;
    }

    public Integer getNthNumber() {
        return number.getNthNumber();
    }

    public Long getId(){
        return this.fibonacciId.getId();
    }
    
    public Integer getEnteredNumber(){
        return this.number.getNumber();
    }

}   
