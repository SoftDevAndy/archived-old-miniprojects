package softdevandy.cipher.tools;

import java.util.ArrayList;
import java.util.List;

/**
* <h1>Polybius Square Cipher</h1>
* Polybius Square Cipher a commonly used cipher.
* @author Andy
* @version 1.0
*/
public class Polybius {
	
	private final int defaultSize = 5;
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Character letterPosition = 'I';

	/**
	 * Returns a String encrypted using the Polybius square.
	 * e.g "JUICE" gives an "2445241315"
	 * More info here @see <a href="https://en.wikipedia.org/wiki/Polybius_square">Wikipedia Link</a>
	 *  @param plaintext String that will get encrypted with the default Polybius cipher.
	 *  @return Returns the encrypted text.
	 */	
	public String encrypt(String plaintext){
		
		List<StringBuilder> polySquare = buildPolySquare('I');		
		StringBuilder cipher = polyEncrypt(polySquare, plaintext);
		
		return cipher.toString(); 
	}
	
	/**
	 * Returns a String encrypted using the Polybius square.
	 * e.g "JUICE" gives an "2445241315"
	 * More info here @see <a href="https://en.wikipedia.org/wiki/Polybius_square">Wikipedia Link</a>
	 *  @param plaintext String that will get encrypted with the default Polybius cipher.
	 *  @param letter Replaces the default letter pairing in the Polybius square. e.g instead of I and J it can be Q and R.
	 *  @return Returns the encrypted text.
	 */	
	public String encrypt(String plaintext, Character letter){
		
		List<StringBuilder> polySquare = buildPolySquare(letter);		
		StringBuilder cipher = polyEncrypt(polySquare, plaintext);
		
		return cipher.toString(); 
	}

	private List<StringBuilder> buildPolySquare(Character letter){
		
		List<StringBuilder> polySquare = new ArrayList<StringBuilder>();
		
		if(letter != letterPosition)
			letterPosition = letter;
		
		for(int i = 0; i < defaultSize; i++)
			polySquare.add(new StringBuilder());
		
		int count = 0;
		int ignorePos = -1;
		
		for(int i =  0; i < polySquare.size(); i++){
			
			int j = 0;
			
			while(j < polySquare.size()){
								
				Character current = alphabet.charAt(count);
				
				if(letterPosition == current)
					ignorePos = count + 1;
				
				if(ignorePos != count){				
					StringBuilder col = polySquare.get(i);				
					col.append(current);
					j++;
				}	
				
				++count;
			}
		}
		
		return polySquare;
	}
	
	private StringBuilder polyEncrypt(List<StringBuilder> polySquare, String plaintext){
		
		StringBuilder cipher = new StringBuilder();
		
		for(Character c : plaintext.toUpperCase().toCharArray()){
			
			if(Character.isLetter(c)){
				
				int row = -1;
				int col = -1;
				
				for(int i =  0; i < polySquare.size(); i++){
					
					if(c == (letterPosition + 1))
						c = letterPosition;
					
					Character first = polySquare.get(i).charAt(0);
					Character last = polySquare.get(i).charAt(defaultSize - 1);
										
					if(withinRange(first ,last, c)){
						
						row = (i + 1);						
						
						for(int j = 0; j < polySquare.get(i).length(); j++){
							
							Character a = polySquare.get(i).charAt(j);
							
							if(a == c)
								col = (j + 1);
						}
					
						if(col != -1 && row != -1)
							cipher.append(row + "" + col);
						else
							cipher.append(" ");					
					}
				}
			}
		}
		
		return cipher;
	}
	
	private boolean withinRange(Character first, Character last, Character inQuestion){
		
		if(inQuestion >= first && inQuestion <= last)
			return true;
		
		return false;
	}
	
	/* Singleton */
	
	private static Polybius instance = null;
	private Polybius(){}
	public static Polybius getInstance(){
		if(instance == null)
			instance = new Polybius();
		return instance;
	}
}
