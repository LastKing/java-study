package base.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * create by toonew on 2018/2/1
 */
public class Test7 {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("a", "b", "c", "test1", "test2", "test3");

        List<String> filtered = strList.stream()
                .filter(x -> x.length() > 2)
                .collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
    }

}
