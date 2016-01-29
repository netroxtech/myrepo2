package edu.gatech.seclass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyWeirdStringTest {

	private MyWeirdStringInterface myweirdstring;

	@Before
	public void setUp() throws Exception {
		myweirdstring = new MyWeirdString();
	}

	@After
	public void tearDown() throws Exception {
		myweirdstring = null;
	}

	@Test
	public void testCountDigits1() {
		myweirdstring.setWeirdString("I'd better put s0me d1gits in this 5tr1n9, right?");
		assertEquals(5, myweirdstring.countDigits());
	}

	//this test checks if there is no digits in string
	@Test
	public void testCountDigits2() {
		myweirdstring.setWeirdString("Check for no digits in this string");
		assertEquals(0, myweirdstring.countDigits());
	}

	//this test checks for null pointer exception (Current value of string is Null)
	@Test(expected = NullPointerException.class)
	public void testCountDigits3() {
		myweirdstring.setWeirdString(null);
		myweirdstring.countDigits();
		
		
	}
    
	//this test checks for empty string
	@Test
	public void testCountDigits4() {
		myweirdstring.setWeirdString("");
		assertEquals(0, myweirdstring.countDigits());
	}

	@Test
	public void testGetEvenCharacters1() {
		myweirdstring.setWeirdString("I'd better put s0me d1gits in this 5tr1n9, right?");
		assertEquals("' etrptsm 1isi hs5rn,rgt", myweirdstring.getEvenCharacters());
	}

	//This test checks for IllegalArgumentException if there is only
	//one character in string and no character in even position
	@Test(expected = IllegalArgumentException.class)
	public void testGetEvenCharacters2() {
		myweirdstring.setWeirdString("I");
		myweirdstring.getEvenCharacters();
		
	}

	//This test checks if the return string contains characters only of even positions
	@Test
	public void testGetEvenCharacters3() {
		myweirdstring.setWeirdString("abcd");
		assertEquals("bd", myweirdstring.getEvenCharacters());
	}

	//This test the string with space at first even position
	@Test
	public void testGetEvenCharacters4() {
		myweirdstring.setWeirdString("1 26");
		assertEquals(" 6",myweirdstring.getEvenCharacters());
	}

	@Test
	public void testGetOddCharacters1() {
		myweirdstring.setWeirdString("I'd better put s0me d1gits in this 5tr1n9, right?");
		assertEquals("Idbte u 0edgt nti t19 ih?", myweirdstring.getOddCharacters());
	}

	//this will test string with single character at odd position
	@Test
	public void testGetOddCharacters2() {
		myweirdstring.setWeirdString("a");
		assertEquals("a", myweirdstring.getOddCharacters());
	}

	//Verify an empty string will result in exception
	@Test(expected = IllegalArgumentException.class)
	public void testGetOddCharacters3() {
		myweirdstring.setWeirdString("");
		myweirdstring.getOddCharacters();
	}

	//Verify null string returns exception
	@Test(expected = NullPointerException.class)
	public void testGetOddCharacters4() {
		myweirdstring.setWeirdString(null);
		myweirdstring.getOddCharacters();
	}

	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring1() {
		myweirdstring.setWeirdString("I'd better put s0me d1gits in this 5tr1n9, right?");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(40, 45);
		assertEquals("I'd better put s0me d1gits in this 5tr1nIX, right?", myweirdstring.getWeirdString());
	}

	//Test to check IllegalArgumentException is thrown if startPosition is greater than endPosition. 
	@Test(expected = IllegalArgumentException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring2() {
		myweirdstring.setWeirdString("I'd better put s0me d1gits in this 5tr1n9, right?");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(40, 39);
	}

	//This test checks MyIndexOutOfBoundsException is thrown if end position is greater than string length
	@Test(expected = MyIndexOutOfBoundsException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring3() {
		myweirdstring.setWeirdString("Hello 123");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(1, 100);
		myweirdstring.getWeirdString();
	}

	//This test checks for MyIndexOutOfBoundsException of wrong first position  in substring
	@Test(expected = MyIndexOutOfBoundsException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring4() {
		myweirdstring.setWeirdString("Hello 123");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(-1, 3);
		myweirdstring.getWeirdString();
	}

	//This test checks for MyIndexOutOfBoundsException if first and end positions are wrong
		@Test(expected = MyIndexOutOfBoundsException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring5() {
			myweirdstring.setWeirdString("Hello 123");
			myweirdstring.convertDigitsToRomanNumeralsInSubstring(-2, -1);
			myweirdstring.getWeirdString();
	}
   
		//This test checks  digit "0" is not converted 
	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring6() {
		myweirdstring.setWeirdString("hello 460");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(5, 9);
		assertEquals("hello IVVI0", myweirdstring.getWeirdString());
	}

}
