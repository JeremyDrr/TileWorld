package fr.jeremy.tileworld.agents;

import fr.jeremy.tileworld.core.Direction;
import fr.jeremy.tileworld.core.Grid;

public interface IAgent{

    Direction chooseAction(Grid grid, int currentX, int currentY);
}
