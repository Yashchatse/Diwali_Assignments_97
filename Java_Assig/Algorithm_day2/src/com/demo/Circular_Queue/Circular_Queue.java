package com.demo.Circular_Queue;

public class Circular_Queue {
private int[] queue;
private int rear;
private int front;
private int size;
private int capcity;

public Circular_Queue(int initalCapcity) {
this.capcity = initalCapcity;
this.queue = new int [capcity];
this.front = -1;
this.rear=-1;
this.size = 0;
}

public boolean isEmpty() {
	return size == 0;
}
public boolean isFull() {
	return size == capcity;
}

public void resize() {
	int[] newQueue = new int[capcity * 2];
	int index = 0;
	
	for(int i = front ; i < capcity; i++) {
		newQueue[index++] = queue[i];
	}
	for(int i = 0; i <=rear ; i++) {
		newQueue[index++] = queue[i];
	}
	queue = newQueue;
	front = 0;
	rear= size -1;
	capcity *= 2;
}
public void enqueue(int value) {
	if(isFull()) {
		resize();
	}
	if(isEmpty()) {
		front =0;
		rear = 0;
	}
	else {
		rear = (rear + 1 ) % capcity;
	}
	queue[rear] = value;
	size++;
}

public int dequeue() {
    if (isEmpty()) {
        throw new RuntimeException("Queue is empty");
    }
    int value = queue[front];
    if (front == rear) {
        front = -1;
        rear = -1;
    } else {
        front = (front + 1) % capcity;
    }
    size--;
    return value;
}

public void display() {
    if (isEmpty()) {
        System.out.println("Queue is empty");
        return;
    }
    System.out.print("Queue: ");
    int i = front;
    for (int count = 0; count < size; count++) {
        System.out.print(queue[i] + " ");
        i = (i + 1) % capcity;
    }
    System.out.println();
}
public static void main(String [] args) {
	Circular_Queue  q = new Circular_Queue(3);
	  System.out.println("=== Enqueuing elements ===");
      q.enqueue(10);
      q.enqueue(20);
      q.enqueue(30);
      q.display(); 

      System.out.println("\n=== Enqueuing 40 (should resize) ===");
      q.enqueue(40);
      q.display(); 

      System.out.println("\n=== Dequeuing one element ===");
      System.out.println("Dequeued: " + q.dequeue()); 
      q.display();

      System.out.println("\n=== Enqueuing more elements ===");
      q.enqueue(50);
      q.enqueue(60);
      q.display();

	
	
}

}

