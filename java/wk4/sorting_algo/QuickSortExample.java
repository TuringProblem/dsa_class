//package java.wk4.sorting_algo; Don't need this bullshit because I'm just testing

import java.util.Random;

public class QuickSortExample {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10000000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(10000);
        }

        System.out.println("Before sorting: ");
        // printArray(numbers);
        quicksort(numbers);
        // will show another way to just user quicksort(numbers) where you just pass
        // int[] numbers

        System.out.println("\nAfter sorting: ");
        // printArray(numbers);

    }

    private static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = array[low + (high - low) / 2];
        // time to partition
        int leftPointer = low;
        int rightPointer = high;

        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, high);
        quicksort(array, low, leftPointer - 1);
        quicksort(array, leftPointer + 1, high);

    }

    private static void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    public static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d ", numbers[i]);
        }
    }

}
