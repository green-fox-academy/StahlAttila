import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FiboTest {

    public Integer index;
    public Fibo fibo;

    @Before
    public void init() {
        fibo = new Fibo();
    }

    @Test
    public void fiboTestWith0() {
        assertEquals(0, Fibo.fibo(0));
    }

    @Test
    public void fiboTestWith1() {
        assertEquals(1, Fibo.fibo(1));
    }

    @Test
    public void fiboTestWith2() {
        assertEquals(1, Fibo.fibo(2));
    }

    @Test
    public void fiboTestWithNegative() {
        assertNull(Fibo.fibo(-1));
    }

    @Test
    public void fiboTestWithNull() {
        assertNull(Fibo.fibo(null));
    }

}