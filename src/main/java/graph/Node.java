package graph;

import java.util.ArrayList;

public class Node{
        int identifier;
        float x_coordinate;
        float y_coordinate;
        ArrayList<Node> listOfNeighbors;
        public Node(){

        }

        public Node(int identifier, float x_coordinate, float y_coordinate){
            this.identifier = identifier;
            this.x_coordinate = x_coordinate;
            this.y_coordinate = y_coordinate;
            this.listOfNeighbors = new ArrayList<Node>();
        }

        public int getIdentifier() {
            return identifier;
        }

        public void setIdentifier(int identifier) {
            this.identifier = identifier;
        }

        public float getX_coordinate() {
            return x_coordinate;
        }

        public void setX_coordinate(float x_coordinate) {
            this.x_coordinate = x_coordinate;
        }

        public float getY_coordinate() {
            return y_coordinate;
        }

        public void setY_coordinate(float y_coordinate) {
            this.y_coordinate = y_coordinate;
        }

        public void addNeighbor(Node neighborNode){
            listOfNeighbors.add(neighborNode);
        }

        public ArrayList<Node> getListOfNeighbors(){
            return this.listOfNeighbors;
        }

        public Node removeNeighbor(int identifier){
            for (Node node : listOfNeighbors){
                if (node.getIdentifier() == identifier){
                    return node;
                }
            }
            return null;
        }
}