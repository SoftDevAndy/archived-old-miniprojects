# Pong

A two-player Pong game I built during my second year of college to learn Java's basic graphics and GUI libraries. It uses Java AWT and Swing, with sound effects for paddle hits, wall bounces, and scoring.

## Controls

Both players share the same keyboard.

| Action | Key |
| --- | --- |
| Player 1: move up | A |
| Player 1: move down | Z |
| Player 2: move up | P |
| Player 2: move down | L |
| Reset the game and scores | Spacebar |

## Run on Windows

Install a Java Development Kit (JDK) and ensure `java` and `javac` are available on your PATH.

Open PowerShell in this project's `pong` folder and compile the source:

```powershell
javac -d out *.java
```

Start the game:

```powershell
java -cp "out;." Pong
```

Keep the `Music` folder in the project folder. The run command includes the current folder on the classpath so the game can load its sound effects.

## Project Layout

- `Pong.java` — Application entry point and game window.
- `GamePanel.java` — Game panel, keyboard input, and scoring.
- `Ball.java` — Ball movement and collision handling.
- `PlayerOne.java` and `PlayerTwo.java` — Player paddles.
- `Music/` — Sound effects.
