package com.eduardocode.objectorienteddesign.designpatterns.behavioral.templatemethod.compiler;

public class AndroidCompiler extends CrossCompiler {

    @Override
    protected void collectSources() {
        System.out.println("Collect Android specific sources");
    }

    @Override
    protected void compileToTarget() {
        System.out.println("Android compilation");
    }

    @Override
    protected void afterCompileHook() {
        System.out.println("Android after compile hook");
    }
}
