package com.eduardocode.scottbarretcourse.algorithms.recursion.factorial;

import java.math.BigInteger;

public class FactorialExample {

    private static BigInteger factorial(BigInteger number) {
        if(number.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }

        return number.multiply(factorial(number.subtract(BigInteger.ONE)));
    }

    private static long factorialLong(long number) {
        return (number == 1) ? 1 : number * factorialLong(number - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(BigInteger.valueOf(4)));
        System.out.println(factorial(BigInteger.valueOf(10)));
        System.out.println(factorial(BigInteger.valueOf(100)));

        System.out.println(factorialLong(10));
    }
}
