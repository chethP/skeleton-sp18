import static org.junit.Assert.*;

import org.junit.Test;
public class FlikTest {
    @Test
    public void testIsSameNumber() {
        int a =128  , b=128;
        Integer c =128;
        Integer d=128;
        assertTrue(Flik.isSameNumber(a, b));

        assertTrue(Flik.isSameNumber(c, d));
    }
}
