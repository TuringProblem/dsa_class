import java.util.ArrayList;
import java.util.Random;

public class SinglyLinked {
  public static Random rand = new Random();

  class Node {
    public int value;
    public Node next;

    public Node(int value) {
      this.value = value;
      this.next = null;
    }
  }

  private Node head = null, tail = null;
  public int length;

  public SinglyLinked() {
    head = null;
    tail = null;
    length = 0;
  }

  public SinglyLinked(int value) {
    head = new Node(value);
    tail = head;
    length = 1;
  }

  public void append(Node newNode) {
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    length++;
  }

  public void prepend(Node newNode) {
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    length++;
  }

  public void insertAfter(Node current, Node newNode) {
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else if (current == tail) {
      tail.next = newNode;
      tail = newNode;
    } else {
      newNode.next = current.next;
      current.next = newNode;
    }
  }

  public static void testCaseOne() {
    SinglyLinked singlyLL = new SinglyLinked();
    ArrayList<Node> nodes = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      nodes.add(singlyLL.new Node(rand.nextInt(100)));
      System.out.println(nodes.get(i).value);
      singlyLL.append(nodes.get(i));
    }

    singlyLL.append(singlyLL.new Node(85));
    singlyLL.append(singlyLL.new Node(1));
    singlyLL.append(singlyLL.new Node(2));
    singlyLL.append(singlyLL.new Node(55));
    System.out.println(singlyLL.toString());

    SinglyLinked singlyLLTwo = new SinglyLinked(15);
    singlyLLTwo.append(singlyLLTwo.new Node(85));
    singlyLLTwo.append(singlyLLTwo.new Node(92));
    singlyLLTwo.append(singlyLLTwo.new Node(9));
    // singlyLLTwo.insertAfter(singlyLLTwo, 9, new Node(100));
    singlyLLTwo.append(singlyLLTwo.new Node(7));
    singlyLLTwo.append(singlyLLTwo.new Node(12));
    System.out.println(singlyLLTwo.toString());

  }

  public static void testCaseTwo() {
    SinglyLinked singly = new SinglyLinked();
    for (int i = 0; i < 10; i++) {
      singly.append(singly.new Node(rand.nextInt(100)));
    }

    singly.prepend(singly.new Node(85));

    singly.insertAfter(y, singly.new Node(85));

    System.out.println(singly.toString());
  }

  public static void main(String[] args) {
    testCaseOne();
  }

  public int getLength() {
    return this.length;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node current = head;
    while (current != null) {
      sb.append(current.value).append(" ");
      current = current.next;
    }
    return sb.toString();
  }
}
