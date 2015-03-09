package c01;

/**
 * @author he
 * @since 2015/2/27
 */
public class RecursiveTest {

    //2f(x-1)+x^2
    public static int cal(int x) {
        if (x == 0) {
            return 0;
        }
        return 2*cal(x-1) + x*x;
    }

    public static void print(int num) {
        if (num >= 10) {
            print(num / 10);
        }
        System.out.print(num%10);
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(cal(2));
        print(123);
    }
}
