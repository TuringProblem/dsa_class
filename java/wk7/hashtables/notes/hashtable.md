# 6.1 Hash Tables

> A **_Hash table_** is a data structure that stores unordered items by mapping (or hashing) each item to a location in an array (or vector) Ex: Given an array with indices[0...9] to store integer from 0...500, the module (remainder) operator can be used to map 25 to index 5 (25 % 10 = 5), and 149 to index 9 (149 % 10 = 9). A hash table's main advantage is that searching (or inserting / removing) an item may require only O(1), in contrast to O(N) for searching a list or to O(log(n)) for binary search.
>
> In a hash table, an item's **_key_** is the value used to map to an index. For all items that might possibly be stored in the hash table, every key is ideally unique, so that the hash table's algorithms can search for a specific item by that key.
>
> Each hash table array element is called a **_bucket_**. A **_hash function_** computes a bucket index from the item's key.
>
> ## Hash table operations
>
> A common hash function uses the **_modulo operator %_**, which computes the integer remainder when dividing two numbers. Ex: For a 20 element hash table, a hash function of key % 20 will map keys to bucket indices 0 ... 19.
>
> A hash table's operations of insert, remove, and search each use the hash function to determine an item's bucket. Ex: Inserting 113 first determines the bucket to be 113 % 10 = 3.
>
> ## Collisions
>
> A **_collision_** occurs when an item being inserted into a hash table maps to the same bucket as an existing item in the hash table. Ex: For a hash function of key % 10, 55 would be insertved in bucket `55 % 10 = 5;` later inserting 75 would yield a collision because 75 % 10 is also 5. Various techniques are used to handle collisions during insertions, such as chaining or open addressing. **_Chaining_** is a collision resolution technique where each bucket has a list of items (so bucket 5's list would become 55, 75). **_Open addressing_** is a collision resolution technique where collisions are resolved by looking for any empty bucket elsewhere in the table (so 75 might be stored in bucket 6). Such techniques are discussed later in this material.

# 6.2 Chaining

> **_Chaining_** handles hash table collisions by using a list for each bucket, where each list may store multiple items that map to the same bucket. The insert operation first uses the item's key to determine the bucket, and then inserts the item in that bucket's list. Searching also first determines the bucket, and then searches the bucket's list. Likewise for removes.
>
> > ```psuedo
> >  HashInsert(hashTable, item) {
> >      if (HashSearch(hashTable, item->key) == null) {
> >          bucketList = hashTable[Hash(item->key)]
> >          node = Allocate new linkedlist node
> >          node->next = null
> >          node->value = item
> >          ListAppend(bucketList, node)
> >      }
> >  }
> >
> >  HashRemove(hashTable, item) {
> >      bucketList = hashTable[Hash(item->key)]
> >      itemNode = ListSearch(bucketList, item->key)
> >      if (itemNode is not null) {
> >          ListRemove(bucketList, itemNode)
> >      }
> >  }
> >
> >  HashSearch(hashTable, key) {
> >      bucketList = hashTable[Hash(key)]
> >      itemNode = ListSearch(bucketList, key)
> >      if (itemNode is not null) {
> >          return itemNode->value
> >      } else {
> >          return null
> >      }
> >  }
> > ```
> >
> > 1.  A hash table with chaining uses a list for each bucket. The insert operation first uses the item's key to determine the mapped bucket, and then inserts the item in that bucket's list.
> > 2.  A bucket may store multiple items with different keys that map to the same bucket. If collisions occur, items are inserted in the bucket's list.
> > 3.  Search first uses the item's key to determine the mapped bucket, and then searches the items in that bucket's list.
