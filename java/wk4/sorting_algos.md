# TODO: Need to add 3.5 - 3.1 (below this line)

# 3.6 Shell sort

### Shell sort's interleaved lists

> **_Shell sort_** is a sorting algorithm that treats the input as a collection of interleaved lists, and sorts each list individually with a variant of insertion sort algorithm. Shell sort uses gap values to determine the number of interleaved lists. A **_gap value_** is a `ℤ+` representing the distance between elements in an interleaved list. For each interleaved list, if an element is at `index[i]`, the next element is at `index[i  + gapValue]`.
>
> Shell sort begins by choosing a gap value `k` and sorting `k` interleaved lists in place. Shell sort finishes by performing a standard insertion sort on the entire array. Because the interleaved parts have already been sorted, smaller elements will be close to the array's beginning and larger elements toward the end. Insertion sort can then quickly sort the nearly-sorted array.
>
> `ℤ+` gap value can be chosen. In the case the the array (size != size % gapValue -> some interleaved lists will have fewer items than others).

### Insertion sort for interleaved lists

> If a gap value of `k` is chosen, creating `k` entirely new lists would be computationally expensive. Instead of creating new lists, shell sorts **interleaved lists** in-pplace with a variation of the insertion sort algorithm. The insertion sort algorithm variant redefines the concept of "|next" and "previous" items. For an item at `index[x]`, the next item is at `index[x + k]`, instead of `index[x + 1]`, and the previous item is at `index[x - k]` instead of `index[x - 1]`.
>
> ```java
>   InsertionSortInterLeaved(numbers, numberSize, startIndex, gap) {
>       int temp = 0;
>       for (int i = startIndex + gap; i < numberSize; i++) {
>          int j = i;
>           while (j - gap >= startIndex && numbers[j] < numbers[j - gap]) {
>               temp = numbers[j];
>               numbers[j] = numbers[j - gap];
>               numbers[j - gap] = temp;
>               j = j - gap;
>           }
>       }
>   }
> ```
