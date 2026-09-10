package softdevandy.cipher.tools;

import java.util.HashMap;

/**
* <h1>Substitution Cipher</h1>
* Substitution Cipher a simple implementation.
* @author Andy
* @version 1.0
*/
public class SubCipher {
	
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String mixedalphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	HashMap<Character, Character> hm;
	
	/**
	 * Returns a String encrypted using a Substitution cipher.
	 * e.g "BHAJWKMYFVSXRNPZEQLUGIDCOT" "The quick brown fox jumps over the lazy dog." gives "UYW EGFAS HQPDN KPC VGRZL PIWQ UYW XBTO JPM"
	 * More info here @see <a href="https://en.wikipedia.org/wiki/Substitution_cipher">Wikipedia Link</a>
	 *  @param mixedalphabet An alphabet of jumbled letters required for encryption.
	 *  @param plaintext String that will get encrypted with Substitution cipher.
	 *  @param encoding True encrypts the text, False unencrypts the text.
	 *  @return Returns the encrypted text.
	 */	
	public String encrypt(String mixedalphabet, String plaintext, boolean encoding){
		
		this.mixedalphabet = mixedalphabet;
		hm = new HashMap<Character, Character>();
	
		if(mixedalphabet.length() == alphabet.length()){
		
			StringBuffer ciphertext = new StringBuffer();		
			int index = 0;
			
			for(Character c : alphabet.toCharArray()){	
				
				if(encoding)				
					hm.put(c, mixedalphabet.charAt(index));
				else
					hm.put(mixedalphabet.charAt(index), c);
				
				index++;
			}
		
			for(Character c : plaintext.toUpperCase().toCharArray()){
				
				if(Character.isLetter(c))				
					ciphertext.append(hm.get(Character.toUpperCase(c)));
				else
					ciphertext.append(" ");
			}
			
			return ciphertext.toString();
		}
		else
			return "Alphabet isn't a standard size of " + alphabet.length();		
	}
	
	/* Singleton */
	
	private static SubCipher instance = null;
	private SubCipher(){}
	public static SubCipher getInstance(){
		if(instance == null)
			instance = new SubCipher();
		return instance;
	}
}
