package hanoi_problem;

import java.util.Collections;
import java.util.Stack;

public class HanoiTower {

    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();
    Stack<Integer> third = new Stack<>();

    public static void main(String[] args) {
        new HanoiTower().start();
    }
    private void start() {
//        filling the first stack
        first.push(8);
        first.push(7);
        first.push(6);
        first.push(5);
        first.push(4);
        first.push(3);
        first.push(2);
        first.push(1);

//        init call recursive method
        exchange(first, second, third, first.size());

//        check all stacks finally
        while (!first.empty()) {
            System.out.print("first: ");
            System.out.println(first.pop());
        }
        while (!second.empty()) {
            System.out.print("second: ");
            System.out.println(second.pop());
        }
        while (!third.empty()) {
            System.out.print("third: ");
            System.out.println(third.pop());
        }
    }

    private void exchange (Stack<Integer> from, Stack<Integer> help, Stack<Integer> to, int size) {
        if (size > 0) {
//            checkAllStack(from);
            exchange(from, to, help, size - 1);
            int biggest = from.pop();
            to.push(biggest);
            exchange(help, from, to, size - 1);
        }
    }
//    private void checkAllStack (Stack<Integer> stack) {
//        if (stack.size() > 0) {
//            System.out.println("<stack-----");
//            stack.forEach(System.out::println);
//            System.out.println("---------->");
//        } else {
//            System.out.println(0);
//        }
//    }
}
