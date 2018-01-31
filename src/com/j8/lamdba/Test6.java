package com.j8.lamdba;

import java.util.Arrays;
import java.util.List;

/**
 * create by toonew on 2018/2/1
 */
public class Test6 {

    public static void main(String[] args) {
        List<Double> costBeforeTax = Arrays.asList(100.0, 200.0, 300.0, 400.0, 500.0);

        for (Double cost : costBeforeTax) {
            double price = cost + .12 * cost;
            System.out.println(price);
        }

        costBeforeTax.stream()
                .map(cost -> cost + 0.12 * cost)
                .forEach(System.out::println);

    }

}
