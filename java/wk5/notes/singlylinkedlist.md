# 4.2

### Singly6-linked list data structure

> A **_singly-linked list_** is a data structure for implementing a list ADT(abstract data type), where each [node](<https://en.wikipedia.org/wiki/Node_(computer_science)>) has data (or sometimes referred to as a value) and a pointer to the **next** node. The list structure typically has pointers to the list's first node and last node.

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
ListNode dummyNode = new ListNode(0);
int carry = 0;
while (l1 != null || l2 != null) {
int x = (l1 != null) ? l1.val : 0;
int y = (l2 != null) ? l2.val : 0;
int sum = carry + x + y;
carry = sum / 10;
dummyNode.next = new ListNode(sum % 10);
dummyNode = dummyNode.next;
if (l1 != null) l1 = l1.next;
if (l2 != null) l2 = l2.next;
}
if (carry > 0) {
dummyNode.next = new ListNode(carry);
}
return dummyNode.next;

}

}
