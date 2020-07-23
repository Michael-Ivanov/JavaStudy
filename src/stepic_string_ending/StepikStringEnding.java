package stepic_string_ending;

import java.io.*;

public class StepikStringEnding {
    public static void main(String[] args) throws IOException {
        byte[] arr = {66, 66, 13, 10, 84, 84, 13, 67, 13, 10};
        System.setIn(new ByteArrayInputStream(arr));
        int first = System.in.read();
        while(true) {
            if(first < 0) break;
            int second = System.in.read();
            if(first != 13 || second != 10) {
                System.out.write(first);
            }
            if (second < 0) break;
            first = second;
        }
        System.out.flush();
    }
}
