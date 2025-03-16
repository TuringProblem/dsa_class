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

  public void append(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    length++;
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
    length++;
  }

  public void insertAfter(SinglyLinked list, Node current, Node newNode) {
    if (list.head == null) {
      list.head = newNode;
      list.tail = newNode;
    } else if (current == list.tail) {
      list.tail.next = newNode;
      list.tail = newNode;
    } else {
      newNode.next = current.next;
      current.next = newNode;
    }

  }

  public static void main(String[] args) {
    SinglyLinked singlyLL = new SinglyLinked();
    singlyLL.append(85);
    singlyLL.append(1);
    singlyLL.append(55);
    singlyLL.append(2);
    System.out.println(singlyLL.toString());

    SinglyLinked singlyLLTwo = new SinglyLinked(15);
    singlyLLTwo.append(85);
    singlyLLTwo.append(92);
    singlyLLTwo.append(9);
    singlyLLTwo.insertAfter(singlyLLTwo, 9, new Node(55));
    singlyLLTwo.append(7);
    singlyLLTwo.append(12);
    System.out.println(singlyLLTwo.toString());

    singlyLL.getLength();
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
