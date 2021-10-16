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
    		totalSum+=Integer.parseInt(number);    		
    	}
    	
    	return totalSum;
    }

}