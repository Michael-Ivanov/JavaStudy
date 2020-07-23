package merge_arrays;

import java.util.Arrays;
public class mergeArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2};
        int[] nums2 = new int[] {0, 0, 3, 3, 45};
        int[] resArray = new int[nums1.length + nums2.length];
        System.out.println(Arrays.toString(nums1) + "    length = " + nums1.length);
        System.out.println(Arrays.toString(nums2) + "    length = " + nums2.length);
        //System.out.println(nums1.length);
        int a = 0, b = 0, c = 0;
        while (a < nums1.length && b < nums2.length) {
            if (nums1[a] < nums2[b]) {
                resArray[c] = nums1[a];
                    a++;
            }
            else {
                resArray[c] = nums2[b];
                b++;
            }
            c++;
        }
        while (a < nums1.length) {
            resArray[c] = nums1[a];
            a++;
            c++;
        }
        while (b < nums2.length) {
            resArray[c] = nums2[b];
            b++;
            c++;
        }

        System.out.println(Arrays.toString(resArray));
    }
}
