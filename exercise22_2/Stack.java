package exercise22_2;

public interface Stack <E>{
    void push(E element);
    E pop() throws InterruptedException;
    boolean isEmpty();
    int size();
}
