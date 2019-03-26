package base.lambda;

@FunctionalInterface
interface CustomLambdaInterface<T, F> {
    T play(F f);
}

public class CustomLambda {

    public static void main(String[] args) {

        CustomLambdaInterface<String, Integer> custom = new CustomLambdaInterface<String, Integer>() {
            @Override
            public String play(Integer integer) {
                return String.valueOf(integer + 1);
            }
        };
        System.out.println(custom.play(100));


        CustomLambdaInterface<String, Integer> custom2 = (integer) -> String.valueOf(integer + 100);
        System.out.println(custom2.play(100));


    }

}
