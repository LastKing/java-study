package com.ltx.pool.ThreadPool1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rain on 2017/2/14.
 */
public class test1 {
    ArrayBlockingQueue queuey = new ArrayBlockingQueue(10);

    ThreadPoolExecutor t = new ThreadPoolExecutor(10, 20,
            1000, TimeUnit.SECONDS, queuey);


}
