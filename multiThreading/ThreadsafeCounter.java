public class ThreadsExample implements Runnable {
     static AtomicInteger counter = new AtomicInteger(1); // a global counter

     public ThreadsExample() {
     }

     static void incrementCounter() {
          System.out.println(Thread.currentThread().getName() + ": " + counter.getAndIncrement());
     }

     @Override
     public void run() {
          while(counter.get() < 1000){
               incrementCounter();
          }
     }

     public static void main(String[] args) {
          ThreadsExample te = new ThreadsExample();
          Thread thread1 = new Thread(te);
          Thread thread2 = new Thread(te);

          thread1.start();
          thread2.start();          
     }
}
