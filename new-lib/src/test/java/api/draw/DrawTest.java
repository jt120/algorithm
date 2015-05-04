package api.draw;

import org.junit.Test;
import std.libs.StdDraw;
import std.libs.StdRandom;

import java.util.TreeSet;

/**
 * since 2015/4/21.
 */
public class DrawTest {

    @Test
    public void test01() throws Exception {
        int size = 50;
        double[] doubles = new double[size];
        for (int i = 0; i < size; i++) {
            doubles[i] = StdRandom.uniform();
        }
        for (int i = 0; i < size; i++) {
            StdDraw.filledRectangle(1.0*i/size,doubles[i]/2.0,0.5/size, doubles[i]/2.0);
        }
        System.in.read();
    }

    @Test
    public void test02() throws Exception {
        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.random();
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    public static int find(int a, int[] nums, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (a < nums[mid]) {
            return find(a, nums, lo, mid - 1);
        } else if (a > nums[mid]) {
            return find(a, nums, mid + 1, hi);
        } else {
            return mid;
        }
    }

    @Test
    public void test03() throws Exception {
        int[] as = {3, 2, 5,7,6,9};
        int key = 7;
        //必须是排序的才行
        int i = find(key, as, 0, as.length);
        System.out.println(i);

    }

}
