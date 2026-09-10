package softdevandy.cipher.tools;

import java.util.HashMap;

/**
* <h1>AtBash Cipher</h1>
* Simple Java implementation of the AtBash Cipher.
* @author Andy
* @version 1.0
*/

public class AtBash {
	
	/**
	 * Encrypts plaintext to AtBash	 
	 * e.g Hello encrypts to "Svool"
	 * More info on AtBash here @see <a href="https://en.wikipedia.org/wiki/Atbash">Wikipedia Link</a>
	 * 
	 *  @param plaintext String you want to encrypt using the AtBash cipher.
	 *  @return Returned Encrypted String using the AtBash cipher.
	 */
	public static String encrypt(String plaintext){
		
		HashMap<Character, Character> hm = new HashMap<Character, Character>();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 1; i < 27; i++){		
			
			Character key = (char)(64 + i); 
			Character value = (char)(91 - i);			
			hm.put(key, value);
			
			// Adds KeyValue to the hashmap e.g A-Z,B-Y,C-X
			// The HashMap is our lookup table
		}
		
		for(Character c : plaintext.toUpperCase().toCharArray()){
			
			// Foreach character in our plaintext convert it to uppercase
			
			if(Character.isLetter(c))				
				sb.append(hm.get(c));
			
			// If the character is a letter, look up the hashmap and add the value otherwise ignore it
		}
		
		return sb.toString();
	}
	
	/* Singleton */
	
	private static AtBash instance = null;
	private AtBash(){}
	public static AtBash getInstance(){
		if(instance == null)
			instance = new AtBash();
		return instance;
	}	
}
