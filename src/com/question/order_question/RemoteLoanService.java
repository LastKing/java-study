package com.question.order_question;

/**
 * create by toonew on 2018/2/11
 */
public class RemoteLoanService {
    private boolean flag = true;

    public boolean checkRisk(int uid) {
        try {
            System.out.println("不良贷款验证中。。。");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("不良贷款验证终止");
            e.printStackTrace();
        }

        if (flag) {
            System.out.println("恭喜，不良贷款验证成功");
            return true;
        } else {
            System.out.println("抱歉，不良贷款验证失败");
            return false;
        }
    }
}
