package com.eduardocode.scottbarretcourse.datastructures.queue;

public class QueueDemo {

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enque(6);
        queue.print();
        queue.enque(5);
        queue.print();
        queue.enque(4);
        queue.print();

        System.out.println("dequeue: " + queue.dequeue());
        queue.print();
        System.out.println("dequeue: " + queue.dequeue());
        queue.print();
        System.out.println("dequeue: " + queue.dequeue());
        queue.print();
        System.out.println("dequeue: " + queue.dequeue());
        queue.print();

        queue.enque(15);
        queue.print();
        queue.enque(14);
        queue.print();
    }
}
