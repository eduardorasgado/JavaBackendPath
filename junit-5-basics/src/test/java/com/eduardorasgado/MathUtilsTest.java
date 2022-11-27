package com.eduardorasgado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void testAdd() {
		MathUtils mathUtils = new MathUtils();

		int expected = 2;
		int actual = mathUtils.add(1, 1);

		assertEquals(expected, actual, "The add method should add two numbers");
	}

	@Test
	void testDivideByZero() {
		MathUtils mathUtils = new MathUtils();

		// this will fail if wrong exception or no exception is thrown
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(5, 0), "Divide by zero should throw");
	}

	@Test
	void testComputeCircleArea() {
		MathUtils mathUtils = new MathUtils();

		double expected = 201.06192982974676;
		double actual = mathUtils.computeCircleArea(8);

		assertEquals(expected, actual, "Should return right circle area");
	}
}
