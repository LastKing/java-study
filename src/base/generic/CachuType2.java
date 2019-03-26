package base.generic;

import java.lang.reflect.Method;

/**
 * @author toonew on 2019-03-26
 */
public class CachuType2 {

    private static class TempList<T> {
        private T t;

        public T setT(T t) {
            this.t = t;
            return t;
        }
    }


    public static void main(String[] args) throws Exception {

        System.out.println("泛型类型擦除之后的原始类型");
        TempList<Integer> tempList = new TempList<>();
        System.out.println(tempList.getClass().getDeclaredField("t").getType());


        Method[] methods = tempList.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getReturnType() + " " + method.getName() + " (" + method.getParameterTypes()[0] + ")");
        }

    }

}
