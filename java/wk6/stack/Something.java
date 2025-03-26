import java.util.Comparator;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.HashMap;

/**
 * @author { @Override } | @since 20250323 : 22:44
 **/

public class Something {

  public static HashMap<String, String> OPTIONS = new HashMap<>() {
    {
      put("all your base are belong to us", "orly");
      put("orly", "yarly");
      put("bangin", "donk");
      put("murder", "All rest and no play makes Guthix a dull boy.");
      put("redrum", "All rest and no play makes Guthix a dull boy.");
      put("humperdink", "Have fun storming the castle!");
      put("humperdink", "Have fun storming the castle!");
      put("i am your father", "Nooooooooooooooooooooooooo!");
      put("i'll be back", "Come with me if you want to live");
      put("there is no spoon", "Then you will see, it is not the spoon that bends, it is only yourself.");
      put("milton waddams", "The ratio of people to cake is too big.");
      put("you fight like a dairy farmer", "How appropriate. You fight like a cow.");
      put("finish the fight", "They must love the smell of hero.");
      put("r.i.p. runescape", "Wanna bet?");
      put("penso, logo existo", "Borboletas salpicadas de goiabada...");
      put("le temps passe", "L'\u009cuf dur.");
      put("paul", "Rargh, I'm a lava monster!");
      put("andrew", "Cabbage.");
      put("sevga", "Marmaros had a close encounter with a prayer-eating behemoth.");
    }
  };

  public static void main(String[] args) {

    Function<String, String> ifEqualsKeyThenPrintValue = x -> {
      for (String key : OPTIONS.keySet()) {
        if (key.equals(x)) {
          return OPTIONS.get(key);
        }
      }
      return x;
    };

    System.out.println(ifEqualsKeyThenPrintValue.apply("andrew"));
    System.out.println(ifEqualsKeyThenPrintValue.apply("zaddy"));

  }
}
