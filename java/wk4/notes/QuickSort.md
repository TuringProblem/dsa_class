# Whole algorithm is basically 3 steps:

1. Picking a pivot: Pick a pivot element (You can choose any element as a pivot element).
2. Partitioning: Moving all the elements that are lower than the pivot to the left and all the elements that are greater than the pivot to the right. (Normally the most complex portion to code)

   > We will need to pointers ( a left pointer pointing to the left portion of the array, and the right pointer that points to all of the values higher than the pivot)
   >
   > lp will compare the values that are less than the pivot, if the value is greater than the pivot, that pointer will stop and will continue to check the right pointer -> if the right pointer finds a value that is less than the pivot, than those two values SWAP and then continues. When the left and right pointer point to the same value, they stop and swap with the pivot element.

3. Recursion: Calling Quicksort on the left and the right side of the pivot element.
