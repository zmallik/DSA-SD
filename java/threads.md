
What is a thread in Java, and how is it different from a process?

> A thread is the smallest unit of execution inside a process.
Multiple threads in the same process share memory and resources, whereas processes are independent and have separate memory spaces.

How can you create a thread in Java? Explain both ways and which one you prefer in real projects.

> Threads can be created by Extending the Thread class, Implementing the Runnable interface.
> Implementing Runnable is preferred because Java supports single inheritance, and it also separates the task from the thread execution, which is better design.


## Resources 
[concurrency in java](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html)
