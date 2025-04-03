import java.util.List;
import java.util.stream.Collectors;
import java.util.LinkedList;

/**
 * @author { @Override } | @since 20250402 : @2010
 **/

public class StackExample<T> {
  // Push - add's a value to the stack
  // LIFO - Last in First out

  private List<T> values = new LinkedList<>();
  int length;

  public StackExample() {
    length = 0;
  }

  public StackExample(List<T> values, int length) {
    this.values = values;
    this.length = length;
  }

  // Pop - Takes a value off the stack
  public void push(T value) {
    values.addFirst(value);
    length++;

  }

  public void pop() {
    if (length <= 1) {
      return;
    }
    values.removeFirst();
    length--;

  }

  public void peek() {
    values.getFirst();
  }

  public int getLength() {
    return length;
  }

  @Override
  public String toString() {
    return values.stream().map(Object::toString).collect(Collectors.joining(", "));
  }

  public static void main(String[] args) {
    StackExample<Integer> myStack = new StackExample<>();

    myStack.push(55);
    myStack.peek();
    myStack.push(69);
    System.out.println("Hi, I'm working");
    System.out.printf("%s\nLength: %d\n\r", myStack.toString(), myStack.getLength());
    myStack.pop();

    System.out.printf("%s, length: %d\n\n", myStack.toString(), myStack.getLength());
  }
}
