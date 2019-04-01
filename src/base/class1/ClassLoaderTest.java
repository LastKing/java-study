package base.class1;

/**
 * @author toonew on 2019-03-26
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

        ClassLoader cl1 = Test.class.getClassLoader();

        System.out.println("ClassLoader is:" + cl1.toString());
        System.out.println("ClassLoader\'s parent is:" + cl1.getParent().toString());


//        cl1=int.class.getClass();


    }

}
