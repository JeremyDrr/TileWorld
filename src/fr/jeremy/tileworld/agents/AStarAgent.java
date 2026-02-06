package fr.jeremy.tileworld.agents;

import fr.jeremy.tileworld.core.Direction;
import fr.jeremy.tileworld.core.Grid;

import java.util.ArrayList;
import java.util.List;

public class AStarAgent implements IAgent {

    private List<Direction> path = new ArrayList<>();
    private int targetX, targetY;

    public AStarAgent(int targetX, int targetY) {
        this.targetX = targetX;
        this.targetY = targetY;
    }

    @Override
    public Direction chooseAction(Grid grid, int currentX, int currentY) {
        path = AStarPathFinder.findPath(grid, currentX, currentY, targetX, targetY);

        if (path.isEmpty()) return Direction.STAY;
        return path.get(0);
    }
}
