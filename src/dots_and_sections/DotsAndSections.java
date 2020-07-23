package dots_and_sections;

import java.util.*;

public class DotsAndSections {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        List<List<Integer>> allSections = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            System.out.println("ВВедите отрезок " +  (i + 1));
            List<Integer> section = new ArrayList<>();
            section.add(scanner.nextInt());
            section.add(scanner.nextInt());
            System.out.println("Полученный отрезок: " + section.get(0) + " - " + section.get(1));
            allSections.add(section);
        }

        allSections.sort((o1, o2) -> {
            if (o1.get(1) < o2.get(1)) return -1;
            if (o1.get(1).equals(o2.get(1))) return 0;
            if (o1.get(1) > o2.get(1)) return 1;
            return 0;
        });
        System.out.println("Отсортируем");
        System.out.println(allSections.toString() + " Size = " + allSections.size());


        Set<Integer> dots = new HashSet<>();
        int dotFound;
        int k = 0;
        int i = 0;
        while (i < allSections.size()) {
            System.out.println("Проверяем отрезок " + (i + 1) + ": " + allSections.get(i).toString());
            dotFound = allSections.get(i).get(1);
            System.out.println((i + 1) + " точка = " + dotFound);
            dots.add(dotFound);
            for (int j = i + 1; j < allSections.size(); j++) {
                System.out.println("Сравниваем " + allSections.get(i).toString() + " с отрезком " + (j + 1) + ": " + allSections.get(j).toString());
                if (allSections.get(j).get(0) <= allSections.get(i).get(1)) {
                    k = j + 1;
                    System.out.println("Отрезок " + (j + 1) + " пересекает, значит следующим возьмем " + (k + 1));
                } else {
                    break;
                }
            }
            if(k != 0) {
                i = k;
                k = 0;
            } else {
                i++;
            }
        }
        System.out.println(dots.size());
        for (int d : dots) {
            System.out.print(d + " ");
        }
    }
}
