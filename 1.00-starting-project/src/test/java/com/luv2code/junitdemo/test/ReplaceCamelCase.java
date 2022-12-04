package com.luv2code.junitdemo.test;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

public class ReplaceCamelCase extends DisplayNameGenerator.Standard {
    private final CustomDisplayNameReplacer displayNameReplacer;

    public ReplaceCamelCase() {
        CustomDisplayNameReplacer capitalReplacer = new ReplaceCapitals();
        CustomDisplayNameReplacer numberReplacer = new ReplaceNumbers();
        CustomDisplayNameReplacer replaceParenthesisAndContent = new ReplaceParenthesisAndContent();
        CustomDisplayNameReplacer replacePrefix = new ReplacePrefix();

        capitalReplacer.setNext(numberReplacer);
        numberReplacer.setNext(replaceParenthesisAndContent);
        replaceParenthesisAndContent.setNext(replacePrefix);

        displayNameReplacer = capitalReplacer;
    }

    public String generateDisplayNameForClass(Class<?> testClass) {
        return displayNameReplacer.replaceDisplayName(super.generateDisplayNameForClass(testClass));
    }

    public String generateDisplayNameForNestedClass(Class<?> nestedTestClass) {
        return displayNameReplacer.replaceDisplayName(super.generateDisplayNameForNestedClass(nestedTestClass));
    }

    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
        return displayNameReplacer.replaceDisplayName((super.generateDisplayNameForMethod(testClass, testMethod)));
    }
}
