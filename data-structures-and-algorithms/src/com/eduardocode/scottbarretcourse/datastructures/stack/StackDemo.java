package com.eduardocode.scottbarretcourse.datastructures.stack;

public class StackDemo {

    public static void main(String[] args) {
        push();
    }

    private static void push() {
        Stack stack = new Stack();

        stack.push(10);
        stack.printStack();
        stack.push(8);
        stack.printStack();
        stack.push(4);
        stack.printStack();
    }

    private static void create() {
        Stack stack = new Stack(5);

        System.out.println(stack.getTop());
        System.out.println(stack.getHeight());

        stack.printStack();
    }
}
