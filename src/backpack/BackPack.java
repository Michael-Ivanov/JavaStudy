package backpack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BackPack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        int packVolume = scanner.nextInt();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            int itemPrice = scanner.nextInt();
            int itemVolume = scanner.nextInt();
            Item item = new Item(itemPrice, itemVolume);
            items.add(item);
        }
        items.sort((o1, o2) -> {
            if (o1.pricePerVolume > o2.pricePerVolume) return -1;
            if (o1.pricePerVolume == o2.pricePerVolume) return 0;
            if (o1.pricePerVolume < o2.pricePerVolume) return 1;
            return 0;
        });
        items.forEach(item -> System.out.println(item.toString()));
        double freeVolume = packVolume;
        int count = 0;
        double resValue = 0;
        Item currentItem;
        while (freeVolume > 0) {
            if (count < items.size()) {
                currentItem = items.get(count);
            } else {
                break;
            }
            if (currentItem.volume <= freeVolume) {
                freeVolume -= currentItem.volume;
                resValue += currentItem.price;
                System.out.println("добавили вещь №" + (count + 1) + " . в рюкзаке теперь вещей на сумму " + resValue);
                count++;
            } else {
                double partItemPrice = (freeVolume / currentItem.volume) * currentItem.price;
                resValue += partItemPrice;
                System.out.println("добавили часть вещи №" + (count + 1) + ". в рюкзаке теперь вещей на сумму " + resValue);
                break;
            }
        }
        System.out.format("Итого: %1$.3f", resValue);
    }
}
class Item {
    public int price;
    public int volume;
    public double pricePerVolume;

    public Item(int price, int volume) {
        this.price = price;
        this.volume = volume;
        pricePerVolume = (double) price / volume;
    }

    @Override
    public String toString() {
        return "backpack.Item{" +
                "price=" + price +
                ", volume=" + volume +
                ", pricePerLiter=" + pricePerVolume +
                '}';
    }
}
