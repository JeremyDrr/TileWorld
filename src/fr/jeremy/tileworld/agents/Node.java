package fr.jeremy.tileworld.agents;

public class Node implements Comparable<Node>{

    public int x, y, gCost, hCost;
    public Node parent;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getFCost(){
        return gCost + hCost;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.getFCost(), other.getFCost());
    }
}
