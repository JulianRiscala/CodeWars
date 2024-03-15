import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

public class prueba {

	public static void main(String[] args) {
		exampleTests();
	}
  
    static void exampleTests() {
        assertTrue(NumberUtils.isNarcissistic(153), "153 is narcissistic");
        assertTrue(NumberUtils.isNarcissistic(1634), "1634 is narcissistic");
        assertFalse(NumberUtils.isNarcissistic(112), "112 is not narcissistic");
    }

}

class NumberUtils {
  static boolean isNarcissistic(int number) {
	  int digits = (int) (Math.floor(Math.log10(Math.abs(number))) + 1);
	  int sum = 0;
	  int[] numberArray = new int[digits];
	  String numberString = String.valueOf(number);
	  for(int i = 0; i< numberString.length(); i++) {numberArray[i] = Character.getNumericValue(numberString.charAt(i));} // Array of every digit of 'number'
	  
	  for(int i = 0; i< digits; i++) {
		  int result = 1;
		  for(int j=0; j < digits;j++) {
			  result *= numberArray[i];
		  }
		  sum = sum + result;
	  }
	  
	  if (sum==number) {return true;}
      return false;
  }
}

//A Narcissistic Number (or Armstrong Number) is a positive number which is the sum of its own digits, each raised to the power of the number of digits in a given base. 
//In this Kata, we will restrict ourselves to decimal (base 10).
//
//For example, take 153 (3 digits), which is narcissistic:
//
//    1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
//and 1652 (4 digits), which isn't:
//
//    1^4 + 6^4 + 5^4 + 2^4 = 1 + 1296 + 625 + 16 = 1938
//The Challenge:
//
//Your code must return true or false (not 'true' and 'false') depending upon whether the given number is a Narcissistic number in base 10.
//
//This may be True and False in your language, e.g. PHP.
//
//Error checking for text strings or other invalid inputs is not required, only valid positive non-zero integers will be passed into the function.

//Otra manera
class NumberUtils2 {

    public static boolean isNarcissistic(int number) {
        String strNumber = String.valueOf(number);
        char[] digits = strNumber.toCharArray();
        int sum = 0;
        for(char digit : digits)
          sum += Math.pow(Integer.parseInt(String.valueOf(digit)), digits.length);
        return sum == number ? true : false;
    }

}
