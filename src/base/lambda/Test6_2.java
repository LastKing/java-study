package base.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * create by toonew on 2018/2/1
 */
public class Test6_2 {

    public static void main(String[] args) {
        List<Double> costBeforeTax = Arrays.asList(100.0, 200.0, 300.0, 400.0, 500.0);
        Double total = 0.0;
        for (Double cost : costBeforeTax) {
            double price = cost + .12 * cost;
            total = total + price;
        }
        System.out.println("Total : " + total);

        Double bill = costBeforeTax.stream()
                .map(cost -> cost + 0.12 * cost)
                .reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + total);
    }

}
