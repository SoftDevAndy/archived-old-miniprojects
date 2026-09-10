package enigma.machine.fun;

import java.util.LinkedHashMap;

public class Rotor {
	
	private LinkedHashMap<Character,Character> alphabet = new LinkedHashMap<Character,Character>();
	private int rotorPosition = 0;
	private int ROTOR_SIZE = 26;
	
	public Rotor(String filelocation){
		
		// Reading in the from the csv file and creating the rotor at a default position 0
		
		AlphabetLoader alphaLoader = new AlphabetLoader();		
		this.alphabet = alphaLoader.loadAlphabet(filelocation);
		
		this.rotorPosition = 0;
	}
	
	public Rotor(String filelocation, int startPosition){
		
		if(startPosition > ROTOR_SIZE || startPosition < 0)
			startPosition = 0;
		
		// Reading in the from the csv file
		// If the start position is bad.. set it to 0
		// Rotates the rotor alphabet to the proper position
		
		AlphabetLoader alphaLoader = new AlphabetLoader();		
		this.alphabet = alphaLoader.loadAlphabet(filelocation);
				
		setStartPosition(startPosition);
	}
	
	public void shiftOne(){
		
		LinkedHashMap<Character,Character> temp = new LinkedHashMap<Character,Character>();
		Character a,b;
		
		// If the rotor has made a full rotation, reset it back to 0
		// Otherwise rotate it
		
		if(rotorPosition == ROTOR_SIZE)
			rotorPosition = 0;
		else				
			rotorPosition++;
		
		
		// Moves the mapping of the alphabet by one shift in the LinkedHashMap
		// e.g A->F, B-G will be A->Z, B->F 
		
		for(int i = 0; i < alphabet.size(); i++){
			
			a = getByIndex(i);
			
			if((i + 1) == alphabet.size())
				b = getByValue(0);
			else			
				b = getByValue(i + 1);
			
			temp.put(a,b);
		}
				
		this.alphabet = temp;
	}
	
	public void setStartPosition(int startPosition){
		
		// Shift the alphabet by n shifts based off the start position
		
		for(int i = 0; i < startPosition; i++){
			shiftOne();
		}
	}
	
	public int getPosition(){
		return this.rotorPosition;
	}
		
	public Character encode(Character c, boolean flag){
		
		// A little tricky...
		// If the flag is true we are encrypting on the way FORWARD to the reflector.
		// If the flag is false we are encrypting on the way BACK from the reflector.
		
		if(flag)		
			return this.alphabet.get(c);
		else{
			int pos = 0;
			int count = 0;
			
			for(Character a : this.alphabet.keySet()){
				
				Character t = this.alphabet.get(a);
				
				if(t == c)
					pos = count;
				
				++count;
			}
			
			return getByIndex(pos);
		}
	}
	
	public LinkedHashMap<Character, Character> getAlphabet(){
		return this.alphabet;
	}
	
	public Character getByValue(int index){
		   return (Character)this.alphabet.values().toArray()[index];
	}
	
	public Character getByIndex(int index){
		   return (Character)this.alphabet.keySet().toArray()[index];
	}
}