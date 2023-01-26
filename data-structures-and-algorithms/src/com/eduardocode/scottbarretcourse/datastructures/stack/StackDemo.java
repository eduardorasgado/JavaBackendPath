package com.eduardocode.scottbarretcourse.datastructures.stack;

public class StackDemo {

    public static void main(String[] args) {
        create();
    }

    private static void create() {
        Stack stack = new Stack(5);
        stack.getTop();
        stack.getHeight();

        stack.printStack();
    }
}
