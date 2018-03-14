package com.question.order_question;

/**
 * create by toonew on 2018/2/11
 */
public class RemotePassportService {
    private boolean flag = true;

    public boolean checkAuth(int uid) {
        try {
            System.out.println("黑名单验证中。。。");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("黑名单验证终止");
            e.printStackTrace();
        }

        if (flag) {
            System.out.println("恭喜，黑名单验证成功");
            return true;
        } else {
            System.out.println("抱歉，黑名单验证失败");
            return false;
        }
    }
}
