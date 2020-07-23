package nod;

import java.util.Scanner;

public class NOD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a + " " + b);
        int res;
        while(true) {
            if (a >= b) {
                a = a % b;
                System.out.println(a + " " + b);
            } else {
                b = b % a;
                System.out.println(a + " " + b);
            }
            if (a == 0) {
                System.out.println(b);
                break;
            }
            if (b == 0) {
                System.out.println(a);
                break;
            }
        }
    }
}
