package com.test.fibonacci.domain.model;

public class FibonacciNumber {

    private Integer number;
    private Integer nthNumber;

    public FibonacciNumber(Integer number,Integer nthNumber) {
        if (number == null) throw new IllegalArgumentException("The number cannot be null!");
        this.number = number;
        if (nthNumber == null) calculateNthFibonacci();
    }

    public Integer getNumber() {
        return this.number;
    }

    public Integer getNthNumber(){
        return this.nthNumber;
    }

    private void calculateNthFibonacci(){
        if (number == 0) nthNumber= 0;
        if (number == 1) nthNumber= 1;

        Integer a = 0; 
        Integer b = 1;
        Integer c = 0;

        for (Integer i = 2; i <= number; i++){
            c = a + b;
            a = b;     
            b = c;     
        }

        nthNumber=c;
    }
}
