package method_references;

import challenge.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;


public class Challenge {
    private record Person(String first) {
        public String last(String s) {
            return first + " " + s.substring(0, s.indexOf(" "));
        }
    }

    public static void main(String[] args) {
        String[] names = {"Bob", "Robert", "Anna", "Agnieszka", "Henry"};
        Person tim = new Person("Tim");
        List<UnaryOperator<String>> operations = new ArrayList<>(List.of(
                String::toUpperCase, s -> s += " " + Main.getRandomChar('A', 'Z') + ".",
                s -> s += " " + Main.getReversedName(s.split(" ")[0]), s -> s.transform(String::toLowerCase),
                tim::last,
                (new Person("Mary"))::last
        ));
        applyFunction(names, operations);
    }

    private static void applyFunction(String[] array, List<UnaryOperator<String>> functions) {
        List<String> backedArray = Arrays.asList(array);
        for (var function : functions) {
            backedArray.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(array));
        }
    }
}
