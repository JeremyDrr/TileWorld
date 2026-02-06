package fr.jeremy.tileworld;

import fr.jeremy.tileworld.agents.AStarAgent;
import fr.jeremy.tileworld.agents.IAgent;
import fr.jeremy.tileworld.agents.RandomAgent;
import fr.jeremy.tileworld.core.Direction;
import fr.jeremy.tileworld.core.Grid;
import fr.jeremy.tileworld.core.TileType;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //System.out.println("Hello TileWorld!");

        int width = 20;
        int height = 10;
        int targetX = 18;
        int targetY = 8;
        int agentX = 1;
        int agentY = 1;

        Grid world = new Grid(width, height);
        IAgent agent = new AStarAgent(targetX, targetY);

        //We add U-shaped walls, to test the intelligence of the Agent
        for (int i = 5; i < 15; i++) world.setTile(i, 3, TileType.OBSTACLE); // Roof
        for (int i = 3; i < 7; i++) world.setTile(5, i, TileType.OBSTACLE);  // Left Wall
        for (int i = 3; i < 7; i++) world.setTile(14, i, TileType.OBSTACLE); // Right Wall

        world.setTile(targetX, targetY, TileType.TARGET);

        while (true) {
            //Clear console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            world.setTile(agentX, agentY, TileType.AGENT);
            world.display();

            if (agentX == targetX && agentY == targetY) {
                System.out.println("\nCible atteinte ! L'agent a trouvé le chemin optimal. 🏆");
                break;
            }

            //Computing the next move
            Direction move = agent.chooseAction(world, agentX, agentY);

            if (move == Direction.STAY) {
                System.out.println("\nL'agent est bloqué... Impossible d'atteindre la cible.");
                break;
            }

            world.setTile(agentX, agentY, TileType.EMPTY);
            agentX += move.dx;
            agentY += move.dy;

            Thread.sleep(150);
        }
    }
}