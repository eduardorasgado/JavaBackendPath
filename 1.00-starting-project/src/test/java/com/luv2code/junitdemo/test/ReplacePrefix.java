package com.luv2code.junitdemo.test;

public class ReplacePrefix extends GeneratorBase {
    @Override
    public String replaceDisplayName(String name) {
        return super.replaceDisplayName(name.replaceFirst("test", ""));
    }
}
