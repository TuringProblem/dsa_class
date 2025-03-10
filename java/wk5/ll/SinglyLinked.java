public class SinglyLinked {

    class Node {
        int value;
        Node next;
        
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head = null, tail = null;

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public static void main(String[] args) {
        SinglyLinked singlyLL = new SinglyLinked();
        singlyLL.append(1);
        singlyLL.append(2);
        System.out.println(singlyLL.head);
    }
}
