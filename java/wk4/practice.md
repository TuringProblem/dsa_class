1. Given list (10, 11, 12, 13, 14, 15), how many comparisons will be made during the **_third_** outer loop execution `(i = 3)`?

# What is Insertion sort?

1. Work left to right.
2. Examine each item and compare it to items on its left.
3. **Insert** the item in the correct position in the array.

The first iteration is i[0] -> There is nothing to the left of it so it is sorted, i[1] (second iteration) -> 11, i[2] -> 12, and i[3] -> 13 (Making four comparisons)

# Quicksort

> **Quicksort\*** is a sorting algorithm that repeatedly partitions the input into low and high parts (each part unsorted), and then recursively sorts each of those parts. To partition the input, quicksort chooses a pivot to divide the data into low and high parts. The \_\*\*pivot\*\*\* can be any value within the array being sorted, commonly the value of the middle array element (similiar way to find the middle in a BST). EX: For the list `{ 4, 34, 10, 25, 1}`, the middle element is located at `index[2]` (the middle of indices `[0, 4]`) and has a value of `10`
>
> Once the pivot is chosen, the quicksort algorithm divides the array into two parts, referred to as the low partition and the high partition. All values in the low partition are less than or equal to the pivot value. All values in the high partition are greater than or equal to the pivot position. The values in each partition are not necessarily sorted. Ex: Partitioning `{ 4, 34, 10, 25, 1}` with a pivot value of 10 results in a low partition of `{ 4, 1, 10}` and a high partition of `{ 25, 34 }`. Values equal to the pivot may appear in either or both of the partitions.

```java
Partition(numbers, lowIndex, highIndex) {
   // Pick middle element as pivot
   midpoint = lowIndex + (highIndex - lowIndex) / 2
   pivot = numbers[midpoint]

   done = false
   while (!done) {
      while (numbers[lowIndex] < pivot) {
         lowIndex += 1
      }
      while (pivot < numbers[highIndex]) {
         highIndex -= 1
      }

      // If zero or one elements remain, then all numbers are
      // partitioned
      if (lowIndex >= highIndex) {
         done = true
      } else {
         // Swap numbers[lowIndex] and numbers[highIndex]
         temp = numbers[lowIndex]
         numbers[lowIndex] = numbers[highIndex]
         numbers[highIndex] = temp

         // Update lowIndex and highIndex
         lowIndex += 1
         highIndex -= 1
      }
   }
   return highIndex
}
```
