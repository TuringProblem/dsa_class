# 5.1 Stack abstract data type (ADT)

> ## Stack abstract data type
>
> A **stack** is an ADT in which items are only are only inserted on or removed from the top of a stack. The stack **push** operation inserts an item on the top of the stack. The stack **pop** operation removes the item at the top of the stack. EX: After the operations "Push 7", "Push 14", "Push 9", and "Push 5", Pop" returns 5. A second "Pop", returns 9. A stack is referred to as a **_Last-in first-out_** ADT. A stack can be implemented using a linked list, an array, or a vector.

# 5.2 Stacks using linked lists

> A stack is often implemented using a linked list, with the list's head node being the stack's top. A push is performed by creating a new list node, assigning the node's data with the item, and prepending the node to the list. A pop is performed by assigning a local variable with the head node's data, removing the head node from the list, and then returning the local variable.

# 5.3 Java: Array-based stack

> ## Array-based stack storage
>
> A stack can be implemented with an array. Two variables are needed in addition to the array:
>
> - allocationSize: an integer for the array's allocated size.
> - length: an integer for the stack's length.
>   The stack's bottom item is at array[0] and the top item is at array[length - 1]. if the stack is empty, then the length is 0.
>
> ## Unbounded Stack
>
> An **_unbounded stack_** is a stack with no upper limit on length. An unbounded stack's length can increase indefinitely, so the stack's array allocation size must also be able to increase indefinitely.

> ## Array-based stack storage

> A stack can be implemented with an array.

> ## Bounded stack
>
> A **_bounded stack_** is a stack with a length that does not exceed a maximum value. The maximum is commonly the initial allocated size. Ex: A bounded stack with `allocationSize = 100` cannot exceed the length of `100` items.
>
> A bounded stack with a length equal to the maximum length is said to be **_full_**.
>
> > ### Quick notes
> >
> > Throwing an exception is one common implementation option. Another option is to return false or some other value indicating failure to push. Neither option is universally regarded as the best, so the choice is left up to the programmer.
> >
> > Array-based stack implementations do _not_ commonly reallocate the array to a smaller size during a pop opertaion. If no reallocation occurs during a pop, then a pop always takes `O(1)` time.
> >
> > Consider two bounded stack implementations:
> >
> > - Implementation A: Allocation size is provided at construction time and is the stack's maximum length.
> > - Implementation B: maximum length is specified at construction time. Default allocation size is 1.
> >
> > `Which implementation(s) guarentee that both push and pop execute in worst-case O(1) time?` - Implementation A never resizes the array during a push operation, so each push is worst-case O(1). Implementation B may need to resize during a push, which takes O(n)time. Pop is worst-case O(1) for both implementations.
>
> ## Java array-based stack implementation
>
> The `ArrayStack` class below can be used as an unbounded or bounded stack. If the parameter passed to the constructor is negative, the stack is unbounded. If the parameter is nonnegative, the stack is bounded.
>
> ```java
>   class ArrayStack {
>       private int allocationSize;
>       private int[] array;
>       int length;
>       int maxLength;
>       public ArrayStack() {this(-1); //call the one-parameter constructor}
>
>       Public ArrayStack(int maxLength) {
>           allocationSize = 1;
>           array = new int[allocationSize];
>           length = 0;
>           this.maxLength = maxLength;
>       }
>
>       public int getLength() { return length; }
>       public int getMaxLength() { return maxLength; }
>
>       public boolean push(int item) {
>           if (length == maxLength) return false;
>           if (length == allocationSize) resize();
>           array[length] = item;
>           length++;
>           return true;
>       }
>
>       public int pop() { return array[--length]; }
>
>       public void resize() {
>
>           int newSize = allocationSize * 2;
>           int[] newArray = new int[newSize];
>           for (int i = 0; i < length; i++) {
>               newArray[i] = array[i];
>           }
>           array = newArray;
>           allocationSize = newSize;
>       }
>   }
> ```
