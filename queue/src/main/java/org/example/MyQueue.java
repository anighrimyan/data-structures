package org.example;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;


/**
 * A simple implementation of a generic queue.
 * @param <E> the type of elements in the queue
 */
public class MyQueue<E> implements IQueue<E> {
    private E[] arr;
    private final int CAPACITY = 10;
    private final int RESIZE = 5;
    private int size;
    private int currentSize;
    private int head = -1;
    private int tail = -1;

    /**
     * Constructs a new instance of MyQueue.
     * Initializes the underlying array with the default capacity.
     */
    public MyQueue() {
        arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), CAPACITY);
    }
    /**
     * Resizes the underlying array.
     * @param arr the array to be resized
     */
    private void resize(E[] arr) {
        int pos = currentSize;
        currentSize += RESIZE;
        E[] newArr = (E[]) Array.newInstance(arr.getClass().getComponentType(), currentSize);
        if (pos >= 0)
            System.arraycopy(arr, 0, newArr, 0, pos);
        arr = newArr;
        size = pos;
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return tail == -1 && head == -1;
    }

    /**
     * Adds an element to the queue.
     * @param obj the element to be added
     * @return true if the element was added successfully, throws an exception otherwise
     * @throws IllegalArgumentException if the element cannot be added
     */
    public boolean add(E obj) {
       if (offer(obj))
           return true;
        throw new IllegalArgumentException();
    }

    /**
     * Offers an element to the queue.
     * @param obj the element to be offered
     * @return true if the element was offered successfully, false otherwise
     * @throws NullPointerException if the element is null
     */
    public boolean offer(E obj) {
        if (isEmpty()) {
            arr[++tail] = obj;
            ++head;
            return true;
        }
        if (obj == null ) {
            throw new NullPointerException("Exception: null elements are not allowed in the queue");
        }
        if (tail == getSize() - 1 && head > 0) {
            tail = 0;
            arr[tail++] = obj;
            return true;
        }
        if (tail == getSize() - 1 && head == 0) {
            resize(arr);
            arr[++tail] = obj;
            return true;
        }
        if (!isEmpty() && tail < getSize()) {
            arr[++tail] = obj;
            return true;
        }
        return false;
    }

    /**
     * Retrieves and removes the head of the queue.
     * @return the head of the queue, or null if the queue is empty
     */
    public E poll() {
        return (isEmpty() && head <= tail) ? null : arr[head++];
    }

    /**
     * Retrieves and removes the head of the queue.
     * @return the head of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E remove() {
       if (isEmpty())
           throw new NoSuchElementException();
       return arr[head++];
    }

    /**
     * Retrieves, but does not remove, the head of the queue.
     * @return the head of the queue, or null if the queue is empty
     */
    public E peek() {
        return isEmpty() ? null : arr[head];
    }

    /**
     * Retrieves, but does not remove, the head of the queue.
     * @return the head of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E element() {
        if (isEmpty())
         throw new NoSuchElementException();
        return arr[head];
    }

    /**
     * Returns the size of the queue.
     * @return the size of the queue
     */
    public int size() {
        return getSize();
    }

    /**
     * Returns the current size of the queue.
     * @return the current size of the queue
     */
    public int getSize() {
        return size;
    }
}
