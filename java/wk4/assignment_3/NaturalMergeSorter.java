public class NaturalMergeSorter {
    public int getSortedRunLength(int[] array, int arrayLength, int startIndex) {

        if (startIndex >= arrayLength || startIndex < 0) {
            return 0;
        }

        if (startIndex == arrayLength - 1) {
            return 1;
        }

        int runL = 1;
        int currentIndex = startIndex;

        while (currentIndex < arrayLength - 1 && array[currentIndex] <= array[currentIndex + 1]) {
            runL++;
            currentIndex++;
        }

        return runL;
    }

    public void naturalMergeSort(int[] array, int arrayLength) {
        if (array == null || arrayLength <= 1) {
            return;
        }

        // 1: Start at index[i] = 0

        int i = 0;
        while (true) {

            // 2: Get the length of the first sort run, starting at [i]
            int firstL = getSortedRunLength(array, arrayLength, i);

            // - Return if the first runL == arrayLength
            if (firstL == arrayLength) {
                return;
            }

            // - if the first run ends at the array's end -> i = 0; repeat
            if (i + firstL >= arrayLength) {
                i = 0;
                continue;
            }

            // 3: Get the length of the second sorted run, starting immediately after the
            // first
            int secondRunStart = i + firstL;
            int secondL = getSortedRunLength(array, arrayLength, secondRunStart);

            // 4: Merge the two runs with the provided merge() method
            merge(array, i, i + firstL - 1, secondRunStart + secondL - 1);

            // 5: Reassign [i] with the first index after the second run, or 0 if the second
            // run ends at the array's end
            i = secondRunStart + secondL;
            if (i >= arrayLength) {
                i = 0;
            }
            // 6: go to step 2
        }
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
