package com.luv2code.junitdemo.test;

public class ReplaceCapitals extends GeneratorBase {

    @Override
    public String replaceDisplayName(String name) {
        return super.replaceDisplayName(name.replaceAll("([A-Z])", " $1"));
    }
}
