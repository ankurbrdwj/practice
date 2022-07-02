package com.ankur.interview.practice.arrays;

public class MedianSortedArrays {

    public static double medianFromSortedArrays(int[] a, int[] b) {
        // imagine merging two arrays and get the median position
        // then extract the elements from both side and write up in different lines
        // merged array 1 2 3 5 6 | 7 8 10 18 20
        // 1 5  | 8 10 18 20
        // 2 3 6| 7
        // 5 is less than 7 and 6 is less than 8 l1 < r2 (5<7) && l2 <r1(6<8) is the condition for cut1 cut2
        // Max (l1, l2 ) ans Mint (r1,r2 ) will give median
        // let length l1 = x , x can go till length of smaller array .
        // so take smaller array and do binary search for two cuts
        if (a.length > b.length) {
            return medianFromSortedArrays(b, a);
        }
        int x = a.length;
        int y = b.length;
        int lo = 0;
        int hi = x;
        // binary search loop
        while (lo <= hi) {
            int cutA = lo + (hi - lo) / 2;
            int cutB = (x + y + 1) / 2 - cutA; // plus 1 plays well with both even and odd arrasy line no 39
            // Integer.MIN_VALUE and Integer.MAX_VALUE are extreme values on left and right for extreme cases
            int l1 = cutA == 0 ? Integer.MIN_VALUE : a[cutA - 1]; //cutA is length indices are 0 based
            int r1 = cutA == x ? Integer.MAX_VALUE : a[cutA];

            int l2 = cutB == 0 ? Integer.MIN_VALUE : b[cutB - 1];
            int r2 = cutB == y ? Integer.MAX_VALUE : b[cutB];

            if (l1 <= r2 && l2 <= r1) {
                // if both arrays are of even length Max(l1,l2)+Min(r1,r2) /2
                if ((x + y) % 2 == 0) {
                    return (double) ((Math.max(l1, l2) + Math.min(r1, r2)) / 2);
                }// odd length only left side will give the answeres
                else {
                    return (double) ((Math.max(l1, l2)));
                }
            } // binary search condition to shift the lo and hi
            else if (l1 > r2) {
                hi = cutA - 1; // shift one to left
            } else {
                lo = cutA + 1; // shift cut to right
            }
        }// arrays are not sorted in this case
        throw new IllegalArgumentException();
    }
}
