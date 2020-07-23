package remove_words;

public class RemoveWords {
    public static void main(String[] args) {
        String s = "alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta";
        String[] arr = s.split(" ");
        String resStr = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (!resStr.contains(arr[i])) {
                resStr = resStr + " " + arr[i];
            }
        }
        System.out.println(resStr);
    }
}
