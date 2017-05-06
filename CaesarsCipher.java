
import java.util.Scanner;
public class CaesarsCipher {
	
	/*                        
		Create a class CaesarsCipher that performs the ciphering/deciphering on plain text as described by the Ceacar's cipher (symbols and numbers kept the same )).
		This class should have the following two methods:
		String cipher(String message, int numOfShifts) - ciphers and returns the given message (with the given numOfShifts)
		String decipher(String cipherText, int numOfShifts) - deciphers and returns the given message (with the given numOfShifts)
		Create a TestCaesar class and test the functionality of your CaesarsCipher class
	*/
	
	//variables
	public String yourText; 
	static Scanner scanner = new Scanner(System.in);
	static String numberInput ="";
	static String numberInputOther ="";
	
	//method for validating that string can be converted to int
	static boolean validator (String proxy) {
		boolean validate = false;
		try {
			int z = Integer.parseInt(proxy);
			validate = true;
		} catch ( NumberFormatException e) {
			validate = false;
		}
		return validate;
	}
	
	//method for ciphering
	public static String cipher( String message, int numOfShifts) {
		char[] inputArray = message.toCharArray();
		Character[] inputArrayConverted = new Character[inputArray.length];
		Character[] StaticAlphabetArray = new Character[] { 'a' , 'b' , 'c' , 'd'  ,'e' , 'f' , 'g' , 'h' , 'i' , 'j' , 'k' , 'l' , 'm' , 'n' , 'o' , 'p' , 'q' , 'r' , 's' , 't' , 'u' , 'v', 'w' , 'x' , 'y' , 'z' };
		Character[] StaticAlphabetCapsArray = new Character[] { 'A' , 'B' , 'C' , 'D'  ,'E' , 'F' , 'G' , 'H' , 'I' , 'J' , 'K' , 'L' , 'M' , 'N' , 'O' , 'P' , 'Q' , 'R' , 'S' , 'T' , 'U' , 'V', 'W' , 'X' , 'Y' , 'Z' };
		Character[] alphabetArray = new Character[] { 'a' , 'b' , 'c' , 'd'  ,'e' , 'f' , 'g' , 'h' , 'i' , 'j' , 'k' , 'l' , 'm' , 'n' , 'o' , 'p' , 'q' , 'r' , 's' , 't' , 'u' , 'v', 'w' , 'x' , 'y' , 'z' };
		Character[] alphabetCapsArray = new Character[] { 'A' , 'B' , 'C' , 'D'  ,'E' , 'F' , 'G' , 'H' , 'I' , 'J' , 'K' , 'L' , 'M' , 'N' , 'O' , 'P' , 'Q' , 'R' , 'S' , 'T' , 'U' , 'V', 'W' , 'X' , 'Y' , 'Z' };

		// if number of shifts > 26  produce the modulo to be used instead
		int modNumOfShifts = numOfShifts % 26;
		
		//find the array that represents the alphabet shifted by the modulo times the user said
		for ( int i = 0; i < modNumOfShifts; i++) {
			char dump = alphabetArray[25];
			char dumpCaps = alphabetCapsArray[25];
			for ( int n = 24; n >= 0; n-- ) {
				alphabetArray[n+1] = alphabetArray[n];
				alphabetCapsArray[n+1] = alphabetCapsArray[n];
			}
			alphabetArray[0] = dump;
			alphabetCapsArray[0] = dumpCaps;

		}
		
		//convert the char type to Character class
		for( int i=0; i < inputArray.length; i++) {
			inputArrayConverted[i] = Character.valueOf(inputArray[i]);
		}
			
		// finally swap the elements 
		for( int i=0; i < inputArrayConverted.length; i++) {
			boolean breaker = true;
		    for (int a = 0; a <= 25 && breaker == true; a++ ) {
		    	if ( inputArrayConverted[i].equals(alphabetArray[a]) ) {
		    		inputArrayConverted[i] = StaticAlphabetArray[a];
		    		breaker = false;
		    	}
		    	if ( Character.isUpperCase(inputArrayConverted[i] ) == true ){
		    		if ( inputArrayConverted[i].equals(alphabetCapsArray[a]) ) {
			    		inputArrayConverted[i] = StaticAlphabetCapsArray[a];
			    		breaker = false;
			    	}
		    	}
		    }
		}
		
		//make the inputArray chars a string again
		StringBuilder sb = new StringBuilder();
		for( int i=0; i < inputArrayConverted.length; i++) {
			sb.append(inputArrayConverted[i]);
		}
		return sb.toString();
	}
	
	//decipher is a cipher of a 26 - numofshifts shift
	public static String decipher( String message, int numOfShifts) {
		return cipher( message, 26 - numOfShifts );
	}


	public static void main(String[] args) {
		
		// taking the string for ciphering
		System.out.print("Enter text to be ciphered:");
		String stringInput = scanner.nextLine();
		
		//taking the number of shifts
		while (validator(numberInput) == false ) {
			System.out.println("Enter the number of shifts you would like to use to cipher your text (input must be integer):");
			numberInput = scanner.nextLine();
		}
		int z = Integer.parseInt(numberInput);
		
		//ciphering the text
		System.out.println(cipher( stringInput , z ));
		
		// taking the string for deciphering
		System.out.print("Enter text to be deciphered:");
		stringInput = scanner.nextLine();
				
		//taking the number of shifts
		while (validator(numberInputOther) == false ) {
			System.out.println("Enter the number of shifts you would like to use to cipher your text (input must be integer):");
			numberInputOther = scanner.nextLine();
		}
		z = Integer.parseInt(numberInputOther);
		
		//deciphering the text
		System.out.println(decipher( stringInput , z ));
		
		
	}

}
