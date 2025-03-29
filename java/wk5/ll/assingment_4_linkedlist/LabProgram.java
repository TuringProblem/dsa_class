import java.util.Scanner;
import java.io.PrintWriter;

/**
 * @author { @Override } | @since 20250328 : @22:58
 **/

public class LabProgram {
  // Prints the SortedNumberList's contents, in order from head to tail
  public static void printList(SortedNumberList list) {
    Node node = list.head;
    while (null != node) {
      System.out.print(node.getData() + " ");
      node = node.getNext();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    System.out.println("Hello");
    Scanner scnr = new Scanner(System.in);

    // Read the line of input numbers
    System.out.println("Please enter a list of numbers: ");
    String inputLine = scnr.nextLine();
    System.out.printf("Input line: %s\n", inputLine);

    // Split on space character
    String[] terms = inputLine.split(" ");
    System.out.println("Here we go");

    // Insert each value and show the sorted list's contents after each insertion
    SortedNumberList list = new SortedNumberList();

    for (Object term : terms) {
      double number = Double.parseDouble(term.toString());
      System.out.println("List after inserting " + number + ": ");
      list.insert(number);
      printList(list);
    }

    System.out.println("Please enter the ");
    inputLine = scnr.nextLine();
    terms = inputLine.split(" ");

    for (Object term : terms) {
      double number = Double.parseDouble(term.toString());
      System.out.println("List after removing " + number + ": ");
      list.remove(number);
      printList(list);
    }

  }
}
