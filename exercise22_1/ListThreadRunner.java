package exercise22_1;

import java.util.LinkedList;
import java.util.List;

public class ListThreadRunner {
    public static void main(String[] args) {
        List<Integer> lst = new LinkedList<>();
        final int VALUE = 10;
        final int REPETITIONS = 5;
        final int THREADS = 10;

        for(int i = 1; i <= REPETITIONS; i++){
            AddRunnable<Integer> a = new AddRunnable<>(lst,VALUE,REPETITIONS);
            RemoveRunnable<Integer> r = new RemoveRunnable<>(lst,VALUE,REPETITIONS);
            Thread a1 = new Thread(a);
            Thread r1 = new Thread(r);
            a1.start();
            r1.start();

        }
    }
}
