package com.luv2code.junitdemo;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

public class ReplaceCamelCase extends DisplayNameGenerator.Standard {
    private final ReplaceParenthesisAndContent replaceParenthesisAndContentUtil;

    public ReplaceCamelCase() {
        this.replaceParenthesisAndContentUtil = new ReplaceParenthesisAndContent();
    }

    public String generateDisplayNameForClass(Class<?> testClass) {
        return replaceDisplayName(super.generateDisplayNameForClass(testClass));
    }

    public String generateDisplayNameForNestedClass(Class<?> nestedTestClass) {
        return replaceDisplayName(super.generateDisplayNameForNestedClass(nestedTestClass));
    }

    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
        return replaceDisplayName((super.generateDisplayNameForMethod(testClass, testMethod)));
    }

    public String replaceDisplayName(String name) {
        return replaceNumbers(replaceCapitals(replaceParenthesisAndContentUtil.replaceDisplayName(name)));
    }

    public String replaceCapitals(String name) {
        return name.replaceAll("([A-Z])", " $1");
    }

    public String replaceNumbers(String name) {
        return name.replaceAll("([0-9]+)", " $1");
    }


}
