package imperativevsdeclarative;

import java.util.stream.IntStream;

/**
 * <p>
 *     Perform sum of first hundred Numbers
 * </p>
 */
public class ImperativeVsDeclarativeExample1 {

    public static void main(String[] args) {

        /**
         * Imperative Approach
         * Here we are mutating Variable (sum) to get the result.
         */
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println("By Imperative Approach, Sum is : " + sum);

        /**
         * Declarative Approach
         */
        sum = IntStream.rangeClosed(0, 100)
                .sum();
        System.out.println("By Declarative Approach, Sum is : " + sum) ;
    }
}
