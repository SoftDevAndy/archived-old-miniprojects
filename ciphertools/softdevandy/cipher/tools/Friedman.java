package softdevandy.cipher.tools;

import java.util.LinkedHashMap;

/**
* <h1>Friedman Analysis</h1>
* Friedman Analysis used in determining cipher types.
* @author Andy
* @version 1.0
*/
public class Friedman {

	private LinkedHashMap<Character, Integer> alphabetFrequencyTable;
	private final int ALPHA = 26;
	private final int ASCII = 65;
	private float MIN = 0.038f;
	private float MAX = 0.065f;
		
	/**
	 * Return the index of coincidence using Friedman's analysis.
	 * e.g "Dlgc mq zpysrrobr orayhcn" gives an index of 0.03896
	 * More info here @see <a href="https://en.wikipedia.org/wiki/Index_of_coincidence">Wikipedia Link</a>
	 * 
	 *  @param ciphertext String you want to get index of coincidence value from.
	 *  @return Returns the index of coincidence.
	 */	
	public float getIndexOfCoincidence(String ciphertext){
		
		alphabetFrequencyTable = buildAlphabetFrequencyTable(ciphertext);
		
		float nTotal = valueCount(alphabetFrequencyTable);
		float otherTotal = otherValueCount(alphabetFrequencyTable);		
		
		return otherTotal / (nTotal * (nTotal - 1));	
	}
	
	/**
	 * Returns an averaged key size based on ciphertext.
	 *  @param ciphertext Ciphertext to get an averaged key size from.
	 *  @return Returns a averaged keysize based on the ciphertext.
	 */	
	public float getKeysizeUsingFriedman(String ciphertext){
		
		alphabetFrequencyTable = buildAlphabetFrequencyTable(ciphertext);
		
		float indexOfCoincidence = getIndexOfCoincidence(ciphertext);		
		float nTotal = valueCount(alphabetFrequencyTable);		
		float a = 0.027f * nTotal;
		float b = (nTotal - 1) * indexOfCoincidence - MIN * nTotal + MAX;
				
		return a / b;
	}
	
	private LinkedHashMap<Character, Integer> buildAlphabetFrequencyTable(String ciphertext){

		LinkedHashMap<Character, Integer> alphabetFrequency = new LinkedHashMap<Character, Integer>();
		
		for(int i = 0; i < ALPHA; i++){
			Character letter = (char)(ASCII + i);			
			alphabetFrequency.put(letter, 0);
		}
		
		for(Character c : ciphertext.toCharArray()){
					
			c = Character.toUpperCase(c);
			
			int incrementOne = alphabetFrequency.get(c);
			incrementOne++;
			
			alphabetFrequency.put(c, incrementOne);		
		}
		
		return alphabetFrequency;
	}
	
	private int valueCount(LinkedHashMap<Character, Integer> frequencyTable){
		
		int total = 0;
		
		for(int x : frequencyTable.values())
			total += x;
		
		return total;
	}
	
	private int otherValueCount(LinkedHashMap<Character, Integer> frequencyTable){
		
		int total = 0;
		
		for(int x : frequencyTable.values()){
			
			if(x != 0)
				total += (x * (x - 1));
		}
		
		return total;
	}

	/* Singleton */
	
	private static Friedman instance = null;
	private Friedman(){}
	public static Friedman getInstance(){
		if(instance == null)
			instance = new Friedman();
		return instance;
	}
}
