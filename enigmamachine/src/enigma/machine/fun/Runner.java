package enigma.machine.fun;

public class Runner {
	
	public static void main(String[] args) {
		new Runner();
	}
	
	public Runner(){
		
		EnigmaMachine enigmaEncode = new EnigmaMachine(
												   new Rotor("rotor_1.csv",1),
												   new Rotor("rotor_2.csv",5),
				   								   new Rotor("rotor_3.csv",7),
												   new Plugboard("plugboard.csv"),
												   new Plugboard("reflector.csv"));
		
		EnigmaMachine enigmaDecode = new EnigmaMachine(
			       new Rotor("rotor_1.csv",1),
				   new Rotor("rotor_2.csv",5),
				   new Rotor("rotor_3.csv",7),
				   new Plugboard("plugboard.csv"),
				   new Plugboard("reflector.csv"));		
		
		// Creating 2 Enigma Machines, with rotars in the same order, same plugboard and reflector
		// This simulates encrypting and decrypting the enigma machine codes
		
		String message = "thequickbrownfoxjumpsoverthelazydog";
		
		// Our message to encrypt
		
		/* Program */
		
		System.out.println("Before:  " + message);
		
		// Showing the original message
		
		message = enigmaEncode.encodeMessage(message);		
		System.out.println("Encoded: " + message);
		
		// Encrypting the message with one machine
		
		message = enigmaDecode.encodeMessage(message);		
		System.out.println("Decoded: " + message);
		
		// Using a machine with the same message and decrypting the message
	}
}
