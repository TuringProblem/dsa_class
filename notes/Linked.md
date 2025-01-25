># 1.3 ***Algorithms for Data Structures***

Data structures not only define how data is organized and stored, but also the operations performed on the data strucute. while common operations include *inserting, removing, and searching* for data, the algorithms to implement those operations are typically specific to each data strucute. Ex: Appending an item to a linked list requires a different algorithm than appending an item to an array.

> # ***Array*** --*(PsuedoCode)*-- O(1)
```java
ArrayAppend(array: type, newItem) {
    currentSize = array.length;
    //increase array size by one
    array[currentSize] = newItem
}
```
> # ***LinkedList*** --*(PsuedoCode)*-- O(1)
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



