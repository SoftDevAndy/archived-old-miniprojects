# Map Editor

A small Java desktop map editor built for a game prototype. Create maps using floor and wall tiles, then export both a PNG image and a text file containing the map's 2D tile array.

## Features

- Edit maps on a 64 x 64 grid.
- Choose from the included tile sets.
- Import previously exported text maps.
- Export maps as PNG images and text files.
- Toggle the grid overlay or reset the map.

## Setup

Install a Java Development Kit (JDK) and ensure `java` and `javac` are available on your PATH.

From this project's `mapeditor` folder, compile the source:

```sh
javac -d out src/myCustCreator/*.java
```

Run on Windows:

```sh
java -cp "out;src" myCustCreator.ourWindow
```

Run the application from the `mapeditor` folder so it can locate `src/Images`. Keep the `Map` folder in place for exports.

## Using the Editor

- Choose a tile set from **Tile Menu**.
- Use **File > Import** to load a saved text map.
- Use **File > Export** to save the map image and tile data in a timestamped subfolder of `Map/`.
- Use **Options** to toggle the grid or reset the map.
- Open **About > How To** for the editor's built-in instructions.

## Project Layout

- `src/myCustCreator/` — Java source code.
- `src/Images/` — Tile images used by the editor.
- `Map/` — Exported maps, including an example map.
