import java.util.Scanner;

/**
 * @author { @Override } | 20250211 : @22:24
 * @see <a href="https://github.com/TuringProblem/">GitHub Profile</a>
 **/

public class BSearchExample {
    public static int bSearch(int[] array, int maxLength, int value) {
        int l = 0;
        int h = maxLength - 1;
        while (h >= l) {
            int m = (h + l) / 2;
            if (array[m] < value) {
                l = m + 1;
            } else if (array[m] > value) {
                h = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] myValues = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 };
        int maxLength = 40;
        System.out.println("Numbers: \n");
        for (int i = 0; i < maxLength; i++) {
            System.out.printf("Number: %d", myValues[i]);
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a value: ");
        int userValue = scan.nextInt();
        int keyIndex = bSearch(myValues, maxLength, userValue);
        if (userValue == -1) {
            System.out.println("Please Try another value\n");
        } else {
            System.out.printf("Found the value {%d}\nAt index: %d\n", userValue, keyIndex);
        }
        System.out.println("Would you like to see this in a linear search?");
        String response = scan.next();
        if (response.equalsIgnoreCase("y")) {
            keyIndex = linearSearch(myValues, userValue);
            System.out.printf("index %d\n", keyIndex);
        }
    }
}
