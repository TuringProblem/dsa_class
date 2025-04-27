import java.util.*;

/**
 * @author { @Override } | @since 20250423 22:54
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/
public class CourseGradebook extends Gradebook {
  // Declare any protected fields here (change placeholder field below)
  HashMap<String, HashMap<Integer, Double>> gradebook;

  public CourseGradebook() {
    this.gradebook = new HashMap<>();
  }

  @Override
  public HashMap<Integer, Double> getAssignmentScores(String assignmentName) {
    return gradebook.getOrDefault(assignmentName, new HashMap<>());
  }

  @Override
  public double getScore(String assignmentName, Integer studentID) {
    if (!gradebook.containsKey(assignmentName))
      return Double.NaN;

    HashMap<Integer, Double> assignmentScores = gradebook.get(assignmentName);
    if (!assignmentScores.containsKey(studentID))
      return Double.NaN;

    return assignmentScores.get(studentID);
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
    // what do we need to do?
    // get the score from the hashmash
    HashMap<String, Double> result = new HashMap<>();
    for (String assignmentName : gradebook.keySet()) {
      // Again I'm grabbing the assignment and mapping to studentid
      HashMap<Integer, Double> assignmentScores = gradebook.get(assignmentName);
      if (assignmentScores.containsKey(studentID)) {
        result.put(assignmentName, assignmentScores.get(studentID));
      }
    }
    return result;
  }

  @Override
  public void setScore(String assignmentName, Integer studentID, Double score) {
    if (!gradebook.containsKey(assignmentName)) {
      gradebook.put(assignmentName, new HashMap<>());
    }
    gradebook.get(assignmentName).put(studentID, score);
  }
}
