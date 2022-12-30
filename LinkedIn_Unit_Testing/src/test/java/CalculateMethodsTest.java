import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculateMethodsTest {
    private CalculateMehods calculateMehods ;

    @BeforeEach
    public void initTest(){
        calculateMehods = new CalculateMehods();
    }

    @Test
    public void testDevide(){
        assertEquals(10 , calculateMehods.divide(100,10));
    }

    @Test
    public void testDivideByZero(){
        assertThrows(ArithmeticException.class, ()-> calculateMehods.divide(100,0));
    }

}
