package mini_challenge;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MiniDemo {
    public static void main(String[] args) {

        //Consumer Interface
        Consumer<String> printTheParts = (s) -> {
            String[] parts = s.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };
        printTheParts.accept("Let's split this up into an array");

        System.out.println("-----------------");

        Consumer<String> printWordsForEach = s -> {
            String[] parts = s.split(" ");
            Arrays.asList(parts).forEach(word -> System.out.println(word));
        };
        printWordsForEach.accept("Let's split this up into an array");
        System.out.println("-----------------");

        Consumer<String> printWordsConcise = sentence ->
                Arrays.asList(sentence.split(" ")).forEach(word -> System.out.println(word));
        printWordsForEach.accept("Let's split this up into an array");
        System.out.println("-----------------");

        //Function Interface
        UnaryOperator<String> myString = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(myString.apply("1234567890"));
        System.out.println("--------------");

        System.out.println(everySecondCharacter(myString, "1234567890"));
        System.out.println("--------------");

        //Supplier Interface
        Supplier<String> iLoveJava = () -> "I love Java";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String everySecondCharacter(UnaryOperator<String> s, String tekst) {
        return s.apply(tekst);
    }
}
