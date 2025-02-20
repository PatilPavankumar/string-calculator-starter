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
    
    @Test
    public void testTwoNumbersNewLineDelimitted() {
    	assertEquals(6, stringCalculator.add("1\n2,3"));
    }
    
    @Test
    public void testDifferentDelimitted() {
    	assertEquals(3, stringCalculator.add("//;\n1;2"));
    }
    
    @Test
    public void testSingleNegativeNumberReturnsException() {
    	//Single negative number
    	try {
    		stringCalculator.add("-1,2");
    	}
    	catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}
    }
    
    @Test
    public void testMultipleNegativeNumberReturnsException() {
    	//Multiple negative number
    	try {
    		stringCalculator.add("-1,2,-4,5,-3,8");
    	}
    	catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1,-4,-3");
		}
    }
    
    @Test
    public void testNumberOverThousand(){
    	assertEquals(2, stringCalculator.add("1000,2"));
    }
    
    @Test
    public void testAnyLengthDelimiter(){
    	assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
    }
    
    @Test
    public void testMultipleDelimitedNumbers(){
    	assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
    }
    
    @Test
    public void testMultipleDelimitedHavingAnyLengthNumbers(){
    	assertEquals(6, stringCalculator.add("//[***][%%%]\n1***2%%%3"));
    }
}
