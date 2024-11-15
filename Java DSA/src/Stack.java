public class Stack {
    private Node top;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public Stack() {
        this.top = null;
    }

    // Push an element onto the stack
    public void push(int value) {
        Node new_node = new Node(value);
        new_node.next = top;
        top = new_node;
    }

    // Pop an element from the stack
    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = top.value;
        top = top.next;
        return value;
    }

    // Peek at the top element of the stack
    public int peek() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.value;
    }

    // Print all elements in the stack
    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack(); // Output: 30 20 10

        // System.out.println("Peek: " + stack.peek()); // Output: Peek: 30
        // System.out.println("Pop: " + stack.pop());   // Output: Pop: 30
        // stack.printStack(); // Output: 20 10
    }
}