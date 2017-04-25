package Main;
/**
 * Created by Ben Droste on 4/25/2017.
 */

import junit.framework.Assert;
import org.junit.Test;

public class TestHelloWorld {
    @Test
    public void testPrintHelloWorld() {
        Assert.assertEquals(main.hello(),"Hello World");
    }
}
