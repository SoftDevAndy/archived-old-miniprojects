# Cipher Tools

A collection of Java command-line tools I built while exploring cryptography, particularly the Vigenere cipher. It includes classical ciphers, Base64 encoding and decoding, and basic frequency-analysis tools.

## Run on Windows

Install Java 8 or later and ensure `java` is available on your PATH.

Open PowerShell in this project's `ciphertools` folder and display the included JAR's help:

```powershell
java -jar cipher.jar -HELP
```

Command names are not case-sensitive. Put text containing spaces inside double quotes.

## Commands

Use `java -jar cipher.jar` followed by one of these commands:

| Command | Purpose |
| --- | --- |
| `-ENCODEBASE64 "text"` | Encode text as Base64. |
| `-DECODEBASE64 "encoded text"` | Decode Base64 text. |
| `-ENCODEVIGENERE key "text"` | Encrypt with a Vigenere key. |
| `-DECODEVIGENERE key "ciphertext"` | Decrypt with a Vigenere key. |
| `-SUBENCODE alphabet "text"` | Encrypt with a substitution alphabet. |
| `-SUBDECODE alphabet "ciphertext"` | Decrypt with the same substitution alphabet. |
| `-ATBASH "text"` | Apply the Atbash substitution. |
| `-CAESAR shift "text"` | Apply a Caesar shift. |
| `-CAESARNUM "text"` | Convert letters to numbers from 1 to 26. |
| `-POLY "text" [startletter]` | Encode with a Polybius square; optionally change the paired letters. |
| `-IOC "text"` | Calculate the index of coincidence. |
| `-FRIEDKEY "ciphertext"` | Estimate key length using the Friedman calculation. |
| `-FREQ "text"` | Count letter frequencies. |

For substitution commands, supply a shuffled alphabet containing each letter A-Z once. Polybius pairs I/J by default; supplying `A` pairs A/B instead. The Polybius command supports encoding only.

## Examples

```powershell
# Base64
java -jar cipher.jar -ENCODEBASE64 "Hello"
java -jar cipher.jar -DECODEBASE64 "SGVsbG8="

# Vigenere
java -jar cipher.jar -ENCODEVIGENERE key "This is my phrase"

# Atbash and Caesar (ROT13)
java -jar cipher.jar -ATBASH "HELLO"
java -jar cipher.jar -CAESAR 13 "HELLO"

# Substitution
java -jar cipher.jar -SUBENCODE "BHAJWKMYFVSXRNPZEQLUGIDCOT" "HELLO"

# Polybius
java -jar cipher.jar -POLY "JUICE"

# Frequency analysis
java -jar cipher.jar -FREQ "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"
java -jar cipher.jar -IOC "RFGQGQKWNFPYQCRFYRUGJJECRCLAMBCB"
java -jar cipher.jar -FRIEDKEY "RFGQGQKWNFPYQCRFYRUGJJECRCLAMBCB"
```

## Compile from Source

Install a JDK with `javac` available on your PATH. From the `ciphertools` folder:

```powershell
javac -d out softdevandy/cipher/tools/*.java
java -cp out softdevandy.cipher.tools.Runner -HELP
```

To use the compiled source, replace `java -jar cipher.jar` in the examples with `java -cp out softdevandy.cipher.tools.Runner`.

## Notes

- Text normalization varies by cipher; some operations remove spaces and punctuation or convert text to uppercase.
- The source's help lists `-FACTORS`, but its command handler does not implement it.
- The analysis commands provide statistics and estimates, not automatic decryption.

## Project Layout

- `cipher.jar` — Included executable JAR.
- `softdevandy/cipher/tools/` — Java source code.
- `doc/index.html` — Generated API documentation, which may differ from the current source.
