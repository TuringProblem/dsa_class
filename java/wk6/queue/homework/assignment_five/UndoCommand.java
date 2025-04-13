
/**
 * @author { @Override } | @since 04132025 : 15:35
 * @see <a href="https://github.com/TuringProblem/">GitHub Profile</a>
 **/

sealed interface UndoCommand permits SwapCommand, RemoveLastCommand, InsertAtCommand {
  public void execute();
}
