class Doublylist {
    Node head;

    static class Node {
        int value;
        Node next;
        Node prev; // # changes in double

        Node(int val) {
            this.value = val;
            this.next = null;
            this.prev = null; // # changes in double
        }
    }

    void printList() {
        StringBuilder ret_str = new StringBuilder("[");
        Node last = this.head;
        while (last != null) {
            ret_str.append(last.value).append(", ");
            last = last.next;
        }
        if (ret_str.length() > 1) {
            ret_str.setLength(ret_str.length() - 2); // Remove trailing comma and space
        }
        ret_str.append("]");
        System.out.println(ret_str);
    }

    void push(int val) {
        Node new_node = new Node(val);

        // If the list is empty, set the new node as the head
        if (this.head == null) {
            this.head = new_node;
            return;
        }

        // Otherwise, traverse to the end of the list and add the new node
        Node last = this.head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
        new_node.prev = last; // # changes in double
    }

    void insert(int val, int idx) {
        Node new_node = new Node(val);

        // Insert at the head if index is 0
        if (idx == 0) {
            new_node.next = this.head;
            if (this.head != null) {
                this.head.prev = new_node; // # changes in double
            }
            this.head = new_node;
            return;
        }

        // Traverse to the specified index
        Node last = this.head;
        Node prev = null;
        int counter = 0;
        while (last != null && counter < idx) {
            prev = last;
            last = last.next;
            counter++;
        }

        // Insert the new node at the specified index
        if (prev != null) {
            new_node.next = last;
            new_node.prev = prev; // # changes in double
            prev.next = new_node;
            if (last != null) {
                last.prev = new_node; // # changes in double
            }
        } else {
            throw new IndexOutOfBoundsException("Invalid Index! No Insert");
        }
    }

    void remove(int idx) {
        // Remove the head node if index is 0
        if (idx == 0) {
            if (this.head != null) {
                this.head = this.head.next;
                if (this.head != null) {
                    this.head.prev = null; // # changes in double
                }
            } else {
                throw new IndexOutOfBoundsException("Invalid Index! No Delete");
            }
            return;
        }

        // Traverse to the specified index
        Node last = this.head;
        Node prev = null;
        int counter = 0;
        while (last != null && counter < idx) {
            prev = last;
            last = last.next;
            counter++;
        }

        // Remove the node at the specified index
        if (last != null) {
            prev.next = last.next;
            if (last.next != null) {
                last.next.prev = prev; // # changes in double
            }
        } else {
            throw new IndexOutOfBoundsException("Invalid Index! No Delete");
        }
    }

    void pop() {
        if (this.head == null) {
            throw new IndexOutOfBoundsException("Invalid Index! No Delete");
        }
        if (this.head.next == null) {
            this.head = null;
            return;
        }
        Node last = this.head;
        while (last.next != null) {
            last = last.next;
        }
        System.out.println("Popped: " + last.value);

        if (last.prev != null) {
            last.prev.next = null; // # changes in double
        }
    }

    public static void main(String[] args) {
        Doublylist list = new Doublylist();
        list.push(1);
        list.push(2);
        list.push(3);
        list.printList(); // Output: [1, 2, 3]
        list.insert(4, 1);
        list.printList(); // Output: [1, 4, 2, 3]
        list.remove(2);
        list.printList(); // Output: [1, 4, 3]
        list.pop();
        list.printList(); // Output: [1, 4]
    }
}