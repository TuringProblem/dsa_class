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
> ## 1.5 Applications of ADTs

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
> ## ***1.6 Algorithm efficiency***
### **Algorithm efficiency**
> An algorithm describes the method to solve a computational problem. Programmers and computer scientists should use or write efficient algorithms. ***[Algorithm efficieny](https://en.wikipedia.org/wiki/Algorithmic_efficiency)*** is typically measured by an algorithm's computational complexity. ***[Computational Complexity](https://en.wikipedia.org/wiki/Computational_complexity)*** is the amount of resources used by the algorithm. The most common resources considered are the `runetime` and `memory` usage.

### Runtime complexity, best case, worst case
> An algorithm's ***[runtime complexity](https://en.wikipedia.org/wiki/Time_complexity)*** is a function, O(N), that represents the number of constant time operations is to identify best and worst case scenarios. An algorithm's ***[best case](https://en.wikipedia.org/wiki/Best,_worst_and_average_case)*** is the scenario where the algorithm does the `minimum` possible number of operations. An algorithm's ***[worst case](https://en.wikipedia.org/wiki/Best,_worst_and_average_case)*** is the scenario where the algorithm does the `maximum` possible number of operations. 


[^1]: Data structures not only define how data is organized and stored, but also the operations performed on the data strucute. while common operations include *inserting, removing, and searching* for data, the algorithms to implement those operations are typically specific to each data strucute. Ex: Appending an item to a linked list requires a different algorithm than appending an item to an array.

[^2]: An <a href="https://en.wikipedia.org/wiki/Abstract_data_type" style="color: #2ded97"> Abstract data type(ADT) </a> is a data type described by predefined user operations, such as "insert data at rear", without indicating how each operation is implemented. An ADT can be implemented using different underlying data structures. However, a programmer need not have knowledge of the underlying implementation to use an ADT.
<img src="https://techvidvan.com/tutorials/wp-content/uploads/sites/2/2020/03/various-java-abstract-data-types.jpg" style="border: 5px solid #3ded97; width: 60%; display: block; margin-left: auto; margin-right: auto;">


