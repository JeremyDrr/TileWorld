package fr.jeremy.tileworld.agents;

import fr.jeremy.tileworld.core.Direction;
import fr.jeremy.tileworld.core.Grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAgent implements IAgent {

    private final Random random = new Random();

    @Override
    public Direction chooseAction(Grid grid, int currentX, int currentY) {

        List<Direction> possibleMoves = new ArrayList<Direction>();

        for(Direction dir : Direction.values()){
            if(grid.isWalkable(currentX + dir.dx, currentY + dir.dy)){
                possibleMoves.add(dir);
            }
        }

        if(possibleMoves.isEmpty())
            return Direction.STAY;

        return possibleMoves.get(random.nextInt(possibleMoves.size()));
    }
}
