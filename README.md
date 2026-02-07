# Tile World Problem - Java Implementation

This project is a robust Java implementation of the **Tile World** problem. It simulates an intelligent agent capable of navigating through a procedurally generated maze to reach a specific target.

## 🚀 Features

* **Maze Generation**: Uses the *Recursive Backtracking* algorithm to ensure a perfect maze (every cell is reachable, no cycles).
* **Artificial Intelligence**:
    * `RandomAgent`: A basic agent used to test collisions and basic movement.
    * `AStarAgent`: An advanced agent using the **A*** (A-Star) algorithm with Manhattan distance heuristics to find the optimal path.
* **Console Visualization**: Real-time rendering in the terminal using ANSI escape codes for a smooth experience.

## 📁 Package Structure

The project follows a modular structure under the `fr.jeremy.tileworld` namespace:

* `fr.jeremy.tileworld.core`: Contains the world engine (`Grid`), tile definitions, and the maze generator.
* `fr.jeremy.tileworld.agents`: Contains interfaces and implementations of pathfinding algorithms (A*, Node logic).
* `fr.jeremy.tileworld.Main`: The entry point for the simulation.

## 🛠️ Algorithms Used

### 1. Pathfinding (A*)
The agent calculates its path by minimizing the following function: $$f(n) = g(n) + h(n)$$

Where:
* $g(n)$ is the cost of the path from the start node.
* $h(n)$ is the estimated cost to the target (Manhattan Distance).

### 2. Maze Generation
The maze is generated via a Depth-First Search (DFS) with backtracking. This ensures the maze is "perfect," meaning there are no loops and there is exactly one path between any two cells.

## 💻 Installation & Execution

### Option 1: Using IntelliJ IDEA (Recommended)
1. Clone the repository:
   ```bash
   git clone https://github.com/JeremyDrr/TileWorld.git
   ```
2. Open IntelliJ IDEA and select **File > Open**, then choose the project folder.
3. Make sure your **Project SDK** is set to Java 17 or higher.
5. Locate `fr.jeremy.tileworld.` in the project view.
6. Right-click the file and select **Run 'Main.main()'**.

### Option 2: Using the Command Line

1. Navigate to the `src` directory:
```bash
   cd TileWorld/src
   ```
2. Compile all files:
```bash
   javac fr/jeremy/tileworld/Main.java fr/jeremy/tileworld/core/*.java fr/jeremy/tileworld/agents/*.java 
   ```
3. Run the application:
```bash
   java fr.jeremy.tileworld.Main
   ```

[Made with 🤖 by Jeremy](https://jeremydrr.fr)
