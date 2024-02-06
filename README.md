# Graph-Based Shortest Pathfinding

This project implements an efficient pathfinding algorithm using the A* (A-star) algorithm to navigate an undirected graph. It reads the graph structure and node coordinates from text files, calculates edge weights based on Euclidean distances between nodes, and visualizes the shortest path and obstacles using GraphStream.

## Features

- **Dynamic Graph Construction**: Builds an undirected graph from adjacency list and node coordinates provided in text files.
- **A\* Pathfinding**: Implements the A* algorithm to find the shortest path between any two nodes.
- **Obstacle Handling**: Supports marking certain nodes as obstacles, which are not traversable.
- **Graph Visualization**: Uses GraphStream to visualize the graph, highlighting the shortest path and obstacles.
- **Euclidean Distance Heuristic**: Utilizes Euclidean distance for the heuristic function in the A* algorithm.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) version 8 or higher.
- GraphStream library (included as a Maven dependency).

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/AbigailAC/graph-pathfinding.git
   ```
2. Navigate to the project directory:
   ```sh
   cd graph-pathfinding
   ```
3. If using Maven, ensure dependencies are resolved by running:
   ```sh
   mvn install
   ```

### Running the Project

1. Compile the Java files in the `src` directory.
2. Run the `graphBuilder` class:
   ```sh
   java graph.graphBuilder
   ```
3. Follow the on-screen prompts to input start and goal nodes, as well as any obstacle nodes.

## Usage

The project requires two text files: `graph.txt` for the adjacency list and `coords.txt` for node coordinates. These files should be placed in the `txt files` directory within the project root.

- `graph.txt` format:
  ```
  1 2 3
  2 1 4 5
  3 1 5
  4 2 5
  ```
- `coords.txt` format:
  ```
  1 2.3 4.5
  2 4.6 7.89
  3 4.56 2.09
  4 2.57 1.99
  ```

## Contributing

As this was done for CAP6635: Advanced Artificial Intelligence during my Master's program, no contributions will be accepted.

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Acknowledgments

- [GraphStream](https://graphstream-project.org/) for providing the graph visualization toolkit.
- The A* algorithm, for its efficiency in pathfinding problems.

## Contact

Abigail Beneduce - AbigailBeneduce@gmail.com 

Project Link: [https://github.com/AbigailAC/graph-pathfinding](https://github.com/AbigailAC/graph-pathfinding)

---
