package com.eduardocode.scottbarretcourse.datastructures.queue;

public class QueueDemo {

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(6);
        queue.print();
        queue.enqueue(5);
        queue.print();
        queue.enqueue(4);
        queue.print();

        System.out.println("dequeue: " + queue.dequeue());
        queue.print();
        System.out.println("dequeue: " + queue.dequeue());
        queue.print();
        System.out.println("dequeue: " + queue.dequeue());
        queue.print();
        System.out.println("dequeue: " + queue.dequeue());
        queue.print();

        queue.enqueue(15);
        queue.print();
        queue.enqueue(14);
        queue.print();
    }
}
