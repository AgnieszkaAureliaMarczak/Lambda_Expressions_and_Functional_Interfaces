package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {
        String[] firstNames = {"Bob", "Robert", "Anna", "Agnieszka", "Henry"};

        Arrays.setAll(firstNames, i -> firstNames[i].toUpperCase());
        System.out.println(Arrays.toString(firstNames));
        System.out.println("-------------");

        List<String> backedByArray = Arrays.asList(firstNames);
        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'Z') + ".");
        System.out.println(Arrays.toString(firstNames));

        /*Arrays.setAll(firstNames, i -> {
                    int initialNumber = random.nextInt(65, 91);
                    return firstNames[i] + " " + (char) initialNumber + ".";
                }
        );
        System.out.println(Arrays.toString(firstNames));
        System.out.println("-------------");*/

        /*Arrays.setAll(firstNames, i -> {
            String copyOfName = firstNames[i];
            String[] partsOfName = splitString(copyOfName, 2);
            StringBuilder nameToReverse = new StringBuilder(partsOfName[0]);
            return firstNames[i] + " " + nameToReverse.reverse().toString();
        });*/

        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]));

        Arrays.asList(firstNames).forEach(s -> System.out.println(s));
        System.out.println("-------------");

        List<String> newList = new ArrayList<>(List.of(firstNames));

        newList.removeIf(n -> n.substring(0, n.indexOf(" ")).equals(n.substring(n.lastIndexOf(" ") + 1))
        );
        newList.forEach(s -> System.out.println(s));
        System.out.println("-------------");
    }

    public static String[] splitString(String toSplit, int limit) {
        return toSplit.split(" ", limit);
    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }
}
