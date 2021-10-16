package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

class StringCalculatorShould {

	private static StringCalculator stringCalculator;
	
	@BeforeAll
	public static void init() {
		stringCalculator= new StringCalculator();
	}
    
	@Test
    void empty_string_should_return_0() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        assertEquals(1, stringCalculator.add("1"));
    }
    
    @Test
    public void testTwoNumbersCommaDelimitted() {
    	assertEquals(3, stringCalculator.add("1,2"));
    }
    
    @Test
    public void testUnknownAmmoutOfNumbersCommaDelimitted() {
    	assertEquals(1+2+4+5+6+7, stringCalculator.add("1,2,4,5,6,7"));
    }
}
