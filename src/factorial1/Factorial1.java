package factorial1;

import java.util.Scanner;

class Factorial1 {
    int fact (int n) {
        int result;
        if (n == 1) return 1;
        result = fact(n - 1) * n;
        return result;
    }
}
class FactRun {
    public static void main(String[] args) {
        Factorial1 f = new Factorial1();
        System.out.print("введите число: ");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        System.out.println("факториал " + i + " равен " + f.fact(i));
    }
}

