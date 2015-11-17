package api.io;

import org.junit.Test;
import std.libs.In;
import std.libs.Print;
import std.libs.StdOut;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * since 2015/4/21.
 */
public class InTest {

    @Test
    public void test01() throws Exception {
        String path = InTest.class.getResource("/").getPath();
        String fileName = path + "hello.txt";
        System.out.println(fileName);
        In in = new In(fileName);
        String[] s = in.readAllStrings();

        Print.println(s);
        in.close();
    }

    @Test
    public void test02() throws Exception {
        Set<String> INTER_PNR_CREATE = new HashSet<>();
        INTER_PNR_CREATE.add("HK");
        INTER_PNR_CREATE.add("DK");
        INTER_PNR_CREATE.add("TK");
        INTER_PNR_CREATE.add("KK");
        String pnr = "MU595  S   FR08MAY  HGHHKG KK2 1355 1600          E  ";
        Matcher matcher = Pattern.compile("\\w{3,} +\\w\\d? +\\w{7,9} {0,}\\w{6} *(\\w{2})\\d* +\\w{4} +\\w{4}" +
                "(\\+\\d){0,1}").matcher(pnr);
        int count = 0;
        boolean[] checkrs = {false, false};
        boolean isHk = true;
        while (matcher.find()) {
            String activeCode = matcher.group(1);
            if (null == activeCode) {
                activeCode = "";
            }
            if (!INTER_PNR_CREATE.contains(activeCode.toUpperCase())) isHk = false;
            count++;
        }
        System.out.println(count);
    }
}
