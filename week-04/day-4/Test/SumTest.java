import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SumTest {

    ArrayList<Integer> list;
    Sum sum;

    @Before
    public void init(){
        sum = new Sum();
        list = new ArrayList<>();
    }


    @Test
    public void sumMiltipleElementListTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(1+2+3+4, sum.sum(list));
    }

    @Test
    public void sumEmptyListTest() {
        assertEquals(0, sum.sum(list));
    }

    @Test
    public void sumOneElementListTest() {
        list.add(1);
        assertEquals(1, sum.sum(list));
    }

    @Test
    public void sumNullElementTest() {
        assertEquals(0, sum.sum(null));

    }

    @Test
    public void sumElementNullTest() {
        list.add(null);
        assertEquals(0, sum.sum(list));
    }
}