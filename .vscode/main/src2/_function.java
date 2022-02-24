package main.src2;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _function {
    public static void main(String[] args) {
        // Function takes 1 argument and produces one result
        int increment = incrementByOne(0);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        // Chaining Function , it is a style that combine 2 different function from
        // above
        Function<Integer, Integer> addByOneAndThenMultipleBy10 = incrementByOneFunction.andThen(multiplyBy10Function); // plus
                                                                                                                       // one
                                                                                                                       // function
                                                                                                                       // and
                                                                                                                       // then
                                                                                                                       // multiply
                                                                                                                       // by
                                                                                                                       // 10
                                                                                                                       // function
        System.out.println(addByOneAndThenMultipleBy10.apply(4)); // print out the apply function with the input in the
                                                                  // bracket

        // Bifunction takes 2 argument and produces 1 result (it has different printout
        // style)
        System.out.println(incrementByOneAndMultiply(4, 100));

        System.out.println(incrementByOneAndMultiplyBifunction.apply(4, 100));
    }

    // normal function of java
    static int incrementByOne(int number) {
        return number + 1;

    }

    // Bifunction method example
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBifunction = (numberToIncrementByOne,
            numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;

    }

    // new function of java , it is same as the above
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;
}
