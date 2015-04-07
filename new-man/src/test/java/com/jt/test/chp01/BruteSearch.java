package com.jt.test.chp01;

/**
 * @author he
 * @since 2015/4/7
 */
public class BruteSearch {

    public static int search(int key, int[] des) {
        int len = des.length;
        for (int i = 0; i < len; i++) {
            if (key == des[i]) {
                return i;
            }
        }
        return -1;
    }
}
