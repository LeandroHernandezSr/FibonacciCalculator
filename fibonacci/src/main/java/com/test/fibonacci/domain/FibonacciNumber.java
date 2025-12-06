package com.test.fibonacci.domain;

public class FibonacciNumber {

    private Integer number;

    public FibonacciNumber(Integer number) {
        if (number == null) throw new IllegalArgumentException("The number cannot be null!");
        this.number = number;
    }

    public Integer getNumber() {
        return this.number;
    }

    public Integer calculateNthFibonacci(){
        if (number == 0) return 0;
        if (number == 1) return 1;

        Integer a = 0; 
        Integer b = 1;
        Integer c = 0;

        for (Integer i = 2; i <= number; i++){
            c = a + b;
            a = b;     
            b = c;     
        }

        return c;
    }
}
