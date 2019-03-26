package base.generic;

/**
 * 类型擦除
 * https://blog.csdn.net/hanchao5272/article/details/79351897
 *
 * @author toonew on 2019-03-26
 */
public class CachuType {

    private static class MyGenericsType<T> {


    }


    public static void main(String[] args) {
        //泛型原始类型
        MyGenericsType myGenericsType = new MyGenericsType();
        System.out.println(myGenericsType.getClass().toString());

        //泛型类型
        MyGenericsType<Integer> integerMyGenericsType = new MyGenericsType<>();
        System.out.println(integerMyGenericsType.getClass().toString());

        MyGenericsType<Double> doubleMyGenericsType = new MyGenericsType<Double>();
        System.out.println(doubleMyGenericsType.getClass().toString());

    }

}
