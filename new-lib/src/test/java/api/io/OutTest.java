package api.io;

import org.junit.Test;
import std.libs.Out;

/**
 * since 2015/4/21.
 */
public class OutTest {

    @Test
    public void test01() throws Exception {
        Out out = new Out();
        out.print(1);
    }
}
