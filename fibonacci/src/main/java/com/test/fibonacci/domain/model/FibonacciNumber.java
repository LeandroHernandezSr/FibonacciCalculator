package com.test.fibonacci.domain.model;

public class FibonacciNumber {

    private final Integer number;
    private final Long nthNumber;
    private Integer occurrences;

    public FibonacciNumber(Integer number, Long nthNumber,Integer occurrences) {
        if (number == null) throw new IllegalArgumentException("The number cannot be null!");
        this.number = number;
        this.nthNumber = nthNumber != null ? nthNumber : calculateNthFibonacci();
        this.occurrences = occurrences != null ? occurrences : 1;
    }

    public Integer getNumber() {
        return this.number;
    }

    public Long getNthNumber(){
        return this.nthNumber;
    }

    public Integer getOccurrences() {
        return this.occurrences;
    }

    public void incrementOccurrences() {
        this.occurrences++;
    }

    private Long calculateNthFibonacci(){
        if (number == 0) return 0L;
        if (number == 1) return  1L;

        long a = 0;
        long b = 1;
        long c = 0;

        for (int i = 2; i <= number; i++){
            c = a + b;
            a = b;     
            b = c;     
        }

        return c;
    }
}
