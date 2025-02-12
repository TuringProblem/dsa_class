/**
 * @author { @Override } | 20250211 : @22:24
 * @see <a href="https://github.com/TuringProblem/">GitHub Profile</a>
 **/

public class SelectionSort {
    private static void selectSort(int[] arr, int numbSize) {
        int smallestIndex, temp = 0;
        for (int i = 0; i < numbSize - 1; i++) {
            smallestIndex = i;
            for (int j = i + 1; j < numbSize; j++) {
                if (arr[j] < arr[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            // swapping values
            temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] myUnsortedArray = { 5, 29, 1, 92837, 923, 23, 299, 100, 69, 88, 935, 101, 235 };
        int numbSize = myUnsortedArray.length;
        System.out.printf("Unsorted Array Length: %d\n", numbSize);
        System.out.println("Unsorted Array: ");
        for (int i = 0; i < numbSize; i++) {
            System.out.printf("Index: [%d]\nArray Numb: %d\n", i, myUnsortedArray[i]);
        }
        selectSort(myUnsortedArray, numbSize);
        for (int i = 0; i < numbSize; i++) {
            System.out.printf("Sorted: %d\n", myUnsortedArray[i]);
        }

    }
}
