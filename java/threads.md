
What is a thread in Java, and how is it different from a process?

> A thread is the smallest unit of execution inside a process.
Multiple threads in the same process share memory and resources, whereas processes are independent and have separate memory spaces.

How can you create a thread in Java? Explain both ways and which one you prefer in real projects.

> Threads can be created by Extending the Thread class, Implementing the Runnable interface.
> Implementing Runnable is preferred because Java supports single inheritance, and it also separates the task from the thread execution, which is better design.

What is the difference between start() and run() in Java threads?</r>
> start() is used to begin a new thread of execution. It asks the JVM to create a new thread and then calls run() internally.
run() contains the thread’s logic, but calling it directly will execute the code in the same thread, not a new one.

What happens if we call start() twice on the same thread object?
> A thread in Java can be started only once. Once a thread finishes execution, it cannot be restarted. The JVM does not allow a thread to move from TERMINATED → RUNNABLE

What are the different states of a thread in Java? Can you name and briefly explain them?
> A Java thread moves from NEW → RUNNABLE → (BLOCKED / WAITING / TIMED_WAITING) → TERMINATED depending on execution and synchronization.

What is synchronization in Java and why do we need it?
```
Synchronization prevents race conditions by allowing only one thread at a time to execute critical code that accesses shared resources.
 Types of Synchronization 
 1) Synchronized Method, 2) Synchronized Block (preferred for performance)

synchronized void increment() {
    count++;
}
Lock is taken on the current object (this). Entire method is locked
Pros
Simple to write
Easy to understand
Cons:
Locks more code than required
Can reduce performance

  synchronized(this) {
    // critical section
}

Lock is taken on a specific object. Only the critical section is locked

Pros
Better performance
More control over locking
Preferred in real projects
Cons
Slightly more code
```



## Resources 
[concurrency in java](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html)
