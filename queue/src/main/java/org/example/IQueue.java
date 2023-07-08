package org.example;

/**
 * The IQueue interface represents a generic queue data structure.
 * @param <E> the type of elements in the queue
 */
public interface IQueue<E> {
   E poll();
   E remove();
   E element();
   E peek();
   boolean offer(E obj);
   boolean add(E obj);
}
