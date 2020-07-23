package missing_char;

public class missingChar {
    public static void main(String[] args) {
        int p0 = 82, w0 = 127, p1 = 80;
        double y = 100 - p0;
        System.out.println(y);
        y = y / 100;
        System.out.println(y);
        y = y * w0;
        System.out.println(y);
        double w1 = (100 * y) / (100 - p1);
        System.out.println("y= " + y);
        System.out.println("w1= " + (int)w1);
    }
}
