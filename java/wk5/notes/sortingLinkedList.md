# 4.13 Java: Sorting linked list

> ## Java insertion sort for **_doubly-linked list_**
>
> The `insertionSortDoublyLinked()` method in the LinkedList class implements insertion sort for a doubly-linked list. Nodes are moved backward by first removing the node using the remove() method, then reinserting the using either the `prepend()` method (if the node becomes the head) or the `insertAfter()` method
>
> > ```java
> > public void insertionSortDoublyLinked() {
> >   Node currentNode = m_head.next;
> >   while (currentNode != null) {
> >      Node nextNode = currentNode.next;
> >      Node searchNode = currentNode.previous;
> >
> >      while (searchNode != null && searchNode.data > currentNode.data)
> >         searchNode = searchNode.previous;
> >
> >      // Remove and re-insert currentNode
> >      remove(currentNode);
> >      if (searchNode == null) {
> >         currentNode.previous = null;
> >         prepend(currentNode);
> >      }
> >      else {
> >         insertAfter(searchNode, currentNode);
> >      }
> >
> >     // Advance to next node
> >     currentNode = nextNode;
> >   }
> > }
> > ```
>
> > ```java
> > public class SortDoublyLinked {
> >   public static void main(String[] args) {
> >      int[] numbers = { 72, 91, 53, 12, 48, 19, 7, 1, 86 };
> >
> >      // Initialize a new LinkedList
> >      LinkedList numList = new LinkedList();
> >
> >      // Create and append nodes with the numbers
> >      for (int number : numbers) {
> >          Node node = new Node(number);
> >          numList.append(node);
> >      }
> >
> >      // Output list
> >      System.out.print("List after adding nodes: ");
> >      numList.printList();
> >
> >      // Sort the list
> >      numList.insertionSortDoublyLinked();
> >
> >      // Output list
> >      System.out.print("List after insertion sort: ");
> >      numList.printList();
> >   }
> > }
> > ```
> >
> > Question review:
>
> 1. Which combination of LinkedList methods can move a doubly-linked node backware?
>
> [] `removeAfter()` and `append()`
>
> [] `remove()` and `prepend()` ---@answer
>
> 2. What prevents singly-linked lists from using the doubly-linked list insertion sort algorithm?
>
> [] Lacking a previous data member. ---@answer
>
> [] Having a next data member
>
> ## Java insertion sort for singly-linked list
>
> Insertion sort can be changed to work for a singly-linked list by traversing forward from the start of the list to find a node's insertion point. The Node is then moved backward by first removing the node, then using the `prepend()` or `insertAfter()` method to insert the node at the insertion point.
>
> Methods `insertionSortSinglyLinked()` and `findInsertionPosition()` are added to the LinkedList class. The `insertionSortSignlyLinked()` method calls the `findInsertionPosition()` method to find where the current Node should be inserted.
>
> > ```java
> > public void insertionSortSinglyLinked() {
> >   Node beforeCurrent = m_head;
> >   Node currentNode = m_head.next;
> >   while (currentNode != null) {
> >      Node nextNode = currentNode.next;
> >      Node position = findInsertionPosition(currentNode.data);
> >      if (position == beforeCurrent)
> >         beforeCurrent = currentNode;
> >      else {
> >         removeAfter(beforeCurrent);
> >         if (position == null)
> >            prepend(currentNode);
> >         else
> >            insertAfter(position, currentNode);
> >      }
> >      currentNode = nextNode;
> >   }
> > }
> >
> > public Node findInsertionPosition(int dataValue) {
> >   Node positionA = null;
> >   Node positionB = m_head;
> >   while (positionB != null && dataValue > positionB.data) {
> >      positionA = positionB;
> >      positionB = positionB.next;
> >   }
> >   return positionA;
> > }
> > ```

---

# Singly Insertion method:

```java
class Node {
   public int data;
   public Node next;

   public Node(int initialData) {
      data = initialData;
      next = null;
   }
}

class LinkedList {
   private Node m_head;
   private Node m_tail;

   public LinkedList() {
      m_head = null;
      m_tail = null;
   }

   public void append(Node newNode) {
      if (m_head == null) {
         m_head = newNode;
         m_tail = newNode;
      }
      else {
         m_tail.next = newNode;
         m_tail = newNode;
      }
   }

   public void prepend(Node newNode) {
      if (m_head == null) {
         m_head = newNode;
         m_tail = newNode;
      }
      else {
         newNode.next = m_head;
         m_head = newNode;
      }
   }

   public void printList() {
      Node node = m_head;
      while (node != null) {
         System.out.print(node.data + " ");
         node = node.next;
      }
      System.out.println();
   }

   public void insertAfter(Node currentNode, Node newNode) {
      if (m_head == null) {
         m_head = newNode;
         m_tail = newNode;
      }
      else if (currentNode == m_tail) {
         m_tail.next = newNode;
         m_tail = newNode;
      }
      else {
         newNode.next = currentNode.next;
         currentNode.next = newNode;
      }
   }

   public void removeAfter(Node currentNode) {
      if (currentNode == null && m_head != null) {
         // Special case: remove head
         Node succeedingNode = m_head.next;
         m_head = succeedingNode;
         if (succeedingNode == null) {
             // Last item was removed
             m_tail = null;
         }
      }
      else if (currentNode.next != null) {
         Node succeedingNode = currentNode.next.next;
         currentNode.next = succeedingNode;
         if (succeedingNode == null) {
            // Remove tail
            m_tail = currentNode;
         }
      }
   }

   public void insertionSortSinglyLinked() {
      Node beforeCurrent = m_head;
      Node currentNode = m_head.next;
      while (currentNode != null) {
         Node nextNode = currentNode.next;
         Node position = findInsertionPosition(currentNode.data);
         if (position == beforeCurrent)
            beforeCurrent = currentNode;
         else {
            removeAfter(beforeCurrent);
            if (position == null)
               prepend(currentNode);
            else
               insertAfter(position, currentNode);
         }
         currentNode = nextNode;
      }
   }

   public Node findInsertionPosition(int dataValue) {
      Node positionA = null;
      Node positionB = m_head;
      while (positionB != null && dataValue > positionB.data) {
         positionA = positionB;
         positionB = positionB.next;
      }
      return positionA;
   }
}
```

### Example

```java
public class SortSinglyLinked {
   public static void main(String[] args) {
      int[] numbers = { 72, 91, 53, 12, 48, 19, 7, 1, 86 };

      // Initialize a new LinkedList
      LinkedList numList = new LinkedList();

      // Create and append nodes with the numbers
      for (int number : numbers) {
          Node node = new Node(number);
          numList.append(node);
      }

      // Output list
      System.out.print("List after adding nodes: ");
      numList.printList();

      // Sort the list
      numList.insertionSortSinglyLinked();

      // Output list
      System.out.print("List after insertion sort: ");
      numList.printList();
   }
}
```

# Doubly-linked

```java
class Node {
   public int data;
   public Node next;
   public Node previous;

   public Node(int initialData) {
      data = initialData;
      next = null;
      previous = null;
   }
}

// Doubly-linked list
class LinkedList {
   private Node m_head;
   private Node m_tail;

   public LinkedList() {
      m_head = null;
      m_tail = null;
   }

   public void append(Node newNode) {
      if (m_head == null) {
         m_head = newNode;
         m_tail = newNode;
      }
      else {
         m_tail.next = newNode;
         newNode.previous = m_tail;
         m_tail = newNode;
      }
   }

   public void prepend(Node newNode) {
      if (m_head == null) {
         m_head = newNode;
         m_tail = newNode;
      }
      else {
         newNode.next = m_head;
         m_head.previous = newNode;
         m_head = newNode;
      }
   }

   public void printList() {
      Node node = m_head;
      while (node != null) {
         System.out.print(node.data + " ");
         node = node.next;
      }
      System.out.println();
   }

   public void insertAfter(Node currentNode, Node newNode) {
      if (m_head == null) {
         m_head = newNode;
         m_tail = newNode;
      }
      else if (currentNode == m_tail) {
         m_tail.next = newNode;
         newNode.previous = m_tail;
         m_tail = newNode;
      }
      else {
         Node successor = currentNode.next;
         newNode.next = successor;
         newNode.previous = currentNode;
         currentNode.next = newNode;
         successor.previous = newNode;
      }
   }

   public void remove(Node currentNode) {
      Node successor = currentNode.next;
      Node predecessor = currentNode.previous;

      if (successor != null)
         successor.previous = predecessor;

      if (predecessor != null)
         predecessor.next = successor;

      if (currentNode == m_head)
         m_head = successor;

      if (currentNode == m_tail)
         m_tail = predecessor;
   }

   public void insertionSortDoublyLinked() {
      Node currentNode = m_head.next;
      while (currentNode != null) {
         Node nextNode = currentNode.next;
         Node searchNode = currentNode.previous;

         while (searchNode != null && searchNode.data > currentNode.data)
            searchNode = searchNode.previous;

         // Remove and re-insert currentNode
         remove(currentNode);
         if (searchNode == null) {
            currentNode.previous = null;
            prepend(currentNode);
         }
         else
            insertAfter(searchNode, currentNode);

         // Advance to next node
         currentNode = nextNode;
      }
   }
}
```

### Example

```java
public class SortDoublyLinked {
   public static void main(String[] args) {
      int[] numbers = { 72, 91, 53, 12, 48, 19, 7, 1, 86 };

      // Initialize a new LinkedList
      LinkedList numList = new LinkedList();

      // Create and append nodes with the numbers
      for (int number : numbers) {
          Node node = new Node(number);
          numList.append(node);
      }

      // Output list
      System.out.print("List after adding nodes: ");
      numList.printList();

      // Sort the list
      numList.insertionSortDoublyLinked();

      // Output list
      System.out.print("List after insertion sort: ");
      numList.printList();
   }
}
```
