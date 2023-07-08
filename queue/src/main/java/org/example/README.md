MyQueue

MyQueue is a simple implementation of a generic queue in Java.
It provides basic queue operations such as adding elements, removing elements, and accessing the elements at the head of the queue.

Features:
Generic type: The queue can hold elements of any type.
Dynamic resizing: The underlying array automatically resizes to accommodate more elements when needed.
Exception handling: The queue throws appropriate exceptions when necessary, such as NoSuchElementException and IllegalArgumentException.

Usage:
To use MyQueue in your Java project, follow these steps:

1. Include the MyQueue.java file in your project.
2. Create an instance of MyQueue using the default constructor:
   MyQueue<String> queue = new MyQueue<>();
3. Use the queue's methods to add, remove, or access elements:
   queue.add("element1");
   queue.offer("element2");
   String head = queue.peek();
   String removedElement = queue.remove();

Methods:

* boolean isEmpty(): Checks if the queue is empty.
* boolean add(E obj): Adds an element to the queue.
* boolean offer(E obj): Offers an element to the queue.
* E poll(): Retrieves and removes the head of the queue.
* E remove(): Retrieves and removes the head of the queue.
* E peek(): Retrieves, but does not remove, the head of the queue.
* E element(): Retrieves, but does not remove, the head of the queue.
* int size(): Returns the size of the queue.
* int getSize(): Returns the current size of the queue.

Exceptions:

* NoSuchElementException: Thrown when attempting to retrieve an element from an empty queue or when removing an element from an empty queue.
* IllegalArgumentException: Thrown when adding an element fails due to an invalid argument, such as null.

