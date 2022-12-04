package com.luv2code.junitdemo;

import com.luv2code.junitdemo.test.ReplaceCamelCase;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(ReplaceCamelCase.class)
// the lowest value has the higher priority
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach(TestReporter testReporter) {
        testReporter.publishEntry("@BeforeEach executes before the execution of each test method");

        demoUtils = new DemoUtils();
    }

    @Test
    //@DisplayName("Equals and not equals")
    void testEqualsAndNotEquals(TestReporter testReporter) {
        testReporter.publishEntry("Running test: testEqualsAndNotEquals");

        assertEquals(6, demoUtils.add(2, 4), "2 + 4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+ 9 must not be 6");
    }

    @Test
    //@DisplayName("Null and not null")
    @Order(-1)
    void testNullAndNotNull(TestReporter testReporter) {
        testReporter.publishEntry("Running test: testNullAndNotNull");

        String str1 = null;
        String str2 = "eduardo";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @Test
    void testSameAndNotSame() {
        String str = "luv2Code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to the same object");
        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to same object");
    }

    @Test
    void testTrueAndFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
    }

    @Test
    @Order(4)
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};

        assertArrayEquals(stringArray,demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be equals");
    }

    @Test
    void testIterableEquals() {
        List<String> expectedIterable = List.of("luv", "2", "code");

        assertIterableEquals(expectedIterable, demoUtils.getAcademyInList(), "Expected iterable should be  same as actual iterable");
    }

    @Test
    @Order(2)
    void testLinesMatch() {
        List<String> expectedIterable = List.of("luv", "\\d+", "code");

        assertLinesMatch(expectedIterable, demoUtils.getAcademyInList(), "Lines should match");
    }

    @Test
    @Order(3)
    void testThrowsAndDoesNotThrow() {
        assertThrows(Exception.class, () -> demoUtils.throwException(-1), "Should throw exception");
        assertDoesNotThrow(() -> demoUtils.throwException(5), "Should not throw exception");
    }

    @Test
    @Order(1)
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> demoUtils.checkTimeout(), "Method should execute in 3 secs");
    }

   /* @Test
    void testMultiplyByZero() {
        assertEquals(0, demoUtils.multiply(4, 0), "Multiplying by zero should return zero");
    }*/
    
    /*
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
    }*/
}
