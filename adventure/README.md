# Adventure

A small text adventure I built during my first year of college to get a head start with Java and explore objects and classes. It is a simple early project, but it was fun to make.

Explore a locked room, examine objects, and find all four parts of the combination needed to escape.

## Run on Windows

Install a Java Development Kit (JDK) and ensure `java` and `javac` are available on your PATH.

Open PowerShell in this project's `adventure` folder and compile the source:

```powershell
javac -d out *.java
```

Start the game:

```powershell
java -cp out ie.gmit.adventure.TextBasedAdventureGame
```

## How to Play

Type a command and press Enter. Commands are not case-sensitive.

| Command | Action |
| --- | --- |
| `LEFT`, `RIGHT`, `BACK`, `FRONT`, `FLOOR`, `CEILING` | Change your view of the room. |
| `ACTION` | Examine an object by entering its name when prompted. |
| `INVENTORY` | Check which parts of the combination you have found. |
| `WHERE` | Repeat the description of your current view. |
| `LOCK` | Try to escape once you have found all four parts. |
| `HELP` | Display the instructions. |
| `QUIT` | Leave the game. |

## Source Code

- `TextBasedAdventureGame.java` — Entry point and command handling.
- `Rooms.java` — Tracks the current view of the room.
- `RoomControl.java` — Displays the description for the current view.
- `Action.java` — Handles interactions with objects.
- `Items.java` — Object descriptions and clues.
- `Discriptions.java` — Story text, help, and inventory display.
