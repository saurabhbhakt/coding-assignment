# Collections in Java

**Collections** are a set of classes and interfaces that allow you to store and manipulate groups of objects. The Java Collections Framework provides several interfaces and classes for working with data in a collection-like manner. Below are some commonly used collection types, along with examples:

---

## 1. **List**
- **Definition**: An ordered collection (also known as a sequence). Lists can contain duplicate elements.
- **Common Implementations**: `ArrayList`, `LinkedList`, `Vector`, `Stack`.

| Feature                          | **ArrayList**                          | **LinkedList**                        | **Vector**                              | **Stack**                              |
|----------------------------------|----------------------------------------|--------------------------------------|----------------------------------------|----------------------------------------|
| **Underlying Data Structure**    | Dynamic Array                          | Doubly Linked List                   | Dynamic Array                           | Extends `Vector` (Dynamic Array)       |
| **Order of Elements**            | Insertion order                        | Insertion order                      | Insertion order                        | LIFO order (Last In First Out)         |
| **Performance (Access)**         | O(1)                                   | O(n)                                 | O(1)                                   | O(1)                                   |
| **Performance (Insert/Remove)**  | O(1) at the end, O(n) in the middle    | O(1) at the ends, O(n) in the middle | O(1) at the end, O(n) in the middle    | O(1) (push/pop)                        |
| **Thread Safety**                | Not synchronized                       | Not synchronized                     | Synchronized (Thread-safe)              | Synchronized (Thread-safe)             |
| **Use Case**                     | Fast random access, occasional inserts/removals | Efficient inserts/removals at both ends | Thread-safety (legacy use case)        | Implements LIFO behavior (e.g., undo stack, DFS) |

**Use Case Summary**:
- **ArrayList**: Use when you need fast random access to elements using their index, and the collection will be accessed frequently. Ideal for scenarios where the number of elements is known ahead of time or changes infrequently.
- **LinkedList**: Best for scenarios where you need to perform frequent insertions and deletions, especially at the beginning or middle of the list. It’s especially useful for queues and deques or when frequent reordering or dynamic insertion/removal is needed.
- **Vector**: Primarily used when thread safety is important. However, in modern Java applications, `Vector` is rarely used, and alternatives like `ArrayList` with external synchronization or `CopyOnWriteArrayList` are preferred. Suitable for legacy applications where synchronization is required but comes with performance overhead.
- **Stack**: A subclass of `Vector`, `Stack` is useful when you need a LIFO (Last In, First Out) data structure. It's commonly used in algorithms like Depth-First Search (DFS), managing undo/redo operations, or simulating call stacks in recursive algorithms.

---

## 2. **Set**
- **Definition**: A collection that does not allow duplicate elements. Sets are unordered.
- **Common Implementations**: `HashSet`, `LinkedHashSet`, `TreeSet`.

| Feature                        | **HashSet**                         | **LinkedHashSet**                    | **TreeSet**                           |
|--------------------------------|-------------------------------------|--------------------------------------|---------------------------------------|
| **Order**                      | No specific order                   | Insertion order is preserved         | Elements are stored in sorted order  |
| **Underlying Data Structure**  | Hash table (hashing)                | Hash table + linked list             | Red-Black tree (binary search tree)  |
| **Performance**                | O(1) for basic operations (avg)     | O(1) for basic operations (avg)      | O(log n) for basic operations        |
| **Duplicates**                 | No duplicates                       | No duplicates                        | No duplicates                         |
| **Thread Safety**              | Not synchronized                    | Not synchronized                     | Not synchronized                      |
| **Use Case**                   | When order doesn’t matter           | When order of insertion is important | When you need sorted order           |

**Use Case Summary**:
- **HashSet**: Use when you frequently check if an element is part of a collection and don’t care about the order of elements. Great for fast lookups, insertions, and deletions.
- **LinkedHashSet**: Use when you need to preserve the order of insertion while avoiding duplicates.
- **TreeSet**: Use when you need to maintain elements in a sorted order or need to perform range queries, like finding the greatest or least element or subsetting ranges of elements.

---

## 3. **Queue**
- **Definition**: A collection used for holding elements prior to processing. Typically, queues follow the FIFO (First In First Out) order.
- **Common Implementations**: `LinkedList`, `PriorityQueue`, `ArrayDeque`.

| Feature                          | **LinkedList**                        | **PriorityQueue**                   | **ArrayDeque**                       |
|----------------------------------|--------------------------------------|-------------------------------------|--------------------------------------|
| **Underlying Data Structure**    | Doubly Linked List                   | Binary heap (or similar structure)  | Resizable array                     |
| **Order of Elements**            | Insertion order (no sorting)         | Elements ordered based on priority  | Insertion order (no sorting)        |
| **Performance (Insert/Remove)**  | O(1) at the ends, O(n) in the middle | O(log n) for insertion and removal  | O(1) for insertions/removals at both ends |
| **Thread Safety**                | Not synchronized                     | Not synchronized                    | Not synchronized                    |
| **Null Elements**                | Allows `null` elements               | Does not allow `null` elements      | Allows `null` elements              |
| **Use Case**                     | Efficient insertion/removal at both ends, list-like behavior | When you need elements to be processed by priority | Efficient queue/stack operations with a dynamic array |

**Use Case Summary**:
- **LinkedList**: Use when you need efficient insertion and removal at both ends of a collection, and when order matters.
- **PriorityQueue**: Use when elements need to be processed based on priority rather than insertion order.
- **ArrayDeque**: Use when you need a fast, dynamic queue or stack with efficient operations at both ends and don’t need to maintain any specific order other than insertion order.

---

## 4. **Map**
- **Definition**: A collection of key-value pairs. Maps do not allow duplicate keys, but values can be duplicated.
- **Common Implementations**: `HashMap`, `TreeMap`, `LinkedHashMap`, `Hashtable`.

| Feature                          | **HashMap**                        | **TreeMap**                          | **LinkedHashMap**                    | **Hashtable**                        |
|----------------------------------|------------------------------------|--------------------------------------|--------------------------------------|--------------------------------------|
| **Underlying Data Structure**    | Hash table (hashing)               | Red-Black tree (balanced BST)        | Hash table + Linked list             | Hash table (hashing)                |
| **Order of Elements**            | No specific order (unordered)     | Sorted order (according to natural ordering or comparator) | Insertion order is preserved         | No specific order (unordered)       |
| **Null Keys/Values**             | One `null` key, multiple `null` values | No `null` key or `null` values       | One `null` key, multiple `null` values | No `null` key or `null` values      |
| **Thread Safety**                | Not synchronized                   | Not synchronized                     | Not synchronized                     | Synchronized (thread-safe)           |
| **Performance**                  | O(1) for basic operations (avg)    | O(log n) for basic operations        | O(1) for basic operations (avg)      | O(1) for basic operations (avg)      |
| **Use Case**                     | When you don’t need any order and need fast access | When you need elements in sorted order | When you need insertion order to be preserved | Legacy use case when thread safety is required |

**Use Case Summary**:
- **HashMap**: Use when you need fast lookups and don’t care about the order of elements. Great for general-purpose usage where high performance is important and order isn’t a concern.
- **TreeMap**: Ideal when you need a map that maintains keys in a sorted order. It’s perfect for scenarios like range queries or when you need to traverse the map in order.
- **LinkedHashMap**: A hybrid between `HashMap` and `TreeMap`. It’s used when you need insertion order to be preserved while benefiting from the performance characteristics of a `HashMap`. Common in caching systems like implementing LRU caches.
- **Hashtable**: An older, thread-safe map implementation that synchronizes all its methods. It’s now considered outdated in favor of `HashMap` or `ConcurrentHashMap`, but is used in legacy code where thread safety is required.

---


## 5. **Iterator**
- **Definition**: An interface that provides methods for iterating over collections. It is used to loop through elements in a collection.

---

## 6. **Comparing Collections**
- **Definition**: Java Collections also provide powerful sorting and searching functionality, especially through the use of Comparator and Comparable.


| **Feature**               | **Comparable**                            | **Comparator**                             |
|---------------------------|------------------------------------------|--------------------------------------------|
| **Where it's implemented** | In the class itself                      | External to the class                      |
| **Method**                 | `compareTo(T o)`                         | `compare(T o1, T o2)`                      |
| **Usage**                  | One default natural ordering per class   | Multiple ways to compare (can define many) |
| **Flexibility**            | Less flexible, only one way to compare   | More flexible, allows multiple comparison strategies |
| **Modification of Class**  | Requires modifying the class being compared | Does not require modifying the class being compared |
| **Example**                | Sorting by a single property like age    | Sorting by multiple properties like name, age |

---

**Use Case Summary**:
- **Comparable**: Use when you want to define the natural ordering of a class and you are certain that there will only be one way to compare objects (e.g., sorting a list of `Person` objects by age).
- **Comparator**: Use when you need to provide different ways of sorting (e.g., sorting by name, age, or other properties) or if you don’t want to modify the class being compared (e.g., sorting a class from a third-party library).

---