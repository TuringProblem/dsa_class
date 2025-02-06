
/**
 * @author { @Override } | 12:10
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 * NOTE -> This was from the ZyBook for DataStructures and Algorithms :) Enjoy (With my twist on it)
 **/
import java.util.ArrayList;

public class Factorial {
    public static int factorial(int n) {
        if (n == 1) {
            System.out.println("We are done here\n");
            return 1;
        } else {
            System.out.printf("%d\n", n);
            return n * factorial(n - 1);
        }
    }

    public static int cumulativeSum(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + cumulativeSum(n - 1);
        }
    }

    public static void reverseList(int[] list, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        } else {
            reverseList(list, startIndex + 1, endIndex - 1);
        }
    }

    public static int fibonacciNumber(int termIndex) {
        if (termIndex == 0) {
            return 0;
        }
        if (termIndex <= 1) {
            return 1;
        } else {
            return fibonacciNumber(termIndex - 1) + fibonacciNumber(termIndex - 2);
        }
    }

    public static void main(String[] args) {
        int[] myList = { 1, 2, 3, 4, 5, 6 };
        // testing factorial
        System.out.println(factorial(6));
        // Testing cumulativeSum
        System.out.println(cumulativeSum(6));
        // Testing reversing myList
        System.out.printf(
                "This is myList before reversing from index[0] (1) -> index[3] (4)\nMylist: [%d][%d][%d][%d]\n",
                myList[0], myList[1], myList[2], myList[3]);
        reverseList(myList, 0, 3);
        System.out.printf(
                "\n\n\nThis is myList after reversing from index[0] (1) -> index[3] (4)\nMylist: [%d][%d][%d][%d]\n\n\n",
                myList[0], myList[1], myList[2], myList[3]);

        ArrayList<Integer> fibNumbs = new ArrayList<>();
        fibNumbs.add(fibonacciNumber(2));
        fibNumbs.add(fibonacciNumber(4));
        fibNumbs.add(fibonacciNumber(8));
        System.out.printf("Here are the values:\nFib2: %d\nFib4: %d\nFib8: %d\n", fibNumbs.get(0), fibNumbs.get(1),
                fibNumbs.get(2));

        // testing out b search ;)

    }

}
