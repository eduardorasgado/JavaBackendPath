package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach(TestReporter testReporter) {
        testReporter.publishEntry("@BeforeEach executes before the execution of each test method");

        demoUtils = new DemoUtils();
    }

    @AfterEach
    void tearDownAfterEach(TestReporter testReporter) {
        testReporter.publishEntry("@AfterEach executes before the execution of each test method");
    }

    @BeforeAll
    static void setupBeforeEachClass() {
        System.out.println("@BeforeAll executes only once before all test methods execution in the class");
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("@AfterAll executes only once after all test methods execution n the class");
    }

    @Test
    void testEqualsAndNotEquals(TestReporter testReporter) {
        testReporter.publishEntry("Running test: testEqualsAndNotEquals");

        assertEquals(6, demoUtils.add(2, 4), "2 + 4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+ 9 must not be 6");
    }

    @Test
    void testNullAndNotNull(TestReporter testReporter) {
        testReporter.publishEntry("Running test: testNullAndNotNull");

        String str1 = null;
        String str2 = "eduardo";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }
}
