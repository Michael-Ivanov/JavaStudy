package to_binary_view;

public class ToBinaryView {
   public static void main(String[] args) {
       System.out.println(new ToBinaryView().toBinaryView(1000000000));
   }
   private String toBinaryView(int n) {
       StringBuilder result = new StringBuilder();
       int bitCount;
       for (bitCount = 32; bitCount > 0; bitCount--) {
           System.out.println("bitCount = " + bitCount
                   + "; n = " + n + "; Math.pow(2, " + (bitCount - 1)  + ") = " + (int) Math.pow(2, bitCount - 1));
           if(n >= Math.pow(2, bitCount - 1)) {
               result.append(1 + " ");
           } else {
               result.append(0 + " ");
           }
           n = (int) (n % Math.pow(2, bitCount - 1));
       }
       return result.toString();
   }
}
