package enigma.machine.fun;

import java.util.LinkedHashMap;

public class Plugboard {
	
	LinkedHashMap<Character,Character> plugboardAlphabet = new LinkedHashMap<Character,Character>();
	
	public Plugboard(String filelocation){
		
		AlphabetLoader alphaLoader = new AlphabetLoader();		
		plugboardAlphabet = alphaLoader.loadAlphabet(filelocation);
		
		// Loads in the plugboard where letters apply
	}
	
	// Checks whether the character is mapped using the plugboard
	
	public boolean isPlugCharacter(Character c){
		return this.plugboardAlphabet.containsKey(c);
	}
	
	// Gets the mapped character from the plugboard
	
	public Character getPlugCharacter(Character c){
		return this.plugboardAlphabet.get(c);
	}
}
