package com.luv2code.junitdemo.test;

public class ReplaceNumbers extends GeneratorBase {

    @Override
    public String replaceDisplayName(String name) {
        return super.replaceDisplayName(name.replaceAll("([0-9]+)", " $1"));
    }
}
