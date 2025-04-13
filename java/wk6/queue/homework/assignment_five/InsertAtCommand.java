import java.util.ArrayList;

/**
 * @author { @Override } | @since 04132025 : 15:45
 * @see <a href="https://github.com/TuringProblem/">GitHub Profile</a>
 **/

final class InsertAtCommand implements UndoCommand {

  private ArrayList<String> sourceList;
  private String removedItem;
  private int removalIndex;

  public InsertAtCommand(ArrayList<String> sourceList, String removedItem, int removalIndex) {
    this.sourceList = sourceList;
    this.removedItem = removedItem;
    this.removalIndex = removalIndex;
  }

  @Override
  public void execute() {
    sourceList.add(removalIndex, removedItem);
  }
}
