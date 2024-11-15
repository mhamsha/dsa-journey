public class Singlylist {
    Node head;

    static class Node {
        int value;
        Node next;

        Node(int val) {
            this.value = val;
            // this.next = null;
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
    }

    void insert(int val, int idx) {
        Node new_node = new Node(val);

        // Insert at the head if index is 0
        if (idx == 0) {
            new_node.next = this.head;
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
            prev.next = new_node;
        } else {
            throw new IndexOutOfBoundsException("Invalid Index! No Insert");
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
        Node prev = null;
        while (last.next != null) {
            prev = last;
            last = last.next;
        }
        System.out.println("Popped: " + last.value);

        prev.next = null;
    }

    void remove(int idx) {
        // Remove the head node if index is 0
        if (idx == 0) {
            if (this.head != null) {
                this.head = this.head.next;
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
        } else {
            throw new IndexOutOfBoundsException("Invalid Index! No Delete");
        }
    }

    public static void main(String[] args) {
        Singlylist li = new Singlylist();
        // li.push(10);
        // li.push(20);
        li.push(30);
        li.push(40);

        // Uncomment to test insertions
        li.insert(50, 0);
        // li.insert(100, 3);
        // li.insert(3434, 232); // This will throw an exception

        // li.remove(0);
        // li.remove(213); // This will throw an exception

        // li.pop();
        // li.pop();
        // li.pop();
        li.printList(); // Output: [20, 30, 40]
    }

}
