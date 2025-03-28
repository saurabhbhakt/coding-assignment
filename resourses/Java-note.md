### JVM is the runtime environment that runs Java bytecode. It has key components like 
 * ClassLoader
   * Loads .class files into JVM memory dynamically when required.
   * Uses different types of class loaders (Bootstrap, Extension, and Application class loaders).
 * Runtime Memory: JVM memory areas include 
   * Heap, 
     * Managed by Garbage Collector. Divided into 
       * Young Generation (Eden, Survivor spaces) and 
       * Old Generation (Tenured space)
   * Stack, 
     * Stores local variables and method call details. 
     * Each thread has its own stack. 
     * Stores primitive data types, object references, and method execution state. 
     * Uses LIFO (Last-In-First-Out).
   * Metaspace, 
     * Stores class metadata and method definitions. 
     * Replaced PermGen in Java 8 (dynamic size). 
     * Uses native memory instead of Heap.
   * PC Register and 
     * Holds the memory address of the next instruction to be executed in the thread.
     * Each thread has its own PC Register.
   * Native Method Stack.
     * Used for native (C, C++) method execution via JNI (Java Native Interface).
     * Stores native method call details.
 * Execution Engine
   * Responsible for executing Java bytecode. Uses 
   * Interpreter (line-by-line execution) and 
   * JIT Compiler (optimized native code generation).
     * improves performance by converting frequently executed bytecode into native machine code at runtime.
     * Types of JIT Compilation:
       * Client JIT (C1) – Optimized for fast startup. 
       * Server JIT (C2) – Optimized for peak performance. 
       * Tiered Compilation – Combines both C1 and C2 for better efficiency.
 * GC.
   * Automatically removes unused objects from Heap memory to free up space.
   * Divided Heap memory into
       * Young Generation (Eden, Survivor spaces) and
       * Old Generation (Tenured space)
   * System.gc() and Runtime.gc() are the methods which requests for Garbage collection to JVM explicitly but it doesn’t ensures garbage collection as the final decision of garbage collection is of JVM only.

### JDK vs JRE vs JVM:
* JVM executes bytecode.
* JRE provides runtime with JVM and libraries. 
* JDK provides JRE + development tools.


### Java Garbage Collectors

| **Garbage Collector** | **Description** | **Best Use Case** |
|----------------------|----------------|-------------------|
| **Serial GC** | Uses a single thread to perform GC, stopping all application threads during collection (Stop-the-World pauses). | Best for single-threaded applications or small heaps (up to ~100 MB). |
| **Parallel GC** | Uses multiple threads for GC, improving throughput but with longer pauses. It was the default GC before Java 9. | Suitable for multi-core CPUs and applications that prioritize high throughput over low latency. |
| **CMS (Concurrent Mark-Sweep) GC** | Runs some GC phases concurrently with application threads, reducing pause times but increasing CPU overhead. Deprecated in Java 9 and removed in Java 14. | Used in low-latency applications where response time is more important than raw throughput. |
| **G1 (Garbage First) GC** | Divides the heap into regions and prioritizes GC on the most garbage-filled regions first, reducing Full GC pauses. Default GC from Java 9 onwards. | Balances performance and latency, ideal for large heaps (4 GB to 100+ GB). |
| **ZGC (Z Garbage Collector)** | Designed for ultra-low pause times (<10 ms), performs most GC work concurrently, and scales efficiently to multi-terabyte heaps. Introduced in Java 11. | Best for applications requiring large heaps (multi-GB to TB) and minimal pause times. |
| **Shenandoah GC** | Performs concurrent compaction to minimize pause times and improve responsiveness. Available since Java 12. | Suitable for low-latency, real-time applications that require predictable performance. |


### Best Practices for Java Performance and Memory Management
1. Memory Leak Debugging
   * Use jmap, jconsole, and jstat for real-time memory monitoring. 
   * Perform heap dump analysis using tools like Eclipse MAT or VisualVM. 
   * Leverage -XX:+HeapDumpOnOutOfMemoryError to capture dumps automatically. 
   * Track unclosed resources (e.g., Streams, Connections) and improper static references.

2. JVM Tuning
   * Set optimal heap size (-Xms, -Xmx) based on application needs. 
   * Enable GC logging (-Xlog:gc* in Java 9+ or -XX:+PrintGCDetails in Java 8). 
   * Choose the right Garbage Collector (GC):
     * G1GC for balanced performance. 
     * ZGC for ultra-low latency. 
     * Shenandoah for low-pause times. 
   * Optimize GC algorithms based on workload.
3. Handling Large Objects
   * Use off-heap memory (e.g., ByteBuffer.allocateDirect()). 
   * Leverage SoftReferences and WeakReferences for cache-like behavior. 
   * Use Streaming APIs for large file processing instead of loading everything in memory.

4. GC Performance Optimization
   * Reduce unnecessary object allocations and prefer primitive types where possible. 
   * Optimize GC by using object pooling and avoiding frequent short-lived objects. 
   * Enable Escape Analysis to allow stack allocation of short-lived objects. 
   * Tune Young/Old Gen ratio to match the application's memory allocation pattern.

5. Thread Safety & Memory Management
   * Use volatile for visibility of shared variables across threads. 
   * Prefer synchronized blocks over methods for finer-grained locking. 
   * Utilize ThreadLocal for thread-scoped data. 
   * Use concurrent collections (ConcurrentHashMap, CopyOnWriteArrayList) instead of synchronized collections. 
   * Avoid deadlocks by ordering locks consistently.


### [Multithreading](../upSkills/src/org/quarks/learn/thread/multithreading.md)
