package com.question.order_question;

import java.util.concurrent.CountDownLatch;

/**
 * 问题 出处
 * https://zhuanlan.zhihu.com/p/33605492?utm_source=qq&utm_medium=social
 * create by toonew on 2018/2/11
 */
public class OrderService {
    public boolean canOrder(final int uid) {
        final CountDownLatch counter = new CountDownLatch(3);
        final Boolean[] running = {Boolean.TRUE};
        final Thread[] t = new Thread[3];

        t[0] = new Thread(() -> {
            if (!new RemoteBankService().checkCredit(uid)) {
                running[0] = false;
                t[1].interrupt();
                t[2].interrupt();
                counter.countDown();
                counter.countDown();
            }
            counter.countDown();
        });
        t[1] = new Thread(() -> {
            if (!new RemoteLoanService().checkRisk(uid)) {
                running[0] = false;
                t[1].interrupt();
                t[2].interrupt();
                counter.countDown();
                counter.countDown();
            }
            counter.countDown();
        });
        t[2] = new Thread(() -> {
            if (!new RemotePassportService().checkAuth(uid)) {
                running[0] = false;
                t[1].interrupt();
                t[2].interrupt();
                counter.countDown();
                counter.countDown();
            }
            counter.countDown();
        });

        for (Thread aT : t) aT.start();

        try {
            counter.await();
            if (!running[0]) return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) {
        boolean canOrder = new OrderService().canOrder(12345);
        if (canOrder) {
            System.out.println("恭喜，下单成功");
        } else {
            System.out.println("抱歉，下单失败");
        }
    }

}
