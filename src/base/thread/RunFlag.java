package base.thread;

/**
 * 这里需要什么 jvm -server 才能出现，
 * Created by Rain on 2017/2/16.
 */
public class RunFlag extends Thread {
    private volatile boolean flag = true;

    public void setRunning(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println("进入running");
        while (flag == true) {

        }
        System.out.println("结束");
    }

    public static void main(String[] args) {
        RunFlag rf = new RunFlag();
        rf.start();
        try {
            rf.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rf.setRunning(false);
    }
}
