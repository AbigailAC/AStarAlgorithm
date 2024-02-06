package graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;


public class graphBuilder {

    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");
        String filePath = "./txt files/graph.txt"; 
        Map<Integer, Node> nodeMap = buildNodes(filePath);
        assignCoordinates(nodeMap);
        revealNodes(nodeMap);
    }

    public static Map<Integer,Node> buildNodes(String filePath) {
        File file = new File(filePath);
        Map<Integer, Node> nodeMap = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                // The first part is the node id
                int nodeId = Integer.parseInt(parts[0]);
                Node node = nodeMap.get(nodeId);

                // If the node doesn't exist, create it
                if (node == null) {
                    node = new Node(nodeId, -1, -1);
                    nodeMap.put(nodeId, node);
                }

                // Add neighbors
                for (int i = 1; i < parts.length; i++) {
                    int neighborId = Integer.parseInt(parts[i]);
                    Node neighbor = nodeMap.get(neighborId);

                    // If the neighbor doesn't exist, create it
                    if (neighbor == null) {
                        neighbor = new Node(neighborId, 0, 0);
                        nodeMap.put(neighborId, neighbor);
                    }

                    // Add the neighbor
                    node.addNeighbor(neighbor);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        return nodeMap;
    }

    public static void assignCoordinates(Map<Integer, Node> nodeMap){
        String filePath = "./txt files/coords.txt";
        File file = new File(filePath);
        try(Scanner scanner = new Scanner(file)){
            //Loop through each line and split at space.
            //First number is the node's ID, second is the x_coord, third is the y_coord
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                int nodeId = Integer.parseInt(parts[0]);
                float x_coordinate = Float.parseFloat(parts[1]);
                float y_coordinate = Float.parseFloat(parts[2]);
                Node node = nodeMap.get(nodeId);

                node.setX_coordinate(x_coordinate);
                node.setY_coordinate(y_coordinate);
            }
            
        } catch (FileNotFoundException e){
            System.err.println("File not found: " + e.getMessage());
        }
    }

    public static void revealNodes(Map<Integer, Node> nodeMap) {
        Graph graph = new SingleGraph("MyGraph");
        graph.setAttribute("ui.stylesheet", "node {fill-color: red; size: 20px; text-alignment: at-right;}");
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");
    
        // First, add all nodes to ensure they exist in the graph
        for (Integer nodeId : nodeMap.keySet()) {
            String nodeIdStr = String.valueOf(nodeId);
            if(graph.getNode(nodeIdStr) == null) {
                graph.addNode(nodeIdStr).setAttribute("ui.label", nodeIdStr);
            }
        }
    
        // Then, add edges between nodes
        for (Map.Entry<Integer, Node> entry : nodeMap.entrySet()) {
            Node node = entry.getValue();
            String nodeId = String.valueOf(node.getIdentifier());
    
            for (Node neighbor : node.getListOfNeighbors()) {
                String neighborId = String.valueOf(neighbor.getIdentifier());
                String edgeId = nodeId + "-" + neighborId;
                if(graph.getEdge(edgeId) == null && graph.getEdge(neighborId + "-" + nodeId) == null) {
                    graph.addEdge(edgeId, nodeId, neighborId, true); // true for directed edges, if needed
                }
            }
        }
    
        // Display the graph
        graph.display();
    }
}