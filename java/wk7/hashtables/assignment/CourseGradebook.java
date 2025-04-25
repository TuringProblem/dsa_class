import java.util.*;
import java.util.stream.Collectors;
import java.util.HashSet;

/**
 * @author { @Override } | @since 20250423 22:54
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/
public class CourseGradebook extends Gradebook {
  // Declare any protected fields here (change placeholder field below)
  //

  HashMap<String, HashMap<Integer, Double>> gradebook;

  public CourseGradebook() {
    this.gradebook = new HashMap<>();
  }

  @Override
  public HashMap<Integer, Double> getAssignmentScores(String assignmentName) {
    return new HashMap<>();
  }

  @Override
  public double getScore(String assignmentName, Integer studentID) {
    return gradebook.get(assignmentName).get(studentID);
  }

  @Override
  public ArrayList<String> getSortedAssignmentNames() {
    ArrayList<String> assignmentNames = new ArrayList<>(gradebook.keySet());
    Collections.sort(assignmentNames);
    return assignmentNames;
  }

  @Override
  public ArrayList<Integer> getSortedStudentIDs() {
    HashSet<Integer> uniqueIDs = new HashSet<>();
    for (HashMap<Integer, Double> map : gradebook.values()) {
      uniqueIDs.addAll(map.keySet());
    }
    ArrayList<Integer> studentIds = new ArrayList<>(uniqueIDs);
    Collections.sort(studentIds);
    return studentIds;
  }

  @Override
  public HashMap<String, Double> getStudentScores(Integer studentID) {
    //what do we need to do? 
    //get the score from the hashmash


  }

  @Override
  public void setScore(String assignmentName, Integer studentID, Double score) {
  }

  /**
   * IGNORE THIS THIS IS FOR ME
   * HashMap<Integer, Double> hw2Scores = new HashMap<Integer, Double>() {{
   * put(11111, 89.0);
   * put(22222, 75.0);
   * put(33333, 100.0);
   * put(44444, 50.0);
   * put(55555, 76.5);
   * put(66666, 84.5);
   * put(77777, 76.0);
   * put(88888, 74.5);
   * put(99999, 100.0);
   * put(10000, 90.0);
   * put(90000, 85.0);
   * }};
   * HashMap<Integer, Double> midtermScores = new HashMap<Integer, Double>() {{
   * put(11111, 91.0);
   * put(22222, 77.5);
   * put(33333, 88.0);
   * put(44444, 40.0);
   * put(55555, 64.5);
   * put(66666, 91.0);
   * put(77777, 75.0);
   * put(88888, 88.0);
   * put(99999, 88.0);
   * put(10000, 92.0);
   * put(90000, 90.0);
   * }};
   * HashMap<Integer, Double> projectScores = new HashMap<Integer, Double>() {{
   * put(11111, 100.0);
   * put(22222, 60.0);
   * put(33333, 90.0);
   * put(55555, 87.0);
   * put(66666, 0.0);
   * put(77777, 72.0);
   * put(88888, 85.5);
   * put(99999, 80.0);
   * put(10000, 77.5);
   * put(90000, 85.0);
   * }};
   **/

}
