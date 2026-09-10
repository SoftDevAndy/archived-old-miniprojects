package enigma.machine.fun;

public class EnigmaMachine {
		
	private Plugboard plugboard;
	private Plugboard reflector;
	private Rotor leftRotor;
	private Rotor middleRotor;
	private Rotor rightRotor;
	private int ROTOR_SIZE = 26;
	
	public EnigmaMachine(){};

	public EnigmaMachine(Rotor leftRotor, Rotor middleRotor, Rotor rightRotor,Plugboard plugBoard, Plugboard reflector) {
		this.plugboard = plugBoard;
		this.leftRotor = leftRotor;
		this.middleRotor = middleRotor;
		this.rightRotor = rightRotor;
		this.reflector = reflector;
	}
	
	public String encodeMessage(String message){
		
		StringBuffer sb = new StringBuffer();
		
		for(Character a : message.toCharArray()){
			
			// For each letter of the message (keypress in the enigma machine)
			
			Character c;
			
			if(a <= 90 && a >= 65) // Making sure the letter is alphabetical
			{						
				c = Character.toUpperCase(a);	
				
				// Convert it to uppercase
				
				if(plugboard.isPlugCharacter(c))
					c = plugboard.getPlugCharacter(c);
				
				// Check if the plugboard has this character, if it does return the mapping
				
				c = rightRotor.encode(c,true);	
				c = middleRotor.encode(c,true);				
				c = leftRotor.encode(c,true);	
				
				// Encode the letter on its way through each rotor until it reaches the reflector
				
				c = reflector.getPlugCharacter(c);	
				
				// Encode the letter using the mapped characted on the reflector
				
				c = leftRotor.encode(c,false);			
				c = middleRotor.encode(c,false);			
				c = rightRotor.encode(c,false);
				
				// Encode the letter on its way BACK through each rotor
				
				if(plugboard.isPlugCharacter(c))
					c = plugboard.getPlugCharacter(c);
				
				// Again check if the plugboard has this character
											
				sb.append(c);
				
				// Append the encrypted character to the message
				
				rightRotor.shiftOne();
				
				// Each keypress/character turns the right rotor 1 shift always
				
				if(rightRotor.getPosition() == ROTOR_SIZE){
					middleRotor.shiftOne();
					
					// Each time the right rotor completes a full rotation the middle rotor shifts one
				}
				
				if(middleRotor.getPosition() == ROTOR_SIZE){
					leftRotor.shiftOne();
					
					// Each time the middle rotor completes a full rotation the left rotor shifts one
				}
			}	
		}
		
		return sb.toString();
	}
}
