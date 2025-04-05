The synchronization is mainly used to:
- To prevent thread interference
- To prevent consistency problem

There are two types of synchronization
- Process Synchronization
- Thread Synchronization

There are two types of thread synchronization: 
- mutual exclusive
- inter-thread communication.

Mutual Exclusive (on critical section)
  - Synchronized method:
        - instance method: only one thread can run the method per instance(aquire the lock of (this))
        - static method: only one thread can run the method (acquire the lock of class)
  - Synchronized block (it needs an object as monitor object) (Object obj = new Object())
         - only one thread can run the lines(aquire the lock of the monitor object)
         
Cooperation (Inter-thread communication in java)
  - is a mechanism in which a thread is paused running in its critical section and another thread is allowed to enter (or lock of object) in the same critical section to be executed.It is implemented by following methods of Object class:(it tackles the polling problem)
  - wait()   (on monitor object)
  - notify()   (on monitor object)
  - notifyAll()   (on monitor object)


Locks in java:
- Every object has a monitor associated with it. By convention, a thread that needs consistent access to an object's fields has to
acquire the object's lock before accessing them, and then release the lock when it's done with them.


ExecutorService:
- It easily provides a pool of threads and API for assigning tasks to it.
- we can run runnable or callable threads using this interface:

Callable vs Runnable
- For implementing Runnable, the run() method needs to be implemented which does not return anything,
- while for a Callable, the call() method needs to be implemented which returns a result on completion. 
Note that a thread can’t be created with a Callable, it can only be created with a Runnable.
Another difference is that the call() method can throw an exception and returns value whereas run() cannot.

# this project 
- callable package: a callable example
- depThreads: having different synchronized ..
- indepThreads: using executor pool for n threads


Future READING:
- thread cooperation
(inter-thread communication to aquire lock for critical section)
- private final Lock lock = new ReentrantLock(true);
- semaphore (n threads)  vs  mutex (1 thread)
- Atomic variables
- volatile variable (direct access to memory instead of CPU cache)
- Thread.yield  --> stop and tell scheduler that if there is someone with higher priority, I can wait (running--> runnable)
- t1.join in thread x  --> thread x waits till t1 end his running

# number of threads
- if there is no wait for IO or .., the best number of threads:availableProcessors
- in IO bound applications,  availableProcessors + n

to debug multi-thread, 
 - set breakpoints 
 - debug 
 - f9 to go to breakpoint in thread



