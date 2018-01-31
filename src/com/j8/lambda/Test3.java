package com.j8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * create by toonew on 2018/2/1
 */
public class Test3 {

    public static void main(String[] args) {
        //java8之前：
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features)
            System.out.println(feature);

        //java8：
        List<String> features2 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        features2.forEach(n -> System.out.println(n));
        features2.forEach(System.out::println); //神奇的语法糖。。。免得写那个n。。。都是牛人

    }

}
