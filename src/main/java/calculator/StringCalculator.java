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
    		
    		String delimiters = ",";
			if(input.matches("//(.*)\n(.*)")){
				delimiters = Character.toString(input.charAt(2));
				input = input.substring(4);
			}
    		String[] numbers=input.split(delimiters + "|\n");
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