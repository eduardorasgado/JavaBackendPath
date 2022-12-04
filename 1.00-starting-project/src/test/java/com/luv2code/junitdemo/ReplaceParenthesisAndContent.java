package com.luv2code.junitdemo;

public class ReplaceParenthesisAndContent {

    public String replaceDisplayName(String name) {

        if(name.contains("(")) {
            return name.substring(0, name.indexOf("("));
        }
        return name;
    }
}
