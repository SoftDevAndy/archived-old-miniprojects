package softdevandy.cipher.tools;
import java.util.ArrayList;
import java.util.List;

/**
* <h1>Vigenere Cipher</h1>
* Simple Java implementation of the Vigenere Cipher.
* @author Andy
* @version 1.0
*/

public class VigenereEncrypter {
	
	private final int ALPHABETSIZE = 26;	
	private final int MINASCII = 65;
	private final int MAXASCII = 90;
	
	private List<String> vigenereSquare;
	
	/**
	 * Decrypts ciphertext using the Vigenere Cipher
	 * More info on Vigenere Cipher here @see <a href="https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher">Wikipedia Link</a>
	 * 
	 *  @param keyword Required when encrypting.
	 *  @param ciphertext String Encrypted ciphertext.
	 *  @return Returned Unencrypted String using the Vigenere Cipher.
	 */
	public String decryptText(String keyword, String ciphertext){
		
		StringBuffer encodedText = new StringBuffer();
		StringBuffer codexStr = buildCodexString(keyword, ciphertext);
		
		int i = 0;
		
		for(Character a : ciphertext.toCharArray()){
			
			Character r;
			Character b = codexStr.charAt(i);
			int x;
			
			x = (int)(a - b);
			
			if(x < 0){
				x = (MAXASCII + 1) + x;
				r = (char)x;
			}
			else
				r = (char)(x + MINASCII);
			
			encodedText.append(r);
			
			i++;
		}
		
		return encodedText.toString();
	}
	
	/**
	 * Encrypts plaintext using the Vigenere Cipher
	 * More info on Vigenere Cipher here @see <a href="https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher">Wikipedia Link</a>
	 * 
	 *  @param keyword Required when encrypting.
	 *  @param ciphertext String Encrypted ciphertext.
	 *  @return Returned Encrypted String using the Vigenere Cipher.
	 */
	public String encryptText(String keyword, String ciphertext){
		
		StringBuffer encodedText = new StringBuffer();		
		StringBuffer codexStr = buildCodexString(keyword, ciphertext);
		
		int i = 0;
		
		for(Character a : ciphertext.toUpperCase().toCharArray()){
			
			if(Character.isLetter(a)){
			
				Character b = codexStr.charAt(i);
				int x = (int)(b - MINASCII);
				int y = (int)(a - MINASCII);
				
				Character encodedChar = getVigenereSquareChar(x,y);				
				encodedText.append(encodedChar);				
				i++;
			}
			
		}
		
		return encodedText.toString();
	}
		
	private Character getVigenereSquareChar(int x, int y){
		
		if(vigenereSquare == null)
			createVigenereSquare();
		
		return vigenereSquare.get(x).charAt(y);
	}
	
	private StringBuffer buildCodexString(String keyword, String cipherIn){
		
		/* Creates the codex string for the vigenere square e.g
		 * 
		 * e.g keyword the keyword is 'KEY' and the cipherText is 'IMPORTANTMESSAGE'
		 * 'KEYKEYKEYKEYKEYK' is repeated for the same amount of letters of the cipherText
		 * 'IMPORTANTMESSAGE'
		 */
		
		StringBuffer sb = new StringBuffer();
		StringBuffer cipherText = new StringBuffer();
		
		String cleanKey = "";
		
		for(Character c : keyword.toUpperCase().toCharArray()){
			
			if(Character.isAlphabetic(c)){
				cleanKey = c + "";
			}
		}
		
		keyword = cleanKey;
		
		for(Character c : cipherIn.toUpperCase().toCharArray()){
			
			if(Character.isLetter(c))
				cipherText.append(c);
		}
		
		int keyCount = (cipherText.length() / keyword.length());
		int difference = cipherText.length() - (keyCount * keyword.length());
			
		for(int i = 0; i < (int)keyCount; i++){
			sb.append(keyword);
		}
		
		for(int i = 0; i < difference; i++){
			sb.append(keyword.charAt(i));
		}	
		
		return sb;
	}	
	
	private void createVigenereSquare(){
		
		/* Creates the VigenereSquare
		 *
		 * ABC -> XYZ
		 * BCD -> YZA
		 * CDE -> ZAB etc
		*/
		
		StringBuffer sb;		
		Character c;
		
		int i = 0;
		
		vigenereSquare = new ArrayList<String>();
		
		while(i < ALPHABETSIZE){
		
			sb = new StringBuffer();
			
			for(int j = (MINASCII + i); j <= (MAXASCII + i); j++){
				
				if(j > MAXASCII)
					c = (char)((j - MAXASCII) + (MINASCII - 1));
				else
					c = (char)j;
				
				sb.append(c);
			}
			
			vigenereSquare.add(sb.toString());
			
			i++;
	    }
	}

	/* Singleton */
	
	private static VigenereEncrypter instance = null;
	private VigenereEncrypter(){}
	public static VigenereEncrypter getInstance(){
		if(instance == null)
			instance = new VigenereEncrypter();
		return instance;
	}	
}
