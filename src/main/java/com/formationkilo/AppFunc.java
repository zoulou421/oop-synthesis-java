package com.formationkilo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class AppFunc {
    public static void main(String[] v){
        //Consumer<String> consumer= System.out::println; LAMBDA EXPRESSION
        Consumer<String> consumer=(input)->{
            System.out.println(input);
        };
        consumer.accept("Test consumer!");

        //Supplier<String>supplier=()->"return something supplier"; lambdaExpress
        Supplier<String>supplier=()-> {
            return "something supplier";
        };
        System.out.println(supplier.get());


        Function<Integer,Integer>function=a->a*4;
        System.out.println("Return x4 is "+function.apply(2));

    }
}
