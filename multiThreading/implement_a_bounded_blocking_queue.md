

A bounded blocking queue blocks producers when full and consumers when empty, implemented using synchronized blocks with wait/notifyAll or locks with conditions.

### ✅ Use while, not if
Handles spurious wakeups correctly. Replacing while with if can cause incorrect behavior because threads may wake up without the condition being true (spurious wakeups or wrong-thread notifications).
This can lead to:</br>
Consuming from an empty queue
Producing into a full queue
Data corruption or exceptions
Rare, hard-to-reproduce bugs

### ✅ notifyAll() instead of notify()
Avoids deadlock when:
Multiple producers & consumers exist
Waking the wrong type of thread

### ✅ Intrinsic lock (synchronized)
Ensures mutual exclusion
wait() releases lock atomically

###Why notifyAll() instead of notify()?</br>
notifyAll() is used instead of notify() to avoid deadlocks and missed signals when multiple condition types (producers and consumers) are waiting on the same monitor.

### What notify() actually does
Wakes one arbitrary thread waiting on the monitor
You don’t control which one
That thread may not be able to make progress

notify() can wake the wrong type of thread and cause deadlock when multiple conditions exist. notifyAll() ensures that at least one eligible thread proceeds, making the system correct. notify() is an optimization that’s unsafe without condition separation; notifyAll() is the correctness primitive.

### How would you support timeouts?
A) Using wait(timeout) (synchronized version)
```
public synchronized boolean offer(T item, long timeoutMillis)
        throws InterruptedException {

    long deadline = System.currentTimeMillis() + timeoutMillis;

    while (queue.size() == capacity) {
        long remaining = deadline - System.currentTimeMillis();
        if (remaining <= 0) {
            return false; // timeout
        }
        wait(remaining);
    }

    queue.offer(item);
    notifyAll();
    return true;
}

```
B) Using Condition.awaitNanos() (preferred, precise)
```
public T poll(long timeout, TimeUnit unit)
        throws InterruptedException {

    long nanos = unit.toNanos(timeout);
    lock.lock();
    try {
        while (queue.isEmpty()) {
            if (nanos <= 0) return null;
            nanos = notEmpty.awaitNanos(nanos);
        }
        T item = queue.poll();
        notFull.signal();
        return item;
    } finally {
        lock.unlock();
    }
}

```
## How does this differ from BlockingQueue?
BlockingQueue is a production-ready abstraction that provides correctness, performance optimizations, fairness options, and rich APIs.