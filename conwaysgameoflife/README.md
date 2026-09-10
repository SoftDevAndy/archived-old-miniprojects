# Conway's Game of Life

A Java implementation of John Conway's Game of Life. Paint cells on a grid, advance one generation at a time, or run the simulation continuously to watch patterns evolve.

## Run on Windows

Install a Java Development Kit (JDK) and ensure `java` and `javac` are available on your PATH.

The included JAR can be launched from PowerShell in this project's `conwaysgameoflife` folder:

```powershell
java -jar conway.jar
```

To compile from source instead:

```powershell
javac -d out src/conway/game/play/*.java
java -cp out conway.game.play.Display
```

## Using the App

The window contains a 50 x 50 grid and three controls:

- Click cells to toggle them between active and inactive.
- **Clear Grid** resets the board.
- **Step Through** advances the simulation by one generation.
- **Animate** starts the simulation; click it again to stop.

The simulation applies Conway's standard rules: live cells survive with two or three neighbours, dead cells are born with exactly three neighbours, and all other cells become or remain dead.

## Source Code

- `src/conway/game/play/Display.java` — Swing window and controls.
- `src/conway/game/play/Game.java` — Grid rendering, cell interaction, neighbour counting, and generation updates.

## Background

Learn more about [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life).
