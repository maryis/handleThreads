The synchronization is mainly used:
- To prevent thread interference.
- To prevent consistency problem.

There are two types of synchronization
- Process Synchronization
- Thread Synchronization

There are two types of thread synchronization: mutual exclusive and inter-thread communication.

- Mutual Exclusive (on critical section)
  - Synchronized method.
        -instance method: only one thread can run the method per instance(aquire the lock of (this))
        -static method: only one thread can run the method (aquire the lock of class)
  - Synchronized block (it needs an object as monitor object)
         - only one thread can run the lines(aquire the lock of the monitor object)
         
- Cooperation (Inter-thread communication in java)
        is a mechanism in which a thread is paused running in its critical section and another thread is allowed to enter (or lock of object)
        in the same critical section to be executed.It is implemented by following methods of Object class:(it tackles the polling problem)
            - wait()   (on monitor object)
            - notify()   (on monitor object)
            - notifyAll()   (on monitor object)

        ****https://www.javatpoint.com/inter-thread-communication-example*****  --> very good resource

Lock in java:
Every object has an lock associated with it. By convention, a thread that needs consistent access to an object's fields has to
acquire the object's lock before accessing them, and then release the lock when it's done with them.

Java is pass by value: (pass-by-value package)
   java copies and passes the reference by value, not the object itself. Thus, method manipulation will alter the objects, since the references point to the original objects.
   But if the references are copies, the original object does not change. So,   if we pass an object to a function, and 
   in function we change the object attributes, we would see our changes outside the function,
   but if in function we assign another object to the passed object and then change it, the original object would not change.
   notice that ALL types other than the primitive types (int, double,boolean, etc) are reference types( even types like Integer, Double, Boolean, and arrays).

ExecutorService:
it automatically provides a pool of threads and API for assigning tasks to it.
we can run runnable or callable threads using this interface:

Callable vs Runnable
For implementing Runnable, the run() method needs to be implemented which does not return anything,
while for a Callable, the call() method needs to be implemented which returns a result on completion. 
Note that a thread can’t be created with a Callable, it can only be created with a Runnable.
Another difference is that the call() method can throw an exception whereas run() cannot.
-------------------this project--------------------
callable package: a callable example
depThreads: having different synchronized ..
indepThreads: using executor pool for n threads
---------------------------------------------------
Future READING:
- thread cooperation
(inter-thread communication to aquire lock for critical section)
- private final Lock lock = new ReentrantLock(true);
- semaphore (n threads)  vs  mutex (1 thread)
- volatile variable (direct access to memory instead of CPU cache
- Thread.yield  --> stop and tell scheduler that if there is someone with higher priority, I can wait (running--> runnable)
- t1.join in thread x  --> thread x waits till t1 end his running


