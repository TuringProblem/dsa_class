import java.util.*;
import java.io.PrintWriter;

/**
 * @author { @Override } | @since 04132025 : 15:47
 * @see <a href="https://github.com/TuringProblem/">GitHub Profile</a>
 **/

public class GroceryList {
  protected ArrayList<String> listItems = new ArrayList<String>();
  protected Stack<UndoCommand> undoStack = new Stack<UndoCommand>();

  public void addWithUndo(String newItemName) {
    listItems.add(newItemName);
    // Make an undo command that removes the last item and push onto stack
    undoStack.push(new RemoveLastCommand(listItems));
  }

  public void removeAtWithUndo(int removalIndex) {
    if (removalIndex < 0 || removalIndex >= listItems.size()) {
      System.out.println("Invalid index for the List");
      return;
    }
    String removedItem = listItems.get(removalIndex);
    undoStack.push(new InsertAtCommand(listItems, removedItem, removalIndex));
  }

  public void swapWithUndo(int indexOne, int indexTwo) {
    if (indexOne < 0 || indexOne >= listItems.size() || indexTwo < 0 || indexTwo <= listItems.size()) {
      System.out.println("Invalid indices for swap");
      return;
    }

    String temp = listItems.get(indexOne);
    listItems.set(indexOne, listItems.get(indexTwo));
    listItems.set(indexTwo, temp);
    undoStack.push(new SwapCommand(listItems, indexOne, indexTwo));
  }

  public void executeUndo() {
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
