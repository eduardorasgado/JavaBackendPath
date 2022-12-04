package com.luv2code.tdd;

// If number si divisible by 3, print Fizz
// If number is divisible  by 5, print Buzz
// If number is divisible by 3 and 5, print FizzBuzz
// If number is NOT divisible by 3 or 5, then print the number
public class FizzBuzz {
    public static String compute(int i) {
        StringBuilder stringBuilder = new StringBuilder();

        if(i % 3 == 0) {
            stringBuilder.append("Fizz");
        }

        if(i % 5 == 0) {
            stringBuilder.append("Buzz");
        }

        if(stringBuilder.length() == 0) {
            stringBuilder.append(i);
        }

        return stringBuilder.toString();
    }
}
