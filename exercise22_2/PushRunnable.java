package exercise22_2;

public class PushRunnable <E> implements Runnable{
    private static final int DELAY = 1;
    private LinkedListStack<E> stack;
    private E value;
    private int count;
    public PushRunnable(LinkedListStack<E> stack,E value,int count){
        this.stack = stack;
        this.value = value;
        this.count = count;

    }
    @Override
    public void run() {
        try {
            for (int i = 1; i<= count; i++){
                stack.push(value);
                Thread.sleep(DELAY);
            }
        }catch (InterruptedException e){

        }

    }
}
