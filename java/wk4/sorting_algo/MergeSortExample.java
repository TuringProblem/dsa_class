import java.util.Random;
import java.util.Arrays;

public class MergeSortExample {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(20);
        }

        compareArrayBeforeAndAfterMergeSort(numbers);

        // System.out.printf("Before sorting: %s\n", Arrays.toString(numbers));
        // mergeSort(numbers);
        // System.out.printf("\nAfter sorting: %s\n\n\n", Arrays.toString(numbers));

    }

    private static void mergeSort(int[] array) {
        int inputLength = array.length;
        if (inputLength < 2) {
            return;
        }

        int mid = inputLength / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[inputLength - mid];

        // Looping through the "first half" of the array
        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }

        // Looping through the "second half" of the array
        for (int i = mid; i < inputLength; i++) {
            /**
             * The reason for the i - mid is to start from [0] index ( i.e., i = 5 => 5- 5
             * (i - mid) = 0)
             **/
            rightArray[i - mid] = array[i];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(array, leftArray, rightArray);
    }

    private static void merge(int[] inputArray, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        // Now We are going to merge the two arrays => so we need three pointers...
        int i = 0/* left */, j = 0/* right */, k = 0/* mergedArray */;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                inputArray[k] = left[i];
                System.out.printf("k: %d\n", inputArray[k]);
                System.out.printf("Compared: LP[%d] <= RP[%d]: --> TempArray: %s\n\n", left[i], right[j],
                        Arrays.toString(inputArray));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            } else {
                inputArray[k] = right[j];
                System.out.printf("Compared: LP[%d] >= RP[%d]: --> TempArray: %s\n\n", left[i], right[j],
                        Arrays.toString(inputArray));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            inputArray[k] = left[i];
            i++;
            k++;
        }
        ;

        while (j < rightSize) {
            inputArray[k] = right[j];
            j++;
            k++;
        }
    }

    private static void compareArrayBeforeAndAfterMergeSort(int[] array) {
        System.out.printf("Array Before: %s\n", Arrays.toString(array));
        int[] sorted = array.clone();
        mergeSort(sorted);
        System.out.printf("Array Before: %s\nArray After Sorting: %s\n", Arrays.toString(array),
                Arrays.toString(sorted));
    }

}
