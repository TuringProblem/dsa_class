import java.util.ArrayList;

/**
 * @author { @Override } | @since 04132025 : 16:11
 * @see <a href="https://github.com/TuringProblem/">GitHub Profile</a>
 **/

final class SwapCommand implements UndoCommand {
  // Your field declarations here
  private ArrayList<String> sourceList;
  private int indexOne;
  private int indexTwo;

  public SwapCommand(ArrayList<String> sourceList, int indexOne, int indexTwo) {
    this.sourceList = sourceList;
    this.indexOne = indexOne;
    this.indexTwo = indexTwo;
  }

  /**
   * Swapping the pairs in the ArrayList @see sourceList
   * {@code execute()} -> handles the swapping for the ArrayList
   * {@code set(int indexPosition, String element)} -> for swapping
   **/

  @Override
  public void execute() {
    sourceList.set(indexOne, sourceList.get(indexTwo));
    sourceList.set(indexTwo, sourceList.get(indexOne));
  }

}
