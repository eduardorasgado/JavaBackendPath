package com.eduardocode.objectorienteddesign.designpatterns.behavioral.templatemethod.compiler;

public abstract class CrossCompiler {

    public final void compile() {
        collectSources();
        reverseRam();
        compileToTarget();
        afterCompileHook();
        compilationStatusNotification();
    }

    protected abstract void collectSources();

    private void reverseRam() {
        System.out.println("RAM is reserved for compilation process");
    }

    protected abstract void compileToTarget();

    protected void afterCompileHook() {
        // Nothing by default
    }

    private void compilationStatusNotification() {
        System.out.println("Compilation is successful");
    }
}
