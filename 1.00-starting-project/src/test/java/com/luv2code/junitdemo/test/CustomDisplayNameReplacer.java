package com.luv2code.junitdemo.test;

public interface CustomDisplayNameReplacer {
    void setNext(CustomDisplayNameReplacer generator);
    String replaceDisplayName(String name);
}
