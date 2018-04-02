package base.thread.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * 执行器和锁的应用
 * https://zhuanlan.zhihu.com/p/33267165
 * create by toonew on 2018/4/2
 */
public class Test7 {

    public static void main(String[] args) {
        Runnable rTask = new RunnableTask();
        Executor executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000)
                .forEach(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        ((ExecutorService) executor).submit(rTask);
                    }
                });
        System.out.println(((RunnableTask) rTask).count);
    }

    private static class RunnableTask implements Runnable {
        private final byte[] lock = new byte[1];
        int count = 0;

        @Override
        public void run() {
            synchronized (lock) {
                count = count + 1;
            }
        }
    }
}
