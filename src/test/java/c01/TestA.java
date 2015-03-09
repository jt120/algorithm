package c01;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author he
 * @since 2015/2/27
 */
public class TestA {

    @Test
    public void test01() throws Exception {
        print(randomN(10));
    }

    @Test
    public void test02() throws Exception {
        int[] ints = randomN(5);
        print(ints);
        int[] ints1 = topK(2, ints);
        print(ints1);
    }

    @Test
    public void test03() throws Exception {
        for (int i = 97; i < 123; i++) {
            System.out.println(i+":"+(char)i);
        }
    }

    @Test
    public void test04() throws Exception {
        String[][] build = build(4);
        printStrings(build);
    }

    public static int[] randomN(int n) {
        Random random = new Random();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(1000);
        }
        return nums;
    }

    public static void print(int[] nums) {
        for (Integer n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static int[] topK(int k, int[] nums) {
        int len = nums.length;
        int[] res = new int[k];

        if (k >= len) {
            System.arraycopy(nums, 0, res, 0, len);
            return res;
        }
        System.arraycopy(nums, 0, res, 0, k);
        Arrays.sort(res);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < res[k - 1]) {
                res[k - 1] = nums[i];
                Arrays.sort(res);
            }
        }
        return res;
    }

    public static List<String> words() {
        /**
         * a b c d
         * e f g k
         */


        return null;
    }

    public static String[][] build(int count) {
        Random random = new Random();
        String[][] strings = new String[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                int i1 = 97 + random.nextInt(26);
                strings[i][j] = String.valueOf((char) i1);
            }
        }
        return strings;
    }

    public static void printStrings(String[][] strings) {
        int len = strings.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(strings[i][j] + " ");
            }
            System.out.println();
        }
    }
}
