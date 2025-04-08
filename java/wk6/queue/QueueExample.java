import java.util.List;
import java.util.LinkedList;

public class QueueExample<T> {
  // FIFO
  private QueueExample<T> myList;
  private int length;

  public QueueExample() {
    length = 0;
  }

  public QueueExample(QueueExample<T> myList) {
    this.myList = myList;
    length = 1;
  }

  // enqueue
  //
  public void enqueue(T value) {
    myList.addLast(value);
    length++;
  }

  // dequeue
  public List<T> dequeue() {
    --length;
    return null;
  }

  public static void main(String[] args) {
    QueueExample<Integer> myQueue = new QueueExample(5);
    // System.out.println(myQueue.getValue());

  }
}
