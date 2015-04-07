package com.jt.test.chp13;

import org.junit.Test;

/**
 * since 2015/4/7.
 */
public class PlusTest {

    @Test
    public void test01() throws Exception {
        int a = 0;
        int b = a++;
        int c =0;
        int d = ++c;
        System.out.println(b + "_ " + d);
    }
}
