import java.util.*;

public class Searcher<T> {
    // Returns the index of the key in the sorted array, or -1 if the
    // key is not found.
    public static <T> int binarySearch(T[] array, int arraySize, T key,
            Comparator<T> comparer) {

        int left = 0;
        int right = arraySize - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Compare current element with key using the comparer
            int comparison = comparer.compare(array[mid], key);

            // If element is found at mid, return its index
            if (comparison == 0) {
                return mid;
            }

            // If element is greater than key, search left half
            if (comparison > 0) {
                right = mid - 1;
            }
            // If element is less than key, search right half
            else {
                left = mid + 1;
            }
        }

        // Element not found
        return -1;
    }
}
