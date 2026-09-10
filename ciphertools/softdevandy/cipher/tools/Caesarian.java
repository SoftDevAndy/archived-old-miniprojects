package softdevandy.cipher.tools;

import java.util.ArrayList;
import java.util.List;

/**
* <h1>Caesarian Cipher or ROT-n Cipher</h1>
* Simple Java implementation of the ROT-n Cipher.
* @author Andy
* @version 1.0
*/
public class Caesarian {

	/**
	 * Encrypts plaintext using the ROT-n cipher. 
	 * e.g Hello encrypts to "URYYB"
	 * More info on AtBash here @see <a href="https://en.wikipedia.org/wiki/ROT13">Wikipedia Link</a>
	 * 
	 *  @param shift Number of shifts you which to shift the caesar alphabet by. e.g 13 for the standard Rot-13 Cipher.
	 *  @param plaintext String you want to encrypt using the ROT-n cipher.
	 *  @return Returned Encrypted String using the ROT-N cipher.
	 */	
	public String encrypt(int shift, String plaintext){
				
		List<Character> originalAlphabet = new ArrayList<Character>();
		List<Character> caesarAlphabet = new ArrayList<Character>();
						
		for(int i = 1; i < 27; i++)			
			originalAlphabet.add((char)(64 + i));
		
		// Creating an alphabet character list A->Z
		
		int startPosition;		
		int count = 0;
		
		if(shift != 0)		
			startPosition = 64 + shift;
		else 
			startPosition = 64;
				
		int positionMarker = startPosition;
		
		// Takes a position to start the shifted alphabet at
		
		while(count < 26){
			
			if(positionMarker > 90)
				positionMarker = 65;
			
			caesarAlphabet.add((char)(positionMarker));
						
			++positionMarker;
			++count;
		}
		
		// Builds the shifted alphabet
						
		StringBuffer cipherText = new StringBuffer();
		
		for(Character c : plaintext.toCharArray()){
								
			if(Character.isAlphabetic(c)){
			
				int pos = Character.toUpperCase(c) - 64;
								
				if(pos < 26 && pos >= 0)
					cipherText.append(caesarAlphabet.get(pos));
				else if(pos == 26)
					cipherText.append(caesarAlphabet.get(0));
				else
					cipherText.append(" ");
			}
			else
				cipherText.append(" ");
		}
		
		// Foreach letter of the alphabet, find the matching letter in the shifted alphabet and append it.
		
		return cipherText.toString();
	}
	
	/* Singleton */
	
	private static Caesarian instance = null;
	private Caesarian(){}
	public static Caesarian getInstance(){
		if(instance == null)
			instance = new Caesarian();
		return instance;
	}	
}
