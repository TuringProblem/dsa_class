import java.util.*;
import java.io.PrintWriter;

/**
 * @author { @Override } | @since 0413202e : 15:47
 * @see <a href="https://github.com/TuringProblem/">GitHub Profile</a>
 **/

public class GroceryList {
  protected ArrayList<String> listItems = new ArrayList<String>();
  protected Stack<UndoCommand> undoStack = new Stack<UndoCommand>();

  public void addWithUndo(String newItemName) {
    // Add the new list item
    listItems.add(newItemName);

    // Make an undo command that removes the last item and push onto stack
    undoStack.push(new RemoveLastCommand(listItems));
  }

  public void removeAtWithUndo(int removalIndex) {
    // Your code here
  }

  public void swapWithUndo(int index1, int index2) {
    // Your code here
  }

  // Pop and execute the command at the top of the stack
  public void executeUndo() {
    // pop an UndoCommand off the undoStack
    if (undoStack.isEmpty()) {
      System.out.println("Stack is empty");
      return;
    }
    UndoCommand command = undoStack.pop();
    command.execute();
  }

  final int getListSize() {
    return listItems.size();
  }

  final int getUndoStackSize() {
    return undoStack.size();
  }

  final ArrayList<String> getVectorCopy() {
    return listItems;
  }

  public void print(PrintWriter outputStream) {
    for (int i = 0; i < listItems.size(); i++) {
      outputStream.write(i + ". " + listItems.get(i) + "\n");
    }
  }
}
