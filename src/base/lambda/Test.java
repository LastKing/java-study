package base.lambda;

public class Test {

    public static void main(String[] args) {

        //java8之前：
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!");
            }
        }).start();

        //java8：
        new Thread(() -> System.out.println("hello world")).start();

    }

}
