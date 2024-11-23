package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestQueueTees {

    QueueTees queue;

    @BeforeEach
    void setUp() {
        queue = new QueueTees();
    }

    @Test
    void testEnqueueAndDequeue() {
        Cutie cuteObject = new Cutie("A very cute object.", 10);

        queue.enqueue(cuteObject);
        assertEquals(1, queue.currentSize());  
        assertEquals(cuteObject, queue.dequeue());  
        assertEquals(0, queue.currentSize());  
    }

    @Test
    void testQueueFull() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(new Cutie("Cute object " + i, 10));
        }
        assertEquals(10, queue.currentSize());  

        queue.enqueue(new Cutie("Another cute object.", 10));  
        assertEquals(10, queue.currentSize());  
    }

    @Test
    void testDequeueEmptyQueue() {
        Cutie cutie = queue.dequeue();  
        assertEquals(null, cutie);  
    }

    @Test
    void testCircularBehavior() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(new Cutie("Object " + i, 10));
        }
        assertEquals(10, queue.currentSize());  

        queue.dequeue();  
        queue.enqueue(new Cutie("New Cute Object", 10));  
        assertEquals(10, queue.currentSize()); 
    }
}
