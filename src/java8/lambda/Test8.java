package java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * create by toonew on 2018/2/1
 */
public class Test8 {

    public static void main(String[] args) {

        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");

        List<String> G7Countries = G7.stream()
//                .map(x->x.toUpperCase())
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(G7Countries);
    }

}
