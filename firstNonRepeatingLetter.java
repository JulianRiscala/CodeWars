import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
public class prueba {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		sampleTests();
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos");
	}
  
    static void sampleTests() {
        assertEquals("a", Kata.firstNonRepeatingLetter("a"), "For input \"a\"");
        assertEquals("t", Kata.firstNonRepeatingLetter("streSS"), "For input \"streSS\"");
        assertEquals("-", Kata.firstNonRepeatingLetter("moon-men"), "For input \"moon-men\"");
        assertEquals("", Kata.firstNonRepeatingLetter("moonmoon"), "For input \"moonmoon\"");
    }

}

class Kata {
	public static String firstNonRepeatingLetter(String s){
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Convert the string to lowercase to handle case-insensitive comparison
        String lowerCaseString = s.toLowerCase();
        
        // Count the occurrences of each character in the string
        for (char c : lowerCaseString.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Find the first character with count 1 in the original string
        for (char c : s.toCharArray()) {
            if (charCount.get(lowerCaseString.charAt(s.indexOf(c))) == 1) {
                return String.valueOf(c);
            }
        }
        
        // If all characters are repeating, return an empty string
        return "";
	}
}


//Write a function named first_non_repeating_letter† that takes a string input, and returns the first character 
//that is not repeated anywhere in the string.
//
//For example, if given the input 'stress', the function should return 't', 
//since the letter t only occurs once in the string, and occurs first in the string.
//
//As an added challenge, upper- and lowercase letters are considered the same character, 
//but the function should return the correct case for the initial letter. For example, the input 'sTreSS' should return 'T'.
//
//If a string contains all repeating characters, it should return an empty string ("");
//
//† Note: the function is called firstNonRepeatingLetter for historical reasons, 
//but your function should handle any Unicode character.