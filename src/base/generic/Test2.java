package base.generic;

/**
 * @author toonew on 2019-03-26
 */
public class Test2<T, S, U, V, A, B> {

    private T t;
    private S s;
    private U u;
    private V v;
    private A a;
    private B b;


    private void set(T first, S second, U third, V fourth, A fifth, B sixth) {
        System.out.println("第1个参数的类型是：" + first.getClass().getName().toString());
        System.out.println("第2个参数的类型是：" + second.getClass().getName().toString());
        System.out.println("第3个参数的类型是：" + third.getClass().getName().toString());
        System.out.println("第4个参数的类型是：" + fourth.getClass().getName().toString());
        System.out.println("第5个参数的类型是：" + fifth.getClass().getName().toString());
        System.out.println("第6个参数的类型是：" + sixth.getClass().getName().toString());
    }

    public static void main(String[] args) {
        Test2<Integer, Double, Float, String, Long, Short> myMultiType = new Test2<>();
        myMultiType.set(1, 1D, 1F, "1", 1L, (short) 1);
    }

}
