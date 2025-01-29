># 1.1 ***Data Structures***
### ***Data Structures***
> A *Data structure* is a way of organizing, storing, and preforming operations on data. Operations performed on a data structure include accessing or updating stored data, searching for specific data, inserting new data, and removing data. The following provides a list of basic data structures.
-----
<tr>
    <th>Data Structure</th>
    <th>Description</th>
</tr>
<tr>
    <th>Record</th>
    <th>A <a href="">***record***</a> is the data structure that stores subitems, often called fields with a name associated with each subitem.</th>
</tr>
<tr>
    <th>Array</th>
    <th>An <a href="">***array***</a> is a data structure that stores an ordered list of items, where each item is directly accessible by a positional index.</th>
</tr>
<tr>
    <th>Linked List</th>
    <th>A <a href="">***Linked List***</a> is a data structure that stores an ordered list of items in nodes, where each node stores data and has a pointer to the next node.</th>
</tr>
<tr>
    <th>Binary Tree</th>
    <th>A <a href="">***binary tree***</a> is a data structure in which each node stores data and has up to two children, known as a left child and a right child.</th>
</tr>
<tr>
    <th>Hash Table</th>
    <th>A <a href="">***hash table***</a> is a data structure that stores unordered items by mapping (or hashing) each item to a location in an array.</th>
</tr>
<tr>
    <th>Heap</th>
    <th>a <a href="">***max-heap***</a> is a tree that maintains the simple propert that a node's key is greater than or equal to the node's childrens' keys. A <a href="">***min-heap***</a> is a tree that maintains the simple property that a node's key is less than or equal to the node's childrens' keys.</th>
</tr>
<tr>
    <th>Graph</th>
    <th>A <a href="">***graph***</a> is a data structure for representing connections among items, and consists of vertices connected by edges. A <a href="">***vertex***</a> represents an item in a graph. An <a href="">***edge***</a> represents a connection between two vertices in a graph.</th>
</tr>
> ## Choosing data structures
> The selection of data structures used in a program depends on both the type of data being stored and the operations the program may need to preform on that data. Choosing the best data structure often requires determining which data structure provides a good balance given expected uses. Ex: If a program requires fast insertion of new data, a linked list may be a better choice than an array.

># 1.2: ***Introduction to Algorithms***
### ***Algorithms***
> An <a href="">algorithm</a> describes a sequence of steps to solve a computational problem or perform a calculation. An algorithm can be described in English, psuedoCode, a programming language, hardware, etc. A computational problem specific an input, a question about the input that can be answered using a computer, and the desired output.
>
> ## Practical applications of algorithms
> Computational problems can be found in numerous domains, including e-commerce, internet technologies, biology, manufacturing, transportation, etc. Algorithms have been developed for numberous computational problems within these domains.
>
> A computational problem can be solved in many ways, but finding the best algorithm to solve a problem can be challenging. However, many computational problems have common subproblems, for which efficient algorithms have been developed. The examples below describe a computational problem within a specific domain and list a common algorithm (each discussed elsewhere) that can be used to solve the problem.
<tr>
    <th>Application domain</th>
    <th>Computational problem</th>
    <th>Common algorithm</th>
</tr>
<tr>
    <th>DNA analysis</th>
    <th>Given two DNA sequences from different individuals, what is the longest shared sequence of nucleotides?</th>
    <th>*Longest common substring problem:* A longest common substring algorithm determines the longest common substring that exists in two input strings.<br><br>DNA sequences can be represented using strings consisting of the letters A, C, G, and T to represent the four different nucleotides.</th>
</tr>
<tr>
    <th>Search engines</th>
    <th>Given a product ID and a sorted array of all in-stock products, is the product in stock and what is the product's price?</th>
    <th>*Binary searcH:* The binary search algorithm is an efficient algorithm for searching a list. The list's elements must be sorted and directly accessible (such as an array).</th>
</tr>
<tr>
    <th>Navigation</th>
    <th>Given a user's current location and desired location, what is the fastest route to walk to the destination?</th>
    <th>*Dijkstra's shortest path:* Dijkstra's shortest path algorithm determines the shortest path frmo a start vertex to each vertex in a graph.<br><br>The possible routes between two locations can be represented using a graph, where vertices represent specific locations connecting edges specify the time required to walk between those two locations.</th>
</tr>
> ## Efficient algorithms and hard problems
> Computer scientists and programmers typically focus on using and designing efficient algorithms to solve problems. Algorithm efficiency is most commonly measured by the algorithm runtime, and an efficient algorithm is one whose runtime increases no more than polynomially with respect to the input size. However, some problems exist for which an efficient algorithm is unknown.<br>***NP-complete*** problems are a set of problems for which no known efficient algorithm exists. NP-complete problems have the following characteristics:
> - No efficient algorithm has been found to solve an NP-complete problem.
> - No one has proven that an efficient algorithm to solve an NP-complete problem is impossible.
> - If an efficient algorithm exists for one NP-complete problem, then all NP-complete problems can be solved efficiently.
> By knowing a problem is NP-complete, instead of trying to find an efficient algorithm to solve the problem, a programmer can focus on finding an algorithm to efficiently find a good, but non-optimal, solution.


># 1.3 ***Algorithms for Data Structures***[^1]
# ***Appending***
> ## ***Array*** --*(PsuedoCode)*-- O(1)
```java
ArrayAppend(array: type, newItem) {
    currentSize = array.length;
    //increase array size by one
    array[currentSize] = newItem
}
```
> ## ***LinkedList*** --*(PsuedoCode)*-- O(1)
```java
ListAppend(list: type, newNode: type) {
    if (list.head == null){
        list.head = newNode;
        list.tail = newNode;
    } else {
        list.tail.next = newNode;
        list.tail = newNode;
    }
    list.length++;
}
```


----
> Some algorithms utilize data structures to store and organize data during the algorithm execution. 

## Ex:
An algorithm that determines a list of the ***top five salespeople***, may use an array to store salespeople sorted by their total sales.
```java
DisplayTopFiveSalespersons(allSalespersons) {
   // topSales array has 5 elements
   // Array elements have subitems for name and total sales
   // Array will be sorted from highest total sales to lowest total sales
   topSales = Create array with 5 elements; 
   
   // Initialize all array elements with a negative sales total
   for (i = 0; i < topSales⇢length; ++i) {
      topSales[i]⇢name = "";
      topSales[i]⇢salesTotal = -1;
   }

   for each salesPerson in allSalespersons {
      // If salesPerson's total sales is greater than the last
      // topSales element, salesPerson is one of the top five so far
      if (salesPerson⇢salesTotal > topSales[topSales⇢length - 1]⇢salesTotal) {

         // Assign the last element in topSales with the current salesperson
         topSales[topSales⇢length - 1]⇢name =  salesPerson⇢name;
         topSales[topSales⇢length - 1]⇢salesTotal =  salesPerson⇢salesTotal; 

         // Sort topSales in descending order
         SortDescending(topSales);
      }
   }

   // Display the top five salespersons
   for (i = 0; i < topSales⇢length; ++i) {
      Display topSales[i];
   }
}
```
> # 1.4 ***Abstract Data Types***[^2]
## Ex:
A list is a common ADT for holding ordered data, having operations like append a data item, remove a data item, search whether a data item exists, and print the list. A list ADT is commonly implemented using arrays or linked list data structures.

```java
LinkedList<Integer> ageList = new List<>();
//agList.append(agesList, 55);
agList.append(55);
agList.append(88);
agList.append(66);
Print(agesList)
```
<img src="https://files.realpython.com/media/python-append-diagram.57d5bd1285c6.png" style=" width: 50%; border: 4px solid #ffffff; float: left;">
<img src="https://miro.medium.com/v2/resize:fit:1400/1*g1zEksSMrSAm1UFrf3K_Dw.png" style="width: 50%; height: 195px; border: 6px solid #ffffff; margin-right: auto;">

----------------------------
<table style="width: 100%; block: auto; margin-right: auto; margin-left: auto;">
    <tr>
        <th style="font-size: 17px;">Abstract Data Types</th>
        <th style="font-size: 15px; width: 400px;">Description</th>
        <th style="font-size: 17px;">Common underlying data structures</th>
    </tr>
    <tr>
        <th>List</th>
        <th style="font-size: 15px;"><p>A <i><b>List</b></i> is an ADT for holding ordered data.</p></th>
        <th>Array, LinkedList</th>
    </tr>
    <tr>
        <th style="font-size: 15px;">Dynamic Array</th>
        <th style="font-size: 15px;"><p>A <i><b>dynamic array</b></i> is an ADT for holding ordered data and allowing indexed access.</p></th>
        <th>Array</th>
    </tr>
    <tr>
        <th style="font-size: 15px;">Stack</th>
        <th style="font-size: 15px;"><p>A <i><b>stack</b></i> is an ADT in which items are only inserted on or removed from the top of a stack. (LIFO)</p></th>
        <th>LinkedList</th>
    </tr>
    <tr>
        <th style="font-size: 15px;">Queue</th>
        <th style="font-size: 15px;"><p>A <i><b>queue</b></i> is an ADT in which items are inserted at the end of the queue and removed from the front of the queue (FIFO)</p></th>
        <th>LinkedList</th>
    </tr>
    <tr>
        <th style="font-size: 15px;">Deque</th>
        <th style="font-size: 15px;"><p>A <i><b>deque</b></i> (pronounced "deck" and short for double-ended queue) is an ADT in which items can be inserted and removed at both the front and back.</p></th>
        <th>LinkedList</th>
    </tr>
    <tr>
        <th style="font-size: 15px;">Bag</th>
        <th style="font-size: 15px;"><p>A <i><b>Bag</b></i> is an ADT for storing items in which the order does not matter and duplicate items are allowed.</p></th>
        <th style="font-size: 15px;">Array, LinkedList</th>
    </tr>
    <tr>
        <th style="font-size: 15px;">Set</th>
        <th style="font-size: 15px;"><p>A <i><b>Set</b></i> is an ADT for a collection of distinct items.</p></th>
        <th style="font-size: 15px;">Binary Search Tree, Hash Table</th>
    </tr>
    <tr>
        <th style="font-size: 15px;">Priority queue</th>
        <th style="font-size: 13px;"><p>A <i><b>Priority queue</b></i> is a queue where each item has a priority, and items with higher priority are closer to the front of the queue than items with lower priority.</p></th>
        <th style="font-size: 15px;">Heap</th>
    </tr>
    <tr>
        <th style="font-size: 15px;">Dictionary (Map)</th>
        <th style="font-size: 15px;"><p>A <i><b>dictionary</b></i> is an ADT that associates (or maps) keys with values.</p></th>
        <th>HashTable, Binary Search Tree</th>
    </tr>
</table>

---------
> # 1.5 Applications of ADTs

### Abstraction and Optimization

> Abstraction means to have a user interact with an item at a high-level, with lower-level internal details hidden from the user. ADTs support abstraction by hiding the underlying implementation details and providing a well-defined set of operations for usingthe ADT.

> Using abstract data types enables programmers or algorithm designers to focus on higher-level operations and algorithms, thus improving programmer efficieny. However, knowledge of the underlying implementation is needed to analyze or improve runtime efficiency.

---------
### ADTs in Standard Libraries

> Most programming languages provide standard Libraries that implement common abstract data types. Some languages allow programmers to choose the underlying data structure used for the ADTs. Other programming languages may use a specific data structure to implement each ADT, or may automatically choose the underlying data-structure.

<table style="width: 100%; block: auto; margin-right: auto; margin-left: auto;">
    <tr>
        <th><p>Programming Language</p></th>
        <th><p> Library</p></th>
        <th><p>Common supported ADTs</p></th>
    </tr>
    <tr>
        <th><p style="color: #4584B6">Python</p></th>
        <th><p>Python Standard Library</p></th>
        <th><p>list, set, dictionaries, deque</p></th>
    </tr>
    <tr>
        <th><p>C++</p></th>
        <th><p> Standard Template Library(STL)</p></th>
        <th><p>Vector, list, deque, queue, stack, set, map</p></th>
    </tr>
    <tr>
        <th><p style="color: #F89820">Java</p></th>
        <th><p> Java Collections Framework(JCF)</p></th>
        <th><p> Collection, Set, List, Map, Queue, Deque</p></th>
    </tr>
</table>

-------
> # ***1.6 Algorithm efficiency***
### **Algorithm efficiency**
> An algorithm describes the method to solve a computational problem. Programmers and computer scientists should use or write efficient algorithms. ***[Algorithm efficieny](https://en.wikipedia.org/wiki/Algorithmic_efficiency)*** is typically measured by an algorithm's computational complexity. ***[Computational Complexity](https://en.wikipedia.org/wiki/Computational_complexity)*** is the amount of resources used by the algorithm. The most common resources considered are the `runetime` and `memory` usage.

### Runtime complexity, best case, worst case
> An algorithm's ***[runtime complexity](https://en.wikipedia.org/wiki/Time_complexity)*** is a function, `O(N)`, that represents the number of constant time operations is to identify best and worst case scenarios. An algorithm's ***[best case](https://en.wikipedia.org/wiki/Best,_worst_and_average_case)*** is the scenario where the algorithm does the `minimum` possible number of operations. An algorithm's ***[worst case](https://en.wikipedia.org/wiki/Best,_worst_and_average_case)*** is the scenario where the algorithm does the `maximum` possible number of operations. 
> ## Input data size ***must*** remain a variable
>> A best case or worst case describes contents of the algorithm's input data only. The input data size must remain a variable, `O` (*Or whatever you like*). Otherwise, the overwhelming majority of algorithms would have a best case of `N=0`, since no input data would be processed. In both theory and practice, saying "*the best case is when the algorithm doesn't process any data*" is not useful. Complexity analysis always treats the input data size as a variable 

> ## Example
>> `[54][79][26][91][29][33]`
>>
>> ` (0) (1) (2) (3) (4) (5)` 
>> ```java
>>  LinearSearch(numbers, numberSize, key) {
>>      i = 0;
>>      while (i < numberSize) {
>>          if (number[i] == key) {
>>              return i;
>>          }          
>>          i += 1;
>>      }
>>      return -1;
>>  }  
>>```
>> key = 26: `neither best nor worst case`
>>
>> key = 54: `best case`
>>
>> key = 82: `worst case`
## Space Complexity
> An algorithm's ***[space complexity](https://en.wikipedia.org/wiki/Space_complexity)*** is a function, `S(N)`, that represent the number of fixed-size memory units used by the algorithm for an input of size N. Ex: The space complexity of an algorithm that duplicates a list of numbers is `S(N) = 2N + k`, where `k` is a constant representing `memory` used for things like the loop counter and list pointers.
>
>Space complexity includes the input data and additional memory allocated by the alogrithm. An algorithm's ***[auxiliary space complexity](https://www.geeksforgeeks.org/what-is-the-difference-between-auxiliary-space-and-space-complexity/)*** is the space complexity not including the input data. Ex: An algorithm to find the maximum number in a list will have a space complexity of `S(N) = N + k`, but an auxiliary space complexity of `S(N)    = k`, where `k` is constant.

---------
> # 1.7 ***Clone of Introduction to data structures labs***
### Step 1: Producing correct output
> Three commented-out lines of code exist in `main()`. Uncomment the lines and click the `Run program` button. Verify that the program's output is:
> ```java
>// 2+2 = 4;
>// Unknown method: printPlus2;
>// Secret string: "abc";
>```
### Step 2: Inspecting the LabPrinter class
> Inspect the LabPrinter class implemented in the `LabPrinter.java` file. Access `LabPrinter.java` by copying the code below: (after steps)
### Step 3: Implementing `callMethodName()`
> Remove the three uncommented lines from `main()`. Then implement the `callMethodNamed()` method to handle three cases:
>> - If `methodName` is "`print2Plus2`" call printer's `print2Plus2()` method.
>> - If `methodName` is "`printSecret`" call printer's `printSecret()` method.
>> - If `methodName` is anything other than the two strings mentioned above, print "`Unknown method: xyz`", where `xyz` is `methodName's` value.
>
> After implementing `callMethodName()`, click the `Run program` button. Verify that the program's output is, once again: 
> ```java
>// 2+2 = 4;
>// Unknown method: printPlus2;
>// Secret string: "abc";
>```
### Step 4: Submitting code for 10/10 points
> Once `callMethodNamed()` is properly implemented, submitting the code should receive 10 out of 10 points. The program's output is exactly the same as the implementation from step 1. But step 3's implementation uses the LabPrinter object and step 1 does not.


###  here is the Java file:
>    ```
>    public class IntroToDSELabs {
>       public static void callMethodNamed(LabPrinter printer, String methodName) {
>          // Only implement this method after completing step 1
>       }
>       
>       public static void main(String[] args) {
>          LabPrinter printer = new LabPrinter("abc");
>          
>          // Step 1:
>          // Uncomment the block below and submit code for grading. Note that the
>          // submission passes the "Compare output" test, but fails each unit test.
>          /*
>          System.out.println("2 + 2 = 4");
>          System.out.println("Unknown method: printPlus2");
>          System.out.println("Secret string: \"abc\"");
>          */
>           
>          // After completing step 1:
>          // Remove lines of code from step 1 and implement the callMethodNamed() 
>          // method above main().
>          callMethodNamed(printer, "print2Plus2");
>          callMethodNamed(printer, "printPlus2");
>          callMethodNamed(printer, "printSecret");
>       }
>    }
>    ```


[^1]: Data structures not only define how data is organized and stored, but also the operations performed on the data strucute. while common operations include *inserting, removing, and searching* for data, the algorithms to implement those operations are typically specific to each data strucute. Ex: Appending an item to a linked list requires a different algorithm than appending an item to an array.

[^2]: An <a href="https://en.wikipedia.org/wiki/Abstract_data_type" style="color: #2ded97"> Abstract data type(ADT) </a> is a data type described by predefined user operations, such as "insert data at rear", without indicating how each operation is implemented. An ADT can be implemented using different underlying data structures. However, a programmer need not have knowledge of the underlying implementation to use an ADT.
<img src="https://techvidvan.com/tutorials/wp-content/uploads/sites/2/2020/03/various-java-abstract-data-types.jpg" style="border: 5px solid #3ded97; width: 60%; display: block; margin-left: auto; margin-right: auto;">


