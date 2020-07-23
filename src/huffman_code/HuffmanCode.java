package huffman_code;

import java.util.*;

public class HuffmanCode {
    Map<String, String> resultMap = new TreeMap<>();

    public static void main(String[] args) {
        String s = "abacabadee";
        new HuffmanCode().huffman(s);
    }
    private void huffman(String str) {
        List<String> list = new ArrayList<>(Arrays.asList(str.split("")));
        list.forEach(item -> System.out.print(item + " "));
        Map<String, Integer> map = new TreeMap<>();
        for(String letter : list) {
            int count = 0;
            for (String compareLetter : list) {
                if (letter.equals(compareLetter)) {
                    count++;
                }
            }
            map.put(letter, count);
        }
        System.out.println();
        System.out.println(map.size());
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        System.out.println(entryList);
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        System.out.println(entryList);
        int primarySize = entryList.size();
        while (entryList.size() > 0) {
            makeNode(entryList, primarySize);
            entryList.remove(entryList.size() - 1);
        }
        System.out.println(resultMap);
    }
    private void makeNode(List<Map.Entry<String, Integer>> list, int primarySize) {
        Map.Entry<String, Integer> minEntry = list.get(list.size() - 1);
        resultMap.put(minEntry.getKey(), getCode(minEntry.getValue(), list.size(), primarySize));
    }
    private String getCode (int value, int currentSize, int primarySize) {
        String result = "";
        for (int i = 1; i < currentSize - 1; i++) {
            result = result + "1";
        }
        if (currentSize == primarySize) {
            result = result + "1";
        } else {
            result = result + "0";
        }
        return result;
    }
}
