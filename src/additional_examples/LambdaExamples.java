package additional_examples;

import java.util.ArrayList;
import java.util.List;

public class LambdaExamples {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "delta", "charlie"
        ));
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("--------");
        list.forEach((s) -> System.out.println(s));
        System.out.println("--------");
        list.forEach((var myString) -> System.out.println(myString));
        System.out.println("--------");
        String prefix = "nato";
        list.forEach((var myString) ->{
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });
    }
}
