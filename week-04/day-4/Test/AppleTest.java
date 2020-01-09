import Apple.Apple;
import org.junit.Assert;
import org.junit.Test;


public class AppleTest {

    @Test
    public void getAppleTest() {
        Apple apple = new Apple();
        Assert.assertEquals("apple", apple.getApple());
    }

}