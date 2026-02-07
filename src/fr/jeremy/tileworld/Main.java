package fr.jeremy.tileworld;

import fr.jeremy.tileworld.agents.AStarAgent;
import fr.jeremy.tileworld.agents.IAgent;
import fr.jeremy.tileworld.agents.RandomAgent;
import fr.jeremy.tileworld.core.Direction;
import fr.jeremy.tileworld.core.Grid;
import fr.jeremy.tileworld.core.MazeGenerator;
import fr.jeremy.tileworld.core.TileType;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //System.out.println("Hello TileWorld!");

        int width = 21;
        int height = 21;
        Grid world = new Grid(width, height);
        MazeGenerator.generate(world, width, height);

        int targetX = width - 2, targetY = height - 2;
        int agentX = 1, agentY = 1;

        IAgent agent = new AStarAgent(targetX, targetY);
        world.setTile(targetX, targetY, TileType.TARGET);

        while (true) {
            //Clear console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            world.setTile(agentX, agentY, TileType.AGENT);
            world.display();

            if (agentX == targetX && agentY == targetY) {
                System.out.println("\nTarget Reached! The Agent has find the most optimal path. 🏆");
                break;
            }

            //Computing the next move
            Direction move = agent.chooseAction(world, agentX, agentY);

            if (move == Direction.STAY) {
                System.out.println("\nThe Agent is stuck... Impossible to reach the Target.");
                break;
            }

            world.setTile(agentX, agentY, TileType.EMPTY);
            agentX += move.dx;
            agentY += move.dy;

            Thread.sleep(250);
        }
    }
}