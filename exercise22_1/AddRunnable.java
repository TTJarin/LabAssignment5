package exercise22_1;

import java.util.List;

public class AddRunnable<E> implements Runnable {
    List<E>list;
    private static final int DELAY = 1;
    private E element;
    private int count;
    public AddRunnable(List<E> list ,E element, int count){
        this.list = list;
        this.element = element;
        this.count = count;
    }

    @Override
    public void run() {
        try {
            for(int i = 1; i <= count; i++){
                System.out.println("Size : " + list.size());
                list.add(element);
                Thread.sleep(DELAY);
            }

        }catch (InterruptedException e){

        }

    }
}
