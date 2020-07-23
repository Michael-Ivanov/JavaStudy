package substitution_cipher;

import java.util.*;

public class SubstitutionCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String origStr = scanner.nextLine();
        String resStr = scanner.nextLine();
        String lineOne = scanner.nextLine();
        String lineTwo = scanner.nextLine();
        Map<String, String> mapOne = new HashMap<>();
        Map<String, String> mapTwo = new HashMap<>();
        for (int i = 0; i < origStr.length(); i++) {
            String one = origStr.substring(i, i + 1);
            String two = resStr.substring(i, i + 1);
            mapOne.put(one, two);
            mapTwo.put(two, one);
        }
        lineOne.chars().forEach(ch -> System.out.print(mapOne.get(String.valueOf((char)ch))));
        System.out.println();
        lineTwo.chars().forEach(ch -> System.out.print(mapTwo.get(String.valueOf((char)ch))));
    }
}
