# Beale Cipher

A small Java project for exploring the numbers in the Beale ciphers. It reads cipher data from CSV files, counts how often each number appears, and prints a frequency table.

I am skeptical of the treasure story, but the ciphers made an interesting starting point for experimenting with parsing and frequency analysis.

## Run on Windows

Install a Java Development Kit (JDK) and ensure `java` and `javac` are available on your PATH.

Open PowerShell in this project's `bealecipher` folder and compile the source:

```powershell
javac -d out src/com/beal/solve/*.java
```

Run the analysis:

```powershell
java -cp out com.beal.solve.Runner
```

Run from the `bealecipher` folder so the program can find the CSV files.

## Input and Output

By default, the program reads `paper1_exactlocation.csv` and prints each number alongside its occurrence count, ordered by frequency from highest to lowest.

Three data files are included:

- `paper1_exactlocation.csv`
- `paper2_alreadydecrypted.csv`
- `paper3_heirsoftreasure.csv`

To analyse another file, change the filename passed to `readCSV` in `src/com/beal/solve/Runner.java`, then recompile and run. The program counts number frequencies; it does not decrypt the ciphers.

## Source Code

- `Runner.java` — Entry point and frequency counting.
- `CSVReader.java` — Parses comma-separated integers.
- `Printer.java` — Prints frequency tables and provides a helper for writing number lists to a file.
- `ValueComparator.java` — Compares numbers by their frequency counts.
- `Tools.java` — Provides a helper for building a sorted frequency map.

All Java source files are in `src/com/beal/solve/`.

## Background

Read more about the story in the [Beale ciphers overview](https://en.wikipedia.org/wiki/Beale_ciphers).
