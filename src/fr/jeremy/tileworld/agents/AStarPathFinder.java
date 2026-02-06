package fr.jeremy.tileworld.agents;

import fr.jeremy.tileworld.core.Direction;
import fr.jeremy.tileworld.core.Grid;

import java.util.*;

public class AStarPathFinder {

    public static List<Direction> findPath(Grid grid, int startX, int startY, int targetX, int targetY) {
        PriorityQueue<Node> openList = new PriorityQueue<>();
        Set<String> closedList = new HashSet<>();

        Node startNode = new Node(startX, startY);
        startNode.hCost = Math.abs(startX - targetX) + Math.abs(startY - targetY); // Manhattan
        openList.add(startNode);

        while (!openList.isEmpty()) {
            Node current = openList.poll();

            if (current.x == targetX && current.y == targetY) {
                return retracePath(current);
            }

            closedList.add(current.x + "," + current.y);

            for (Direction dir : Direction.values()) {
                if (dir == Direction.STAY) continue;
                int nextX = current.x + dir.dx;
                int nextY = current.y + dir.dy;

                if (!grid.isWalkable(nextX, nextY) || closedList.contains(nextX + "," + nextY)) continue;

                int newGCost = current.gCost + 1;
                Node neighbor = new Node(nextX, nextY);
                neighbor.gCost = newGCost;
                neighbor.hCost = Math.abs(nextX - targetX) + Math.abs(nextY - targetY);
                neighbor.parent = current;

                //If we already have a better path to the neighbor, we skip
                if (openList.stream().anyMatch(n -> n.x == nextX && n.y == nextY && n.getFCost() <= neighbor.getFCost())) {
                    continue;
                }
                openList.add(neighbor);
            }
        }
        return new ArrayList<>(); //No path found :c
    }

    private static List<Direction> retracePath(Node node) {
        List<Direction> path = new ArrayList<>();
        while (node.parent != null) {
            int dx = node.x - node.parent.x;
            int dy = node.y - node.parent.y;
            for (Direction d : Direction.values()) {
                if (d.dx == dx && d.dy == dy) path.add(0, d);
            }
            node = node.parent;
        }
        return path;
    }
}
