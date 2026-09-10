# Enigma Machine

A small Java implementation of an Enigma-style machine. It loads rotor, plugboard, and reflector wiring from CSV files, encrypts a message, then runs the result through a second machine with the same settings to demonstrate decryption.

## Run on Windows

Install a Java Development Kit (JDK) and ensure `java` and `javac` are available on your PATH.

Open PowerShell in this project's `enigmamachine` folder and compile the source:

```powershell
javac -d out src/enigma/machine/fun/*.java
```

Run the demo from the project folder so the CSV configuration files can be found:

```powershell
java -cp out enigma.machine.fun.Runner
```

## Configuration

The demo uses `rotor_1.csv`, `rotor_2.csv`, `rotor_3.csv`, `plugboard.csv`, and `reflector.csv` from the project folder. The rotor order and starting positions are configured in `src/enigma/machine/fun/Runner.java`. The included wiring is illustrative and does not claim to reproduce a historical Enigma configuration.

## Source Code

- `Runner.java` — Builds matching encoder and decoder machines and runs the sample message.
- `EnigmaMachine.java` — Processes characters through the plugboard, rotors, reflector, and return path.
- `Rotor.java` — Loads rotor wiring and advances rotor positions.
- `Plugboard.java` — Loads character mappings.
- `AlphabetLoader.java` — Reads CSV mappings.
