# Pathfinding

> **Commercial license required:** You need a commercial Vectrosity license to run this project. Supply your own licensed copy of Vectrosity before compiling or running it in Unity.

A Unity and C# experiment exploring A* pathfinding on a randomly generated grid. The demo places obstacles, selects start and finish positions, and draws the resulting route as a blue line using Vectrosity.

## Features

- Generates a 15 x 15 grid with up to 25 obstacles.
- Selects random, unblocked start and finish positions.
- Searches between neighbouring tiles in four directions.
- Displays the calculated route in the scene.

## Run on Windows

The project records Unity **5.5.2f1** as its editor version.

1. Open the `pathfinding` folder as a Unity project on Windows.
2. Import your licensed copy of Vectrosity.
3. Open `Assets/main.unity`.
4. Enter Play mode to generate a grid and display the path.
5. Stop and restart Play mode to generate another layout.

Compatibility with newer Unity and Vectrosity versions has not been verified.

## Source Code

- `Assets/Scripts/Main.cs` — Grid generation, start and finish placement, path search, and line drawing.
- `Assets/Scripts/Node.cs` — Node coordinates, neighbours, search scores, and parent references.

## Implementation Note

This is an archived learning project based on A* pseudocode. The method named `heuristicManhattan` adds signed coordinate differences rather than their absolute values, so it does not calculate standard Manhattan distance. The original implementation is preserved.

## Credits

- A* pseudocode from Wikipedia inspired the search implementation.
- Vectrosity is used to draw the path.
