public class NaturalMergeSorter {
    public int getSortedRunLength(int[] array, int arrayLength,
            int startIndex) {

        // if startIndex is out of bounds we need to return 0;
        return 0;

        // Returns the number of array elements sorted in ascending order, starting at
        // startIndex -> ending either at the end of the sort run, or the end of the
        // array, whichever comes first.

        // Your code here

    }

    public void naturalMergeSort(int[] array, int arrayLength) {
        // Your code here
    }

    public void merge(int[] numbers, int leftFirst, int leftLast,
            int rightLast) {
        int mergedSize = rightLast - leftFirst + 1;
        int[] mergedNumbers = new int[mergedSize];
        int mergePos = 0;
        int leftPos = leftFirst;
        int rightPos = leftLast + 1;

        // Add smallest element from left or right partition to merged numbers
        while (leftPos <= leftLast && rightPos <= rightLast) {
            if (numbers[leftPos] <= numbers[rightPos]) {
                mergedNumbers[mergePos] = numbers[leftPos];
                leftPos++;
            } else {
                mergedNumbers[mergePos] = numbers[rightPos];
                rightPos++;
            }
            mergePos++;
        }

        // If left partition isn't empty, add remaining elements to mergedNumbers
        while (leftPos <= leftLast) {
            mergedNumbers[mergePos] = numbers[leftPos];
            leftPos++;
            mergePos++;
        }

        // If right partition isn't empty, add remaining elements to mergedNumbers
        while (rightPos <= rightLast) {
            mergedNumbers[mergePos] = numbers[rightPos];
            rightPos++;
            mergePos++;
        }

        // Copy merged numbers back to numbers
        for (mergePos = 0; mergePos < mergedSize; mergePos++) {
            numbers[leftFirst + mergePos] = mergedNumbers[mergePos];
        }

        // Free temporary array
        mergedNumbers = null;
    }
}
