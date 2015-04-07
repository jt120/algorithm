package com.jt.test.chp01;

/**
 * @author he
 * @since 2015/4/7
 */
public class BinarySearch {

    public static int search(int key, int[] des) {
        int lo = 0;
        int hi = des.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (key < des[mid]) {
                hi = mid-1;
            } else if (key > des[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
