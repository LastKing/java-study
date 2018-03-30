package base.thread.executor;

import java.util.concurrent.*;

/**
 * create by toonew on 2018/2/10
 */
public class Test2 {

    public static void main(String[] args) throws Exception {

        Callable<Integer> task = () -> {
            TimeUnit.SECONDS.sleep(1);
            return 123;
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());
//        Integer result = future.get();                            //同步阻塞get结果
        Integer result = future.get(5L, TimeUnit.SECONDS);  //同步阻塞get结果，但是加上了超时时间

        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);

    }

}
