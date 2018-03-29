package base.generic;

/**
 * 最基本的泛型类
 * 出处：http://www.cnblogs.com/lwbqqyumidi/p/3837629.html
 * Created by Rain on 2017/2/28.
 */
public class GenericTest2 {
    public static void main(String[] args) {
        Box<String> name = new Box<>("corn");
        Box<Integer> age = new Box<>(712);

        System.out.println("name:" + name.getData());

        //泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
        System.out.println("name class:" + name.getClass());
        System.out.println("age class:" + age.getClass());
        System.out.println(name.getClass() == age.getClass());


        Box<Number> name2 = new Box<>(99);
        Box<Integer> age2 = new Box<>(712);

        getData(name2);
//        getData(age2);   //Box<Number>在逻辑上不能视为Box<Integer>的父类

        //在逻辑上Box<Number>不能视为Box<Integer>的父类。
//        Box<Integer> a3 = new Box<>(712);
//        Box<Number> b3 = a3;  // 1
//        Box<Float> f = new Box<>(3.14f);
//        b3.setData(f);        // 2

        //所以在此基础上 出现了类型通配符
        Box<String> name4 = new Box<>("corn");
        Box<Integer> age4 = new Box<>(712);
        Box<Number> number4 = new Box<>(314);

        getData2(name4);
        getData2(age4);
        getData2(number4);

        //类型通配符上限和类型通配符下限
        //类型通配符上限通过形如Box<? extends Number>形式定义 （只允许Number以及Number的子类）
        //类型通配符下限为Box<? super Number>形式，其含义与类型通配符上限正好相反 （只允许Number的超类）
//        getData3(name4);
        getData3(age4);
        getData3(number4);
    }

    public static void getData(Box<Number> data) {
        System.out.println("data :" + data.getData());
    }

    public static void getData2(Box<?> data) {
        System.out.println("data2 :" + data.getData());
    }

    public static void getData3(Box<? extends Number> data) {
        System.out.println("data2 :" + data.getData());
    }
}

class Box<T> {
    private T data;

    public Box() {
    }

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
