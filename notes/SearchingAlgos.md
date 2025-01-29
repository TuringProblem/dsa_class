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
>
> A contact is searched for Bob.
> Assume the following contact list: ( Amy, Bob, Chris, Holly, Ray, Sarah, Zoe )
> 1) What is the first contact search? 
> ***Answer:*** `Holly`
>
> 2) What is the second contact search? 
> ***Answer:*** `Bob`
### Binary search algorithm
> ***Binary search*** is a faster algorithm for searching a list if the list's elements are sorted and directly accessible (such as an array). Binary search first checks the middle element of the list. If the search key is found, the algorithm returns the matching location. If the search key is not found, the algorithm repeats the search on the reamining left sublist (if the search key was ***less*** than the middle element) or the remaining right sublist (if the search key was ***greater*** than the middle element).
> ## Figure 2.2.1: Binary search algorithm.
> ```java
>   BinarySearch(numbers, numbersSize, key) {
>       mid = 0;
>       low = 0;
>       high = numbersSize - 1;
>       while (high >= low) {
>           mid = (high + lwo) - 1;
>           if (numbers[mid] < key) {
>               low = mid + 1;
>           } else if (numbersSize[mid] > key) {
>               high = mid - 1;
>           } else { return mid; }
>       }
>       return -1;
>   }
>   main() {
>       numbers = {2, 4, 7, 10, 11, 32, 45, 87};
>       NUMBER_SIZE = 8;
>       key = 0;
>       keyIndex = 0;
>       for (int i = 0; i < NUMBER_SIZE; i++) {
>           printf("${numbersSize[i]");
>       } 
>       Scanner scan = new Scanner(System.in);
>       print("Enter a value: ")
>       key = scan.getInt();
>       keyIndex = BinarySearch(numbers, NUMBER_SIZE, key);
>       if (keyIndex == -1) {
>           printf("${key} was not found");
>       } else {
>           printf("Found ${key} at index ${keyIndex}.");
>       }
>   }
>
>```
### Binary seach efficiency
> Binary search is incredibly efficient in finding an element within a sorted array. During each iteration or step of the algorithm, binary search reduces the search space (i.e., the remaining elements to search within) by about half. The search terminates when the element is found or the search space is empty (with an output indicating that the element was not found). For an `N` element array, the ***maximum*** number of steps required to reduce the search space to an empty subarray is `[ log_2(N) + 1]`Ex: `[log_2(32)] + 1 = 6`
>
> If each comparison takes 1 µs (1 microsecond), a binary search algorithm's runtime is at most 20 µs to search a list with 1,000,000 elements, 21 µs to search 2,000,000 elements, 22 µs to search 4,000,000 elements, and so on. Ex: Searching Amazon's online store, which has more than 200 million items, requires less than 28 µs; up to 7,000,000 times faster than linear search. 


> # 2.3 Java: Linear and Binary Search
### Linear search
> Search algorithms are used to find the location (index) of some key element in an array, or otherwise indicate that the key is not the array. <a href="">***Linear search***</a> is a search algorithm that starts from the beginning of an array, and checks each element until the search key is found or the end of the array is reached. The `linearSearch()` method shown below compares each item in a given array, one at a time.
>
> The figure below shows the linear search code. If the key value is found, the index is returned. If the value is not found, -1 is returned.
