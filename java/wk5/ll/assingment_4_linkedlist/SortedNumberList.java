
public class SortedNumberList {
  public Node head;
  public Node tail;

  public SortedNumberList() {
    head = null;
    tail = null;
  }

  // Optional: Add any desired private methods here

  // Inserts the number into the list in the correct position such that the
  // list remains sorted in ascending order.
  public void insert(double number) {
    Node newNode = new Node(number);
    System.out.printf("Inserting %.2f", number);
    if (head == null) {
      head = newNode;
      tail = newNode;
      System.out.println("Head is null");
    }
    if (head.data > number) {
      newNode.next = head;
      head = newNode;
      System.out.println("Head is not null and added the value");
    } else {
      tail.next = newNode;
      tail = newNode;
      System.out.println("Head is not null and added the value");
    }
  }

  // Removes the node with the specified number value from the list. Returns
  // true if the node is found and removed, false otherwise.
  public boolean remove(double number) {
    if (head == null) {
      return false;
    }

    if (head.data == number) {
      head = head.next;
      return true;
    }

    Node current = head;
    while (current.next != null) {
      if (current.next.data == number) {
        current.next = current.next.next;
        return true;
      }
    }
    return false;
  }
}
