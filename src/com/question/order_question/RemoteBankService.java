package com.question.order_question;

/**
 * create by toonew on 2018/2/10
 */
public class RemoteBankService {
    private boolean flag = false;

    public boolean checkCredit(int uid) {
        try {
            System.out.println("银行信用验证中。。。");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("银行信用验证终止");
            e.printStackTrace();
        }

        if (flag) {
            System.out.println("恭喜，银行信用验证成功");
            return true;
        } else {
            System.out.println("抱歉，银行信用验证失败");
            return false;
        }
    }

}
