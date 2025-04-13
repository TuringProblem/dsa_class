# 5.4 Queue abstract data type (ADT)

> ### Queue abstract data type
>
> A **_queue_** is an ADT in which items are inserted at the end of the queue and removed from the front of the queue. The queue **_enqueue_** operation inserts an item at the end of the queue. The queue **_dequeue_** operation removes and returns the item in at the front of the queue. Ex: After the operations "Enqueue 7", "Enqueue 14", and "Enqueue 9", "Dequeue" returns 7. A second "Dequeue" returns 14. A queue is referred to as **_First-in first out_**(FIFO) ADT. A queue can be implemented using a LinkedList or Array.
>
> A queue ADT is similar to waiting in line at the grocery store. A person enters at the end of the line and exits at the front. British English actually uses the word "queue" in everyday vernacular where American English uses the word "line".

# 5.5 Queues using linked lists

> A queue is often implemented using a linked list, with the list's head node representing the queue's front, and the list's tail node representing the queue's end. Enqueueing an item is performed by creating a new list node, assigning the node's value with the item, and appending the node to the list. Dequeueing performed by assigning a local variable with the head node's value, removing the head node from the list, and returning the local variable.

# 5.6 Java: Array-based queues

> ## Array-based queue storage
>
> A queue can bve implemented with an array. **Two** variables are needed in addition to the array:
>
> - length: an integer for the queue's lenght.
> - frontIndex: an integer for the queue's front item index.
>   The queue's content starts at `array[frontIndex]` and continues forward through length items. If the array's end is reached before encountering all items, remaining items are stored starting at index 0.
>
> ## **_Bounded vs. unbounded queue_**
>
> A **_bounded queue_** is a queue with a length that does not exceed a specified maximum value. An additional variable, `maxLength`, is needed. `maxLength` is commonly assigned at construction time and does not change for the queue's lifetime. A bounded queue with a length equal to the maximum length is said to be **_full_**.
>
> An **_unbounded queue_** is a queue with a length that can grow indefinitely.

# 5.7 Java: Stacks and queues using linked list

> A stack can be implemented in Java using a class with a single LinkedList data member. The stack class has two methods, push() and pop(). push() adds a node to the top of the stack's list by calling LinkedList prepend(). pop() removes the head of the stack's list by calling the LinkedList removeAfter() method and then returns the removed node's value. The getHeadData() method is added to the LinkedList class so that the stack class's pop() can get the head node's value before removing the node.
