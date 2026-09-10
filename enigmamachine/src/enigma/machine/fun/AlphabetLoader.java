package enigma.machine.fun;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public class AlphabetLoader {
	
	// Basic CSV reader, Read in the file, given the file location/name
	// Each line maps one letter to another e.g C,A
	// Take character 0,2 ignoring the comma and put it in a map.
	
	public LinkedHashMap<Character, Character> loadAlphabet(String filelocation){
		try (BufferedReader br = new BufferedReader(new FileReader(filelocation))) {

			String line;
			
			LinkedHashMap<Character, Character> alphabet = new LinkedHashMap<>();
		
			while ((line = br.readLine()) != null) {
				alphabet.put(line.charAt(0), line.charAt(2));
			}
			
			return alphabet;

		}catch(IOException e){e.printStackTrace();}		
		
		return null;
	}
}
