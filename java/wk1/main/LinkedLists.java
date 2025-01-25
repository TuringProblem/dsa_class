import java.util.LinkedList;

/**
 * @author { @Override } | 1/25/2025 : 16:16
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/
public class LinkedLists<T> {
    public Node<T>
    {
    public T value
    public Node<T> next;

    public Node(T value) {
            this.value = value;
            this.next = null;
        }}

    // LinkedList has both a h -> head & t -> tail
    private Node<T> h;
    private Node<T> t;
    private int length;

    public LinkedLists(T h, T t, int length) {
        this.h = null;
        this.t = null;
        this.length = length;
    }

    public void append(T value) {
        // create new Node
        Node<T> newNode = new N<>(value);
        if (h == null) {
            h = newNode;
            t = newNode;
        } else {
            t.next = newNode;
            t = newNode;
        }
        length++;
    }

}
