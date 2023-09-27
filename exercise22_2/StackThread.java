package exercise22_2;

public class StackThread {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
        final int VALUE = 5;
        final int REPETITIONS = 5;
        final int THREADS = 5;
        for (int i = 1; i <= THREADS; i++){
            PushRunnable<Integer> push = new PushRunnable<>(stack,VALUE,REPETITIONS);
            PopRunnable<Integer> pop = new PopRunnable<>(stack,REPETITIONS);
            EmptyRunnable<Integer> empty = new EmptyRunnable<>(stack,REPETITIONS);
            Thread pushThread = new Thread(push);
            Thread popThread = new Thread(pop);
            Thread emptyThread = new Thread(empty);
            pushThread.start();
            popThread.start();
            emptyThread.start();
        }
    }
}
