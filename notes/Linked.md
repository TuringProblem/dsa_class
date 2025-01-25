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
A list 
```

```


[^1]: Data structures not only define how data is organized and stored, but also the operations performed on the data strucute. while common operations include *inserting, removing, and searching* for data, the algorithms to implement those operations are typically specific to each data strucute. Ex: Appending an item to a linked list requires a different algorithm than appending an item to an array.

[^2]: An <a href="https://en.wikipedia.org/wiki/Abstract_data_type" style="color: #2ded97"> Abstract data type(ADT) </a> is a data type described by predefined user operations, such as "insert dta at rear", without indicating how each operation is implemented. An ADT can be implemented using different underlying data structures. However, a programmer need not have knowledge of the underlying implementation to use an ADT.

