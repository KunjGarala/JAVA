# 🧵 1. Process vs Thread

## 🔹 Definition

* **Process** → Independent program in execution (has its own memory)
* **Thread** → Smallest unit of execution inside a process (lightweight)

## 🔹 Key Concepts

* One process → **multiple threads**
* Threads share:

  * Heap
  * Method Area (Code + Static data)
* Threads have **independent stacks**
* Main thread is created automatically

## 🔹 Example

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()); // main
    }
}
```

## 🔹 Common Interview Questions

* Difference between process & thread?
* Why threads are lightweight?
* Can threads exist without process? ❌

## 🔹 Edge Cases / Tricky Points

* Context switching cost:

  * Process ❌ High
  * Thread ✅ Low
* Threads share memory → leads to **race conditions**

## 🔹 When to Use / NOT Use

* ✅ Use threads → parallel tasks, async operations
* ❌ Avoid → heavy CPU-bound tasks (use multiprocessing)

## 🔹 Complexity

* Creation cost: Thread < Process

## ⚡ Quick Revision

* Process = independent memory
* Thread = shared memory + lightweight

## 🚨 Common Mistakes

* Thinking threads have separate heap ❌

## 💡 Pro Tip

* Interviewer expects: **memory sharing explanation**

---

# 🧠 2. Java Memory Model (Thread Perspective)

## 🔹 Definition

Defines how memory is structured & shared among threads

## 🔹 Key Components

| Component   | Shared? | Description         |
| ----------- | ------- | ------------------- |
| Heap        | ✅ Yes   | Objects             |
| Method Area | ✅ Yes   | Static + bytecode   |
| Stack       | ❌ No    | Local variables     |
| PC Register | ❌ No    | Current instruction |
| Registers   | ❌ No    | CPU execution       |

## 🔹 Example

```java
int x = 10; // stored in stack
Object obj = new Object(); // stored in heap
```

## 🔹 Common Questions

* Where are objects stored? → Heap
* Are local variables thread-safe? → Yes

## 🔹 Edge Cases

* Static variables → shared → need synchronization

## 🔹 When to Use

* Important for debugging concurrency bugs

## ⚡ Quick Revision

* Heap shared, Stack private

## 🚨 Mistakes

* Confusing stack & heap

## 💡 Pro Tip

* Always mention **thread safety depends on shared data**

---

# ⚙️ 3. Multithreading Basics

## 🔹 Definition

Executing multiple threads concurrently

## 🔹 Key Concepts

* Concurrency ≠ Parallelism
* OS handles scheduling
* Context switching happens

## 🔹 Benefits

* ✅ Responsiveness
* ✅ Better CPU utilization
* ✅ Resource sharing

## 🔹 Challenges

* ❌ Deadlock
* ❌ Race condition
* ❌ Debugging complexity

## 🔹 Example

```java
Thread t = new Thread(() -> System.out.println("Running"));
t.start();
```

## 🔹 Common Questions

* Difference: concurrency vs parallelism?
* Why multithreading is hard?

## 🔹 Edge Cases

* Too many threads → performance drop

## 🔹 When NOT to Use

* Simple sequential tasks

## ⚡ Quick Revision

* Multithreading = concurrency + shared memory

## 🚨 Mistakes

* Assuming threads always improve performance

## 💡 Pro Tip

* Mention **CPU-bound vs IO-bound tasks**

---

# 🏗️ 4. Thread Creation (Java)

## 🔹 Definition

Ways to create threads in Java

## 🔹 Methods

### 1️⃣ Runnable (Preferred ✅)

```java
class MyTask implements Runnable {
    public void run() {
        System.out.println("Task running");
    }
}
new Thread(new MyTask()).start();
```

### 2️⃣ Thread Class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}
new MyThread().start();
```

## 🔹 Key Concepts

* `start()` → creates new thread
* `run()` → normal method call if called directly

## 🔹 Common Questions

* Why Runnable preferred?
  → Multiple inheritance limitation

## 🔹 Edge Cases

```java
t.run(); // ❌ runs in main thread
```

## 🔹 When to Use

* Runnable → best practice
* Thread → quick/simple cases

## ⚡ Quick Revision

* Always use `start()`, not `run()`

## 🚨 Mistakes

* Calling run() directly

## 💡 Pro Tip

* Mention **ExecutorService** for production

---

# 🔄 5. Thread Lifecycle

## 🔹 Definition

States a thread goes through

## 🔹 States

* NEW
* RUNNABLE
* RUNNING (handled by JVM internally)
* BLOCKED / WAITING / TIMED_WAITING
* TERMINATED

## 🔹 Example

```java
Thread t = new Thread(() -> {});
t.start();
```

## 🔹 Common Questions

* Difference: waiting vs blocked?
* Who decides scheduling? → OS

## 🔹 Edge Cases

* No direct control over RUNNING state

## ⚡ Quick Revision

* Most important: NEW → RUNNABLE → BLOCKED → TERMINATED

## 🚨 Mistakes

* Thinking RUNNING is separate API state

## 💡 Pro Tip

* Mention `Thread.State` enum

---

# 🍽️ 6. Producer-Consumer Problem

## 🔹 Definition

Two threads sharing buffer:

* Producer → adds
* Consumer → removes

## 🔹 Key Concepts

* Shared buffer
* Synchronization required
* Avoid:

  * Overflow
  * Underflow

## 🔹 Example (Concept)

```java
synchronized(queue) {
    while(queue.isEmpty()) queue.wait();
    queue.remove();
    queue.notify();
}
```

## 🔹 Common Questions

* How to solve? → wait/notify / BlockingQueue
* Why while loop? → spurious wakeups

## 🔹 Edge Cases

* Using `if` instead of `while` ❌

## 🔹 When to Use

* Message queues, task processing

## 🔹 Complexity

* Depends on implementation

## ⚡ Quick Revision

* Producer waits if full, Consumer waits if empty

## 🚨 Mistakes

* Not handling synchronization

## 💡 Pro Tip

* Mention **BlockingQueue (best solution)**

---

# ⚠️ 7. Deprecated Thread Methods

## 🔹 Definition

Unsafe methods removed from use

## 🔹 Methods

* `stop()` ❌
* `suspend()` ❌
* `resume()` ❌

## 🔹 Why Deprecated?

* Can cause:

  * Deadlock
  * Resource leak
  * Inconsistent state

## 🔹 Alternatives

* Use:

  * Flags
  * interrupt()

## ⚡ Quick Revision

* Never use stop/suspend/resume

## 🚨 Mistakes

* Using stop() in production

## 💡 Pro Tip

* Mention **graceful shutdown using interrupt()**

---

# 🎯 8. Thread Priority

## 🔹 Definition

Hint to scheduler about thread importance

## 🔹 Syntax

```java
t.setPriority(Thread.MAX_PRIORITY);
```

## 🔹 Range

* 1 → MIN
* 5 → NORM
* 10 → MAX

## 🔹 Key Concepts

* Not guaranteed execution order ❗

## 🔹 Common Questions

* Does priority guarantee execution? → ❌

## ⚡ Quick Revision

* Priority = hint, not guarantee

## 🚨 Mistakes

* Relying on priority for logic

## 💡 Pro Tip

* Say: “OS decides scheduling”

---

# 🔐 9. Locks in Java

---

## 🔸 ReentrantLock

### 🔹 Definition

Explicit lock with more control than synchronized

### 🔹 Syntax

```java
lock.lock();
try {
   // critical section
} finally {
   lock.unlock();
}
```

### 🔹 Key Points

* Must unlock in finally ✅
* Supports fairness

### 💡 Pro Tip

* Always mention try-finally

---

## 🔸 ReadWriteLock

### 🔹 Definition

Separate locks for read & write

### 🔹 Key Concepts

* Multiple readers ✅
* Single writer ❌

### 🔹 Use Case

* Read-heavy systems

---

## 🔸 StampedLock

### 🔹 Definition

Advanced lock with optimistic locking

### 🔹 Key Concepts

* `tryOptimisticRead()`
* Validate before use

### 🔹 Edge Case

* Optimistic read may fail → fallback required

---

## 🔸 Semaphore

### 🔹 Definition

Controls number of threads accessing resource

### 🔹 Syntax

```java
semaphore.acquire();
semaphore.release();
```

### 🔹 Use Case

* Connection pools

---

## 🔸 Condition

### 🔹 Definition

Alternative to wait/notify

### 🔹 Methods

* `await()` = wait()
* `signal()` = notify()

---

## ⚡ Quick Revision

* ReentrantLock → flexible
* ReadWriteLock → read-heavy
* StampedLock → optimistic
* Semaphore → permits

## 🚨 Mistakes

* Forgetting unlock ❌
* Using wrong lock type

## 💡 Pro Tip

* Compare with synchronized in interviews

---

# 🔗 10. Thread Join & Daemon Thread

## 🔹 Thread Join

### Definition

Wait for another thread to finish

```java
t.join();
```

### Use Case

* Dependency between threads

---

## 🔹 Daemon Thread

### Definition

Background thread (dies with main thread)

```java
t.setDaemon(true);
```

### Example

* Garbage Collector

---

## ⚡ Quick Revision

* join() = wait
* daemon = background

## 🚨 Mistakes

* Setting daemon after start ❌

---

# 🚀 FINAL INTERVIEW SUMMARY (VERY IMPORTANT)

👉 Threads share **heap**, not stack
👉 Always use **start()**, not run()
👉 Synchronization needed for **shared data**
👉 Prefer:

* Runnable
* ExecutorService
* BlockingQueue

👉 Avoid:

* stop(), suspend(), resume()

👉 Lock choices:

* Simple → synchronized
* Advanced → ReentrantLock
* Read-heavy → ReadWriteLock

