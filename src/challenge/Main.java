package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] firstNames = {"Bob", "Robert", "Anna", "Agnieszka", "Henry"};

        Arrays.setAll(firstNames, i -> firstNames[i].toUpperCase());
        System.out.println(Arrays.toString(firstNames));
        System.out.println("-------------");

        Arrays.setAll(firstNames, i -> {
                    Random random = new Random();
                    int initialNumber = random.nextInt(65, 91);
                    char randomChar = (char) initialNumber;
                    return firstNames[i] + " " + randomChar + ".";
                }
        );
        System.out.println(Arrays.toString(firstNames));
        System.out.println("-------------");

        Arrays.setAll(firstNames, i -> {
            String copyOfName = firstNames[i];
            String[] partsOfName = splitString(copyOfName, 2);
            StringBuilder nameToReverse = new StringBuilder(partsOfName[0]);
            nameToReverse.reverse();
            String surname = nameToReverse.toString();
            return firstNames[i] + " " + surname;
        });


        List<String> modifiableList = new ArrayList<>(Arrays.asList(firstNames));
        modifiableList.forEach(s -> System.out.println(s));
        System.out.println("-------------");


        modifiableList.removeIf(n -> {
            String[] partsOfName = splitString(n,3);
            return partsOfName[0].equals(partsOfName[2]);
        });
        modifiableList.forEach(s -> System.out.println(s));
        System.out.println("-------------");
    }

    public static String[] splitString(String toSplit, int limit){
        return toSplit.split(" ", limit);
    }
}
