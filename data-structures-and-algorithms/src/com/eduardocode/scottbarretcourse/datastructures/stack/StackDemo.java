package com.eduardocode.scottbarretcourse.datastructures.stack;

public class StackDemo {

    public static void main(String[] args) {
        pop();
    }

    private static void pop() {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(8);
        stack.push(4);
        stack.push(2);
        stack.printStack();

        System.out.println("popping: " + stack.pop().value);
        stack.printStack();
        System.out.println("popping: " + stack.pop().value);
        stack.printStack();
        System.out.println("popping: " + stack.pop().value);
        stack.printStack();
        System.out.println("popping: " + stack.pop().value);
        stack.printStack();
        System.out.println("popping: " + stack.pop());
        stack.printStack();
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
