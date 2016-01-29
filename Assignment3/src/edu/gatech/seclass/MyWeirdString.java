package edu.gatech.seclass;

import static org.junit.Assert.assertEquals;

public class MyWeirdString implements MyWeirdStringInterface {

	   private String string;
	   
	
	public void setWeirdString(String string) {
		this.string = string; 
		
	}

	
	public String getWeirdString() {
		return this.string;
	
	}

	
	public String getEvenCharacters() {
		if (this.string == null)
		{
			throw new NullPointerException("String value is null");
		}
		if ((this.string.length() ==  1) || (this.string.isEmpty()))
		{
			throw new IllegalArgumentException("String must have more than one character");
		}
		String evenCharacters="";
		for(int i=0;i<this.string.length();i++){
			if(((i+1)%2 == 0)){
				char ch = string.charAt(i);
				evenCharacters+=ch; 
			
			}
		}
		
		return evenCharacters;
		
	}


	public String getOddCharacters() {
		if (this.string == null)
		{
			throw new NullPointerException("String value is null");
		}
		if (this.string.isEmpty())
		{
			throw new IllegalArgumentException("String must not be empty");
		}
		String oddCharacters="";
		for(int i=0;i<this.string.length();i++){
			if(((i+1)%2 == 1)){
				char ch = string.charAt(i);
				oddCharacters+=ch; 
			//System.out.println(oddCharacters);
			}
		}
		
		return oddCharacters;
	}


	public int countDigits() {
		if (this.string == null)
		{
			throw new NullPointerException("String value is null");
		}
		int count = 0;
		for (int i = 0; i< this.string.length();  i++) {
		    if (Character.isDigit(this.string.charAt(i))) {
		        count++;
		    }
		}
		return count;
	}

	
	public void convertDigitsToRomanNumeralsInSubstring(int startPosition, int endPosition)
			throws MyIndexOutOfBoundsException, IllegalArgumentException {
		  if (string.length() < endPosition){
	            throw new MyIndexOutOfBoundsException("End position is greater than string length");
	        }
		if (this.string == null)
		{
			throw new NullPointerException("String value is null");
		}
		
		
		 if ( startPosition > endPosition){
	            throw new IllegalArgumentException("Start position cannot be greater than endPosition");
	        }
		 if (startPosition<= 0 || endPosition <= 0 ){
	            throw new MyIndexOutOfBoundsException("Wrong positions");
	        }
		
		String str=	this.string;
		String fullString=this.string;
		str= str.substring(startPosition-1,endPosition-1);
		String firstHalf=fullString.substring(0,startPosition-1);
		String secondHalf= fullString.substring(endPosition-1,fullString.length());

			String newString="";
			for (int i = 0; i< str.length();  i++) {
			    if (Character.isDigit(str.charAt(i)) && Character.getNumericValue(str.charAt(i))!=0) {
			    	newString+=toRoman(Character.getNumericValue(str.charAt(i)));
			    }
			    else
			    	newString+=str.charAt(i);
			}
		this.string=firstHalf+newString+secondHalf;	

	}
	
	
	public String toRoman(int r){
	      String[] s = 
	         {"M","CM","D","CD","C","XC",
	          "L","XL","X","IX","V","IV","I"};
	      int[] u = 
	         {1000, 900, 500, 400, 100, 90,
	            50, 40, 10, 9, 5, 4, 1};
	      String t = "";
	      for (int i = 0; i < 13; i++)
	         while (r >= u[i]) {
	            t += s[i];
	            r -= u[i];
	         }
	      return t;
	   }
	
	

}
