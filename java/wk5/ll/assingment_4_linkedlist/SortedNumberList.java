/**
 * @author { @Override } | @since 20250328 : @22:58
 **/

public class SortedNumberList {
  public Node head;
  public Node tail;

  public SortedNumberList() {
    head = null;
    tail = null;
  }

  public void append(double number) {
    Node newNode = new Node(number);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.previous = tail;
      tail.next = newNode;
      tail = newNode;
    }
  }

  /**
   * | OVERVIEW |
   * -----------------
   * 
   * @see removeFirst() -> handles removing the first node in the list.
   * @see removeLast() -> handles removing the last node in the list.
   **/

  public Node removeFirst() {
    if (head == null)
      return null;

    Node temp = head;

    if (head == tail) {
      head = null;
      tail = null;
      return temp;
    }

    head = head.next;
    head.previous = null;
    temp.next = null;
    return temp;
  }

  public Node removeLast() {
    if (tail == null)
      return null;

    Node temp = tail;
    if (head == tail) {
      head = null;
      tail = null;
      return temp;
    }

    tail = tail.previous;
    tail.next = null;
    temp.previous = null;
    return temp;
  }

  public void insert(double number) {
    System.out.printf("Inserting %f\n", number);
    Node newNode = new Node(number);

    if (head == null) {
      head = newNode;
      tail = newNode;
      return;
    }

    if (number < head.data) {
      newNode.next = head;
      head.previous = newNode;
      head = newNode;
      return;
    }

    if (number >= tail.data) {
      newNode.previous = tail;
      tail.next = newNode;
      tail = newNode;
      return;
    }

    Node current = head;
    while (current != null && current.data < number) {
      current = current.next;
    }

    newNode.next = current;
    newNode.previous = current.previous;
    current.previous.next = newNode;
    current.previous = newNode;
  }

  public boolean remove(double number) {
    System.out.printf("Removing %f\n", number);

    if (head == null) {
      return false;
    }

    if (head.data == number) {
      Node removed = removeFirst();
      return removed != null;
    }

    if (tail.data == number) {
      Node removed = removeLast();
      return removed != null;
    }

    Node current = head;
    while (current != null && current.data != number) {
      current = current.next;
    }

    if (current == null) {
      return false;
    }

    current.previous.next = current.next;
    current.next.previous = current.previous;

    current.next = null;
    current.previous = null;

    return true;
  }
}
