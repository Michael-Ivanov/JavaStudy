package wikisearch;

import java.net.MalformedURLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        clInterface();
    }

    private static void clInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите запрос:> ");
        String keyString = scanner.nextLine();
        RequestSender sender = new RequestSender();
        try {
            sender.sendRequest(keyString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
