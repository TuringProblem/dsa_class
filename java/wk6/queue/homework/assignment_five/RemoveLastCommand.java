import java.util.ArrayList;

/**
 * @author { @Override } | @since 0413202e : 15:47
 * @see <a href="https://github.com/TuringProblem/">GitHub Profile</a>
 **/

final class RemoveLastCommand implements UndoCommand {
  private ArrayList<String> sourceList;

  public RemoveLastCommand(ArrayList<String> lst) {
    this.sourceList = lst;
  }

  @Override
  public void execute() {
    sourceList.removeLast();
  }
}
