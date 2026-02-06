package fr.jeremy.tileworld.agents;

import fr.jeremy.tileworld.core.Direction;
import fr.jeremy.tileworld.core.Grid;

public class SmartAgent implements IAgent {

    private int targetX, targetY;

    public SmartAgent(int targetX, int targetY){
        this.targetX = targetX;
        this.targetY = targetY;
    }

    @Override
    public Direction chooseAction(Grid grid, int currentX, int currentY) {
        if (currentX < targetX && grid.isWalkable(currentX + 1, currentY)) return Direction.RIGHT;
        if (currentX > targetX && grid.isWalkable(currentX - 1, currentY)) return Direction.LEFT;
        if (currentY < targetY && grid.isWalkable(currentX, currentY + 1)) return Direction.DOWN;
        if (currentY > targetY && grid.isWalkable(currentX, currentY - 1)) return Direction.UP;

        return Direction.STAY;
    }
}
