package com.luv2code.junitdemo.test;

public class ReplaceParenthesisAndContent extends GeneratorBase {

    @Override
    public String replaceDisplayName(String name) {
        String newName = name.contains("(") ? name.substring(0, name.indexOf("(")) : name;

        return super.replaceDisplayName(newName);
    }
}
