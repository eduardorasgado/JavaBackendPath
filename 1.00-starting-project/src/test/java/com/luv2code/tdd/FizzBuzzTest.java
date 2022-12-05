package com.luv2code.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    @DisplayName("Divisible by Three")
    @Test
    @Order(1)
    void testForDivisibleByThree() {
        String expected = "Fizz";

        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    @DisplayName("Divisible by Five")
    @Test
    @Order(2)
    void testForDivisibleByFive() {
        String expected = "Buzz";

        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }

    @DisplayName("Divisible by Three and Five")
    @Test
    @Order(3)
    void testForDivisibleByThreeAndFive() {
        String expected = "FizzBuzz";

        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }

    @DisplayName("Not divisible by Three or Five")
    @Test
    @Order(4)
    void testForNotDivisibleByThreeOrFive() {
        String expected = "7";

        assertEquals(expected, FizzBuzz.compute(7), "Should return 7");
    }

    @DisplayName("Compute values from small data file")
    @ParameterizedTest(name = "value: {0}, expected: {1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    @Order(5)
    void testFizzBuzzComputeFromSmallDataFile(int value, String expected) {

        assertEquals(expected, FizzBuzz.compute(value), "Should return " + expected);
    }

    @DisplayName("Compute values from medium data file")
    @ParameterizedTest(name = "value: {0}, expected: {1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    @Order(6)
    void testFizzBuzzComputeFromMediumDataFile(int value, String expected) {

        assertEquals(expected, FizzBuzz.compute(value), "Should return " + expected);
    }

    @DisplayName("Compute values from large data file")
    @ParameterizedTest(name = "value: {0}, expected: {1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    @Order(7)
    void testFizzBuzzComputeFromLargeDataFile(int value, String expected) {

        assertEquals(expected, FizzBuzz.compute(value), "Should return " + expected);
    }
}
