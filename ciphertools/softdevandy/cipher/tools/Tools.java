package softdevandy.cipher.tools;

import java.util.HashMap;

/**
* <h1>Tools</h1>
* A class for handy tools that may help with ciphers.
* @author Andy
* @version 1.0
*/
public class Tools {
		
	/**
	 * Returns a frequency table of letters in with given plaintext.
	 *  @param plaintext String for plaintext or ciphertext. 
	 *  @return Returns a frequency table.
	 */	
	public String alphabetFrequency(String plaintext){
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>(); 
		
		for(Character c : plaintext.toUpperCase().toCharArray()){
			
			if(c != ' ' && Character.isLetter(c)){
			
				if(hm.containsKey(c)){				
					int val = hm.get(c) + 1;
					hm.replace(c, val);				
				}
				else
					hm.put(c, 1);
			}
		}
		
		return hm.toString();
	}
}
