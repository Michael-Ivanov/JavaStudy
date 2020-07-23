package prime;

public class Prime {
    static int count = 0;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i:arr) {

        }
    }
    public static int myMeth(int a) {
        a = a + count;
        count++;
        return a;
    }
}