package base.thread;

/**
 * Created by Rain on 2017/2/16.
 */
public class For extends Thread {
    private volatile static int count = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                count++;
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        For[] fors = new For[100];
        for (int i = 0; i < fors.length; i++) {
            fors[i] = new For();
        }

        for (For aFor : fors) {
            aFor.start();
        }
    }

}
