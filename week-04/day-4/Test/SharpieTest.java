import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SharpieTest {

    Sharpie sharpie = new Sharpie("blue", 2.5);

    @Test
    public void useTest(){
        sharpie.use();
        assertEquals(98.5, sharpie.getInkAmount());
    }

    @Test
    public void inkAmountNegative(){
        for (int i = 0; i < 100; i++) {
            sharpie.use();
        }
        assertTrue(sharpie.getInkAmount() >= 0);
    }
}