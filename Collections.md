# 🚀 Java Collections – Final Interview Revision Guide

## 🔥 1. Core Hierarchy (Must Know – Very Common Question)

```
Iterable
   ↓
Collection
   ├── List
   │    ├── ArrayList
   │    ├── LinkedList
   │    └── Vector
   │
   ├── Set
   │    ├── HashSet
   │    ├── LinkedHashSet
   │    └── TreeSet
   │
   └── Queue
        ├── PriorityQueue
        └── Deque (ArrayDeque)

Map (Separate – NOT part of Collection)
   ├── HashMap
   ├── LinkedHashMap
   ├── TreeMap
   └── ConcurrentHashMap
```

👉 **Interview trap**:
**Map is NOT part of Collection interface**

---

# ⚡ 2. ArrayList (Very Important)

## ✔ Internal Working

* Backed by **dynamic array**
* Default size = **10**
* Growth formula:

  ```
  newCapacity = oldCapacity + (oldCapacity >> 1)  // 1.5x
  ```

## ✔ Key Points

* Random access → **O(1)**
* Insert/delete middle → **O(n)** (shifting)

## 🔥 Edge Questions

* Why ArrayList is fast for read but slow for insert?
* What happens when capacity exceeds?
* Difference between `size()` and `capacity`?

---

# ⚡ 3. LinkedList

## ✔ Internal Working

* **Doubly Linked List**
* Each node → `prev | data | next`

## ✔ Key Points

* Insert/delete → **O(1)** (if reference known)
* Access → **O(n)**

## 🔥 Edge Questions

* Why LinkedList implements both `List` and `Deque`?
* When is LinkedList better than ArrayList?

👉 **Answer tip**: Frequent insert/delete

---

# ⚡ 4. HashMap (MOST IMPORTANT 🔥🔥🔥)

## ✔ Internal Structure

```
Array of Node<K,V> (Buckets)
Each bucket:
   → LinkedList (Java 7)
   → LinkedList + Red-Black Tree (Java 8+)
```

## ✔ Flow (Put Operation)

1. Compute hash
2. Find index:

   ```
   index = (n - 1) & hash
   ```
3. If bucket empty → insert
4. If collision:

   * LinkedList → traverse
   * If size > 8 → convert to **Red-Black Tree**

## ✔ Important Constants

* Load Factor = **0.75**
* Resize threshold:

  ```
  capacity * loadFactor
  ```

## ✔ Time Complexity

* Average → **O(1)**
* Worst → **O(log n)** (after treeify)

---

## 🔥 Edge Questions (VERY IMPORTANT)

### ❓ Why load factor = 0.75?

👉 Balance between memory & performance

---

### ❓ What is hash collision?

👉 Two keys map to same index

---

### ❓ Why equals() and hashCode() both needed?

👉

* hashCode → find bucket
* equals → find exact key

---

### ❓ When does treeification happen?

👉 Bucket size > 8 AND capacity ≥ 64

---

### ❓ Why HashMap not thread-safe?

👉 No synchronization → race condition

---

# ⚡ 5. ConcurrentHashMap (VERY IMPORTANT for interviews)

## ✔ Internal Working (Java 8+)

* No full locking
* Uses:

  * **CAS (Compare-And-Swap)**
  * **synchronized at bucket level**

## ✔ Key Concept

* Multiple threads can read/write simultaneously

## 🔥 Edge Questions

* Difference: HashMap vs ConcurrentHashMap?
* Why not use Collections.synchronizedMap?

---

# ⚡ 6. HashSet

## ✔ Internal Working

* Backed by **HashMap**

```
HashSet = HashMap<K, Object>
Value = dummy object (PRESENT)
```

## 🔥 Edge Question

👉 Why only unique elements?
→ Because keys in HashMap are unique

---

# ⚡ 7. TreeMap / TreeSet

## ✔ Internal Working

* Based on **Red-Black Tree**

## ✔ Properties

* Sorted order
* Operations → **O(log n)**

## 🔥 Edge Questions

* Difference: HashMap vs TreeMap?
* What happens if keys not comparable?

---

# ⚡ 8. PriorityQueue

## ✔ Internal Working

* **Min Heap by default**
* Backed by array

## ✔ Complexity

* Insert → O(log n)
* Remove → O(log n)
* Peek → O(1)

## 🔥 Edge Question

👉 Why not sorted fully?
→ Only root is guaranteed smallest

---

# ⚡ 9. Fail-Fast vs Fail-Safe (IMPORTANT)

## ✔ Fail-Fast

* Throws `ConcurrentModificationException`
* Example: ArrayList, HashMap

## ✔ Fail-Safe

* Works on copy
* Example: ConcurrentHashMap

---

# ⚡ 10. Iterator vs ListIterator

| Feature     | Iterator        | ListIterator |
| ----------- | --------------- | ------------ |
| Direction   | Forward         | Both         |
| Add element | ❌               | ✅            |
| Applicable  | All collections | Only List    |

---

# ⚡ 11. Comparable vs Comparator

## ✔ Comparable

```java
class A implements Comparable<A>
```

* Default sorting

## ✔ Comparator

```java
Comparator<A>
```

* Custom sorting

---

# ⚡ 12. Important Internal Concepts (Must Revise)

## ✔ Hashing Formula

```
index = (n - 1) & hash
```

## ✔ Why capacity is power of 2?

👉 Faster calculation using bitwise AND

---

## ✔ Rehashing

* Happens when threshold exceeded
* Doubles capacity

---

## ✔ Red-Black Tree (Basic Idea)

* Balanced BST
* Ensures O(log n)

---

# 🔥 13. Top Interview Rapid-Fire Questions

You MUST be able to answer these quickly:

* Difference: ArrayList vs LinkedList
* HashMap vs ConcurrentHashMap
* HashSet vs TreeSet
* Why Map is not part of Collection?
* What happens internally in `put()`?
* How resizing works?
* Why equals & hashCode contract?
* What is load factor?
* What is fail-fast?

---

# 🧠 14. Real Interview Scenarios

### ❓ How LRU Cache uses collections?

👉 Uses:

* HashMap + Doubly LinkedList

---

### ❓ Why ConcurrentHashMap better than synchronizedMap?

👉 Fine-grained locking vs full lock

---

# ⚡ 15. Last-Minute Revision Strategy (IMPORTANT)

Focus ONLY on:

* HashMap internal (MOST IMPORTANT)
* ArrayList vs LinkedList
* ConcurrentHashMap
* Fail-fast vs fail-safe
* Comparable vs Comparator

---

# 🚀 Final Tip (Very Important)

👉 In interview:

* Don’t just say definition
* Say **"internally how it works"**

Example:
Instead of:
❌ "HashMap stores key-value pairs"

Say:
✅ "HashMap internally uses an array of buckets, where each bucket can be a linked list or red-black tree, and index is calculated using (n-1)&hash"
