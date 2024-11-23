package com.csc;

public class QueueTees {
    private Cutie[] queue;
    private int front;
    private int rear;
    private int size;
    private static final int MAX_SIZE = 10;

    public QueueTees() {
        this.queue = new Cutie[MAX_SIZE];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(Cutie cutie) {
        if (size == MAX_SIZE) {
            System.out.println("Queue is full. Cannot enqueue " + cutie.getDescription());
            return;
        }
        rear = (rear + 1) % MAX_SIZE;
        queue[rear] = cutie;
        size++;
    }

    public Cutie dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        Cutie cutie = queue[front];
        front = (front + 1) % MAX_SIZE;
        size--;
        return cutie;
    }

    public int currentSize() {
        return size;
    }
}
