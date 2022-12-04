package com.luv2code.junitdemo;

import com.luv2code.junitdemo.test.ReplaceCamelCase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

@DisplayNameGeneration(ReplaceCamelCase.class)
public class ConditionalTest {

    @Test
    @Disabled("Don't run until JIRA #123 is resolved")
    void testBasic() {
        // executing method
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnly() {
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnly() {
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.WINDOWS})
    void testForMacAndWindowsOnly() {
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinuxOnly() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testForJava11Only() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testForJava8Only() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
    void testForJavaBetween11And17() {
    }

    @Test
    @EnabledForJreRange(max = JRE.JAVA_8)
    void testForJavaMax8() {
    }
}
