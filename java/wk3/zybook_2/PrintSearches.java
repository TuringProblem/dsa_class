import java.util.*;

public class PrintSearches<T> {
    public void print(T[] sortedArray, int sortedArraySize, T[] searchKeys, int searchKeysSize, Comparator<T> comparer,
            int[] expectedResults, boolean keyInQuotes) {

        String extra = keyInQuotes ? "\"" : "";

        for (int i = 0; i < searchKeysSize; i++) {
            var searchKey = searchKeys[i];

            Searcher<T> searcher = new Searcher<T>();
            int index = searcher.binarySearch(sortedArray, sortedArraySize, searchKey, comparer);
            int expected = expectedResults[i];

            if (index == expected) {
                System.out.print("PASS: Search for key ");
                System.out.print(extra);
                System.out.print(searchKey);
                System.out.print(extra);
                System.out.print(" returned ");
                System.out.print(expected);
                System.out.print(".");
                System.out.print("\n");
            } else {
                System.out.print("FAIL: Search for key ");
                System.out.print(extra);
                System.out.print(searchKey);
                System.out.print(extra);
                System.out.print(" should have returned ");
                System.out.print(expected);
                System.out.print(", but returned ");
                System.out.print(index);
                System.out.print(".");
                System.out.print("\n");
            }
        }
    }
}
