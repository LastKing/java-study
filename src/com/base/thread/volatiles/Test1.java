package com.base.thread.volatiles;

/**
 * create by toonew on 2018/3/23
 */
public class Test1 {

    public static void main(String[] args) throws Exception {
        RunThread thread = new RunThread();
        thread.start();
        Thread.sleep(100);
        thread.setRunFlag(false);
        System.out.println("flag is reseted: " + thread.isRunning());
    }

}

class RunThread extends Thread {
    private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunFlag(boolean flag) {
        isRunning = flag;
    }

    @Override
    public void run() {
        System.out.println("I'm come in...");
        boolean first = true;
        while (isRunning) {
            if (first) {
                System.out.println("I'm in while...");
                first = false;
            }
        }
        System.out.println("I'll go out.");
    }
}