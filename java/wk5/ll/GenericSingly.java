public class GenericSingly<T> {

  static GenericSingly<Integer> testList = new GenericSingly<>();

  class Node<T> {
    public T value;
    public Node<T> next;

    public Node(T value) {
      this.value = value;
      this.next = null;
    }
  }

  private Node<T> head;
  private Node<T> tail;

  public void append(T value) {
    Node<T> newNode = new Node<>(value);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
  }

  public void prepend(T value) {
    Node<T> newNode = new Node<>(value);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
  }

  public void insertAfter(T targetValue, T newValue) {
    Node<T> temp = head;
    while (temp.next != null) {
      if (temp.value.equals(targetValue)) {
        Node<T> newNode = new Node<>(newValue);
        newNode.next = temp.next;
        temp.next = newNode;
        if (temp == tail) {
          tail = newNode;
        }
        return;
      }
      temp = temp.next;
    }
  }

  public String printList(GenericSingly<T> link) {
    if (head == null) {
      System.out.println("There is no value in this list");
    }
    StringBuilder sb = new StringBuilder();
    Node<T> temp = head;
    sb.append("[");
    while (temp != null) {
      if (temp.next == null) {
        sb.append(temp.value);
        break;
      }
      sb.append(temp.value).append(", ");
      temp = temp.next;
    }
    sb.append("]\n");
    return sb.toString();
  }

  public static GenericSingly<Integer> testCase() {
    testList.append(55);
    testList.append(77);
    testList.prepend(91);
    testList.prepend(88);
    System.out.printf("The list before adding node: %s", testList.printList(testList));
    testList.insertAfter(91, 69);
    System.out.printf("The list after adding node: %s", testList.printList(testList));

    return testList;
  }

  public static void main(String[] args) {
    System.out.println(testList.printList(testCase()));
  }
}
