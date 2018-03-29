package base.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 参考:  https://www.jianshu.com/p/14bd5d9654fe
 * Created by toonew on 2017/2/23.
 */
public class Test1 {
    public static void main(String[] args) {
        Set set = new HashSet();            //底层由HashMap实现

        Set set2 = new LinkedHashSet();     //双向链表介于上下两者

        Set set3 = new TreeSet();           //SortedSet接口有一个实现类：TreeSet（底层由平衡二叉树/红黑树实现）
    }
}
