package base.string;

/**
 * create by toonew on 2018/2/1
 */
public class Test1 {

    public static void main(String[] args) {
        //三者都是char[] 实现的
        //但是String 在char[]前增加了final ，导致所有的修改都会重新生成对象
        String str = "test"; //不可变，每次都是生成一个心的char []

        //线程安全 和 线程不安全
        //都是动态扩容 每次*2 （大概）
        StringBuffer sb = new StringBuffer("test");
        StringBuilder sb2 = new StringBuilder("test");
    }

}