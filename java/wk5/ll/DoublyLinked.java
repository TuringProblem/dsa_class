import java.util.ArrayList;

public class DoublyLinked {
  class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int value) {
      this.value = value;
      this.next = null;
      this.prev = null;
    }
  }

  private Node head;
  private Node tail;
  public int length;

  public DoublyLinked() {
    this.head = null;
    this.tail = null;
    this.length = 0;

  }

  public DoublyLinked(int value) {
    this.head = new Node(value);
    this.tail = head;
    this.length = 1;
  }

  public static void append(Node newNode) {
    if (head == null) {
      head = newNode;
      tail = newNode;

    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
  }

  public static void prepend(Node newNode) {
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }

  }

  public static void testCase() {
    ArrayList<Node> nodes = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      nodes.add(new Node(i));
    }
    DoublyLinked list = new DoublyLinked();
    for (Node node : nodes) {
      list.append(node);
    }
  }

  public static void main(String[] args) {
    testCase();
  }

}
