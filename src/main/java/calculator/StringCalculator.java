package calculator;

class StringCalculator {

	private final String delimiters=",|\n";
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
    		String[] numbers=input.split(delimiters);
    		return calculateSum(numbers);
    	}
    }
    private boolean isEmpty(String input) {
    	return input.isEmpty();
    }
    private int convertToInt(String input) {
    	return Integer.parseInt(input);
    }
    
    private int calculateSum(String[] numbers) {
    	int totalSum=0;
    	for(String number: numbers)
    	{
    		if(!isEmpty(number.trim()))
    			totalSum+=Integer.parseInt(number.trim());    		
    	}
    	
    	return totalSum;
    }

}