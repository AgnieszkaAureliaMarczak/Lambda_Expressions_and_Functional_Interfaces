package mini_challenge;

import java.util.Arrays;
import java.util.function.Consumer;

public class MiniDemo {
    public static void main(String[] args) {
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

        Consumer<String> printWordsConcise = sentence ->
                Arrays.asList(sentence.split(" ")).forEach(word -> System.out.println(word));
        printWordsForEach.accept("Let's split this up into an array");
    }
}
