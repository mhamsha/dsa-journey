public class Queue {
    // Pointers to the front and rear of the queue
    private Node front;
    private Node rear;

    // Static nested Node class to represent each element in the queue
    static class Node {
        int value; // Value of the node
        Node next; // Pointer to the next node

        // Constructor to initialize the node with a value
        Node(int value) {
            this.value = value;
            this.next = null; // Next is initially null
        }
    }

    // Constructor to initialize an empty queue
    public Queue() {
        this.front = null; // Front pointer is null initially
        this.rear = null; // Rear pointer is null initially
    }

    // Enqueue an element to the end of the queue
    public void enqueue(int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);

        // If the queue is empty, both front and rear will point to the new node
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            // Otherwise, add the new node at the end and update the rear
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue an element from the front of the queue
    public int dequeue() {
        // If the queue is empty, throw an exception
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }

        // Get the value from the front node
        int value = front.value;

        // Move the front pointer to the next node
        front = front.next;

        // If the queue becomes empty, set the rear pointer to null
        if (front == null) {
            rear = null;
        }

        // Return the dequeued value
        return value;
    }

    // Print all elements in the queue
    public void printQueue() {
        // Start from the front of the queue
        Node current = front;

        // Traverse the queue and print each element
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }

        // Print a new line at the end
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue(); // Output: 10 20 30

        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 10
        queue.printQueue(); // Output: 20 30

        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 20
        queue.printQueue(); // Output: 30

        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 30
        queue.printQueue(); // Output: (empty line)
    }
}

// public class Queue {
// private int[] queueArray;
// private int capacity;
// private int in;
// private int out;
// private int size;

// public Queue(int capacity) {
// this.capacity = capacity;
// this.queueArray = new int[capacity];
// this.in = 0;
// this.out = 0;
// this.size = 0;
// }

// // Check if the queue is empty
// public boolean isEmpty() {
// return size == 0;
// }

// // Check if the queue is full
// public boolean isFull() {
// return size == capacity;
// }

// // Enqueue an element to the end of the queue
// public void enqueue(int value) {
// if (isFull()) {
// throw new IllegalStateException("Queue is full");
// }
// queueArray[in] = value;
// in = (in + 1) % capacity;
// size++;
// }

// // Dequeue an element from the front of the queue
// public int dequeue() {
// if (isEmpty()) {
// throw new IllegalStateException("Queue is empty");
// }
// int value = queueArray[out];
// out = (out + 1) % capacity;
// size--;
// return value;
// }

// // Print all elements in the queue
// public void printQueue() {
// if (isEmpty()) {
// System.out.println("Queue is empty");
// return;
// }
// int count = size;
// int index = out;
// while (count > 0) {
// System.out.print(queueArray[index] + " ");
// index = (index + 1) % capacity;
// count--;
// }
// System.out.println();
// }

// public static void main(String[] args) {
// Queue queue = new Queue(5);
// queue.enqueue(10);
// queue.enqueue(20);
// queue.enqueue(30);
// queue.printQueue(); // Output: 10 20 30

// System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 10
// queue.printQueue(); // Output: 20 30

// System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 20
// queue.printQueue(); // Output: 30

// System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 30
// queue.printQueue(); // Output: Queue is empty

// queue.enqueue(40);
// queue.enqueue(50);
// queue.enqueue(60);
// queue.enqueue(70);
// queue.enqueue(80);
// queue.printQueue(); // Output: 40 50 60 70 80

// // Uncommenting the next line will throw an exception because the queue is
// full
// // queue.enqueue(90); // Throws IllegalStateException: Queue is full
// }
// }