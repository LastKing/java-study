package com.j8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * create by toonew on 2018/2/1
 */
public class Test5 {

    public static void main(String[] args) {
        Predicate<String> starsWithJ = n -> n.startsWith("J");
        Predicate<String> fourLetterLong = n -> n.length() > 4;

        List<String> languages = Arrays.asList("Java1", "Scala", "C++", "Haskell", "Lisp");

        languages.stream()
                .filter(starsWithJ.and(fourLetterLong))
                .forEach(n ->
                        System.out.println("nName, which starts with 'J' and four letter long is : " + n));

    }

}
