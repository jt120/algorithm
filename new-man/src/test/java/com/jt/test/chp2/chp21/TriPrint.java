package com.jt.test.chp2.chp21;

/**
 * since 2017/3/15.
 */
public class TriPrint {

    static int size = 5;

    /*


#####
####
###
##
#
     */
    public static void print1() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        System.out.println("========");
    }

    /*
#
##
###
####
#####
     */
    public static void print2() {
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j > 0; j--) {
                System.out.print("#");
            }
            System.out.println();
        }
        System.out.println("========");
    }



    public static void main(String[] args) throws Exception {
        print1();
        print2();
    }
}
