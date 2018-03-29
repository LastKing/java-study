package base.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个问题是理解 hashcode 和 equal 在此处的应用
 * 以及一些其他的问题，但是 我并不是特别理解 这个。。。
 * hashcode 和 ==的关系，以及equal方法
 * create by toonew on 2018/2/1
 */
public class HostCodeOrEqual {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        addNumber(list);
        addNumber(list2);
        System.out.println(list);
        System.out.println(list2);
        System.out.println(list == list2);
        System.out.println(list.equals(list2));//这个 看源码就是while 一个个比较

    }

    private static void addNumber(List<Integer> list) {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
    }
}
