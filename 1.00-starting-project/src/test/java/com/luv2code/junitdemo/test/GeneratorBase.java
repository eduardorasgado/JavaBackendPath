package com.luv2code.junitdemo.test;

public class GeneratorBase implements CustomDisplayNameReplacer {
    CustomDisplayNameReplacer nextGenerator;

    @Override
    public void setNext(CustomDisplayNameReplacer generator) {
        nextGenerator = generator;
    }

    @Override
    public String replaceDisplayName(String name) {
        if(nextGenerator != null) {
            return nextGenerator.replaceDisplayName(name);
        }
        return name;
    }
}
