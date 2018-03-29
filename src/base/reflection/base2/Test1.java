package base.reflection.base2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射 与 泛型，获得  return  方法值， 成员变量
 * Created by Rain on 2017/3/2.
 */
public class Test1 {
    public static void returnType() throws NoSuchMethodException {
        Method method = MyClass.class.getMethod("getStringList", null);

        Type returnType = method.getGenericReturnType();

        if (returnType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) returnType;

            Type[] typeArguments = type.getActualTypeArguments();

            for (Type typeArgument : typeArguments) {
                Class typeArgClass = (Class) typeArgument;
                System.out.println("typeArgClass = " + typeArgClass);
            }
        }
    }

    public static void parameterTypes() throws NoSuchMethodException {
        Method method = MyClass.class.getMethod("setStringList", List.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();

        for (Type genericParameterType : genericParameterTypes) {
            if (genericParameterType instanceof ParameterizedType) {
                ParameterizedType type = (ParameterizedType) genericParameterType;
                Type[] parameterArgTypes = type.getActualTypeArguments();
                for (Type parameterArgType : parameterArgTypes) {
                    Class parameterArgClass = (Class) parameterArgType;
                    System.out.println("parameterArgClass = " + parameterArgClass);
                }
            }
        }
    }

    public static void fieldTypes() throws NoSuchFieldException {
        Field field = MyClass.class.getDeclaredField("stringList");

        Type genericType = field.getGenericType();

        if (genericType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) genericType;
            Type[] fieldArgTypes = type.getActualTypeArguments();
            for (Type fieldArgType : fieldArgTypes) {
                Class fieldArgClass = (Class) fieldArgType;
                System.out.println("fieldArgClass = " + fieldArgClass);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        returnType();

        parameterTypes();

        fieldTypes();
    }
}

class MyClass {
    protected List<String> stringList = new ArrayList<>();

    public List<String> getStringList() {
        return this.stringList;
    }


    public void setStringList(List<String> list) {
        this.stringList = list;
    }
}
