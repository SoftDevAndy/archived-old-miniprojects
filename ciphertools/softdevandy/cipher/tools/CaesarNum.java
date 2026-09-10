package softdevandy.cipher.tools;

/**
* <h1>Caesar Number Cipher</h1>
* Simple Java implementation of the Text to Number Substitution cipher.
* @author Andy
* @version 1.0
*/
public class CaesarNum {
	
	/**
	 * Encrypts plaintext to numbers. 
	 * e.g ABC encrypts to "123"
	 * More info on text to number here @see <a href="https://en.wikipedia.org/wiki/Substitution_cipher">Wikipedia Link</a>
	 * 
	 *  @param plaintext String you want to convert to numbers.
	 *  @return Returned Encrypts String using the text to number substitution cipher.
	 */	
	public String encrypt(String plaintext){
		
		StringBuilder ciphertext = new StringBuilder();
		
		int pos = 1;
		
		for(Character c : plaintext.toUpperCase().toCharArray()){			
			
			pos++;
			
			if(Character.isLetter(c)){
				
				ciphertext.append(((int)c - 64));
				
				if(pos < plaintext.length())
					 ciphertext.append(",");			
			}
		}
		
		// Foreach letter in plaintext, find the alphanumeric version. e.g A = 1
		
		return ciphertext.toString();
	}
	
	/* Singleton */
	
	private static CaesarNum instance = null;
	private CaesarNum(){}
	public static CaesarNum getInstance(){
		if(instance == null)
			instance = new CaesarNum();
		return instance;
	}
}
