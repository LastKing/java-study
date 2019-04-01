package base.serializable;

import java.io.*;

/**
 * 仔细看这个例子。可能有点想错
 * https://www.ibm.com/developerworks/cn/java/j-lo-serial/
 * create by toonew on 2018/3/14
 */
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int staticVar = 5;

    public static void main(String[] args) throws Exception {
        //初始时staticVar为5
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
        out.writeObject(new Test());
        out.close();

        //序列化后修改为10
        Test.staticVar = 10;

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("result.obj"));
        Test t = (Test) oin.readObject();
        oin.close();

        //再读取，通过t.staticVar打印新的值
        System.out.println(t.staticVar);
    }
}