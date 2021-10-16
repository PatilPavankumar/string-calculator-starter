package calculator;

import java.util.ArrayList;

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
    		
    		String delimiters = "";
    		ArrayList<String> objList=getDelimiters(input);
    		delimiters="["+objList.get(0)+",|\n]";
    		String[] numbers=objList.get(1).split(delimiters);
    		return calculateSum(numbers);
    	}
    }
    
    private ArrayList<String> getDelimiters(String input){
    	String tempDelimitor="";
    	if(input.indexOf("//")==0)
    	{
    		tempDelimitor=input.substring(input.indexOf("//")+2, input.indexOf("\n"));
    		input=input.substring(input.indexOf("\n")+1);
    	}
    	ArrayList<String> objList= new ArrayList<String>();
    	objList.add(tempDelimitor);
    	objList.add(input);
    	return objList;
    }
    private boolean isEmpty(String input) {
    	return input.isEmpty();
    }
    private int convertToInt(String input) {
    	return Integer.parseInt(input);
    }
    
    private int calculateSum(String[] numbers) {
    	int totalSum=0;
    	String negNumberStr="";
    	for(String number: numbers)
    	{
    		if(!isEmpty(number.trim()))
    		{
    			if(convertToInt(number) < 0){
            		if(negNumberStr.equals(""))
            			negNumberStr = number;
            		else
            			negNumberStr += ("," + number);
            	}
        		
        		if(convertToInt(number) < 1000)
        			totalSum+=Integer.parseInt(number.trim());
    		}
    		 
    	}

		if(!negNumberStr.equals("")){
			throw new IllegalArgumentException("Negatives not allowed: " + negNumberStr);
		}
    	
    	return totalSum;
    }

}