package exercise22_2;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedListStack<E> extends Stack<E> {
    private Node<E> first;
    private int currentSize;
    private Lock stackLock;
    private Condition sizeCondition;

    public LinkedListStack() {
        this.first = null;
        this.currentSize = 0;
        this.stackLock = new ReentrantLock();
        this.sizeCondition = stackLock.newCondition();
    }
    class Node<T>{
        public T data;
        public Node<T> next;
    }

    public E push(E element) {
        stackLock.lock();
        try {
            System.out.println("[Pushing...]");
            Node<E> newNode = new Node<>();
            newNode.data =  element;
            newNode.next = this.first;
            this.first = newNode;
            this.currentSize++;
            System.out.println("[Size: " + this.currentSize + "]");
            this.sizeCondition.signalAll();
        }finally {
            stackLock.unlock();
        }

        return element;
    }
    public E pop() {
        E result;
        stackLock.lock();
        try {
            System.out.println("[Popping...]");
            while (first == null) {
                System.out.print("[Waiting...][Size: " + this.currentSize + "]\n");
                sizeCondition.await();
            }
            E element = this.first.data;
            this.first = this.first.next;
            this.currentSize--;
            System.out.println("[Size: " + this.currentSize + "]");
            result = element;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            stackLock.unlock();
        }
        return result;
    }
    public boolean isEmpty(){
        stackLock.lock();
        try {
            System.out.println("[Is Empty?:" + this.first==null);
            return this.first==null;
        }finally {
            stackLock.unlock();
        }
    }
    public int size(){
        return this.currentSize;
    }
}
