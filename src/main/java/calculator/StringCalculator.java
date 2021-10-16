package calculator;

class StringCalculator {

    public int add(String input) {
    	if(isEmpty(input))
        {
    		return 0;
        }
    	if(input.length()==1)
    	{
    		return convertToInt(input);
    	}
    	else {
    		String[] numbers=input.split(",");
    		return calculateSum(numbers[0],numbers[1]);
    	}
    }
    private boolean isEmpty(String input) {
    	return input.isEmpty();
    }
    private int convertToInt(String input) {
    	return Integer.parseInt(input);
    }
    
    private int calculateSum(String num1, String num2) {
    	return Integer.parseInt(num1)+Integer.parseInt(num2);
    }

}