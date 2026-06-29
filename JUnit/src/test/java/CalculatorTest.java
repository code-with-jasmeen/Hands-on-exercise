package DeepSkill.JUnit.src.test.java;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    
    private Calculator calculator;

    
    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Test environment initialized: Calculator instance created.");
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Test environment cleaned up: Calculator instance set to null.");
    }

    @Test
    public void testAdd() {
        
        int a = 15;
        int b = 10;

        
        int result = calculator.add(a, b);


        assertEquals(25, result);
    }

    @Test
    public void testSubtract() {
    
        int a = 20;
        int b = 8;

        int result = calculator.subtract(a, b);


        assertEquals(12, result);
    }
}