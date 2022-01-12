package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calc= null;

    @BeforeEach
    public void setUp(){
        calc = new Calculator();
    }

    @Test
    public void testAdd(){
        assertEquals(5, calc.add(2,3));
        assertEquals(11, calc.add(8,3));
    }

    @Test
    public void testMultiply(){
        assertEquals(9, calc.multiply(3,3));
        assertEquals(-5, calc.multiply(-5,1));
    }

    @Test
    public void testAddPositiveNumbers(){
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->{
            calc.addPositiveNumbers(-7, 7);}, "IllegalArgumentException excepted");
    }
}