package com.eduardocode.objectorienteddesign.designpatterns.behavioral.templatemethod.compiler;

public class CompilerDemo {

    public static void main(String[] args) {
        CrossCompiler compiler = new IPhoneCompiler();
        compiler.compile();

        System.out.println("===============================");

        compiler = new AndroidCompiler();
        compiler.compile();
    }
}
