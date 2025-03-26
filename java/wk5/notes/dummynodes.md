# 4.14 Linked list dummy Nodes

> ## Dummy Nodes
>
> A linked list implementation may use a **_dummy Node_** (or header Node): A Node with an usused data member that always resides at the head of the list and cannot be removed. Using a dummy node simplifies the algorithms for a linked list because the head and tail pointers are never null.
>
> An empty list consists of the dummy Node, which has the next pointer set to null, and the list's head and tail pointers both point to the dummy Node.
>
> ## Singly-linked list implementation
>
> When a singly-linked list with a dummy Node is created, the dummy Node is allocated and the list's head and tail pointers are set to point to the dummy Node.
>
> List operations such as append, prepent, insertafter, and removeafter are simpler to implement to a linked list without a dummy Node, since a special case is removed from each implementation. ListAppend, ListPrepend, and ListInsertAfter do not need to check if the list's head is null, since the list's head will always point to the dummy Node. ListRemoveAfter does not need a special case to allow removal of the first list item, since the first list item is after the Dummy Node.

# 4.15 Linked list: Recursion

> ## Foward traversal
>
> Forward traversal through a linked list can be implemented using a recursive function that takes a Node as an argument. If non-null, the node is visited first. Then, a recursive call is made on the Node's next pointer, to traverse the remainder of the list.
>
> The ListTraverse function takes a list as an argument, and searches the entire list by calling ListTraverseRecursive on the list's head.
>
> ## Searching
>
> A recursive linked list search is implemented similiar to forward traversal. Each call examines **_1_** Node. If the Node is null, then null is returned. Otherwise, the Node's data is compared to the search key. If a match occurs, the Node is returned, otherwise the remainder of the list is searched recursively.

```java
    listSearch(list, key) {
        return listSearchRecursive(key, list.head)
    }

    listSearchRecursive(key, Node) {
        if (Node != null) {
            if (Node.value == key) {
                return Node;
            }
            return listSearchRecursive(key, Node.next);
        }
        return null;
    }
```

> ## Reverse traversal
>
> Forward traversal visits a Node first, then recursively traverses the remainder of the list. If the order is swapped, such that the recursive call is made first, the list is traversed in reverse order.
>
> ```java
> ListTraverseReverse(list) {
>    ListTraverseReverseRecursive(list.head);
> }
> ListTraverseReverseRecursive(Node) {
>    if (Node != null) {
>        ListTraverseReverseRecursive(Node.next);
>        visit(Node);
>    }
> }
> ```

# 4.16 Array-based lists

> ## Array-based lists
>
> An array-based list is a list ADT implemented using an array. An array-based list implmentation will dynamically allocate the array as needed as the number of elements changes. An array-based list supports the common list ADT opertaions, such as prepend, insert after, remove, and search.
>
> In many programming languages, arrays have a fixed size. An array-based list implementation will dynamically allocate the array as needed as the number of elements changes. Initially, the array-based list implementation allocates a fixed size array and uses a length variable to keep track of how many array elements are in use. The list starts with a default allocation size, greater than or equal to 1. A default size of 1 to 10 is common.
>
> Given a new element, the append operation for an array-based list of length X inserts the new element at the end of the list, or at index X.
>
> ## Resize operation
>
> An array-based list must be resized if an item is added when the allocation size equals the list length. A new array is allocated with a length greater than the existing array. Allocating the new array with twice the current length is a common approach. The existing array elements are then copied to the new array, which becomes the list's storage array.
>
> Because all existing elements must be copied from 1 array to another, the resize operation has a runtime complexity of 0(N).

```java
ArrayListAppend(list, newItem) {
    if (list.allocationSize == list.length) {
        ArrayListResize(list, list.length * 2);
        list.array[lsit.length] = newItem;
        list.length = list.length + 1;
    }

    ArrayListResize(list, newSize) {
        newArray = new Array[newAllocationSize];
        for (int i = 0; i < list.length; i++) {
            newArray[i] = list.array[i];
            list.allocationSize = newAllocationSize;
        }
    }
```
