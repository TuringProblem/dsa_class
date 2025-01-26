> # 2.1 Searching and algorithms
### Algorithms
> An ***[algorithm]()*** is a sequence of steps for accomplishing a task. ***[Linear search]()*** is a search algorithm that starts from the beginning of a list, and checks each element until the search key is found or the end of the list is reached.

> ### Figure 2.1.1: Linear search algorithm
>> ```
>> LinearSearch(numbers, numbersSize, key) {
>>       i = 0
>>
>>       for (i = 0; i < numbersSize; ++i) {
>>          if (numbers[i] == key) {
>>             return i
>>          }
>>       }
>>          
>>       return -1 // not found
>>    }
>>       
>>    main() {
>>       numbers = {2, 4, 7, 10, 11, 32, 45, 87}
>>       NUMBERS_SIZE = 8
>>       i = 0
>>       key = 0
>>       keyIndex = 0
>>          
>>       print("NUMBERS: ")
>>       for (i = 0; i < NUMBERS_SIZE; ++i) {
>>          print(numbers[i] + " ")
>>       }
>>       printLine()
>>          
>>       print("Enter a value: ")
>>       key = getIntFromUser()
>>          
>>       keyIndex = LinearSearch(numbers, NUMBERS_SIZE, key)
>>          
>>       if (keyIndex == -1) {
>>          printLine(key + " was not found.")
>>       } 
>>       else {
>>          printLine("Found " + key + " at index " + keyIndex + ".")
>>       }
>>    }
>>```
### Algorithm runtime
> An algorithm's ***runtime*** is the time the algorithm takes to execute. If each comparison takes 1 µs (1 microsecond), a linear search algorithm's runtime is up to 1s to search a list with 1,000,000 elements, 10 for 10,000,000, and so on. Ex: Searching Amazon's online store, which has more than 200 million items, could require more than 3 minutes.
>
>An algorithm typically uses a number of steps proportional to the size of the input. For a list with 32 elements, linear search requires at most 32 comparisons: 1 comparison if the search key is found at index 0, 2 if found at index 1, and so o, up to 32 comparisons if the search key is not found. For a list with `N` elements, linear search thus requires at most `N` comparisons. The algorithm is said to require "on the order" of `N` comparisons.
> # 2.2 Binary Search
### Linear search vs. Binary search
> Linear search may require searching all list elements, which can lead to long runtimes. For example, searching for a contact on a smartphone one-by-one from first to last can be time consuming. Because a contact list is sorted, a faster search, known as a binary search, checks the `middle contact first`. If the desired contact comes alphabetically before the middle contact, binary search will then search the first half and otherwise the last half. Each step reduces the contacts that need to be searched by half.



