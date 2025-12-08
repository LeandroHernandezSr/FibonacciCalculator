package com.test.fibonacci.domain.model;

public class FibonacciNumber {

    private final Integer number;
    private final Integer nthNumber;

    public FibonacciNumber(Integer number,Integer nthNumber) {
        if (number == null) throw new IllegalArgumentException("The number cannot be null!");
        this.number = number;
        this.nthNumber = nthNumber != null ? nthNumber : calculateNthFibonacci();
    }

    public Integer getNumber() {
        return this.number;
    }

    public Integer getNthNumber(){
        return this.nthNumber;
    }

    private Integer calculateNthFibonacci(){
        if (number == 0) return 0;
        if (number == 1) return  1;

        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 2; i <= number; i++){
            c = a + b;
            a = b;     
            b = c;     
        }

        return c;
    }
}
