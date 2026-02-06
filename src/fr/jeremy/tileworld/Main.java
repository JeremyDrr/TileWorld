package fr.jeremy.tileworld;

import fr.jeremy.tileworld.agents.IAgent;
import fr.jeremy.tileworld.agents.RandomAgent;
import fr.jeremy.tileworld.core.Direction;
import fr.jeremy.tileworld.core.Grid;
import fr.jeremy.tileworld.core.TileType;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //System.out.println("Hello TileWorld!");

        Grid world = new Grid(10, 10);
        IAgent agent = new RandomAgent();

        //HARDCODED (For now.)
        int agentX = 1, agentY = 1;
        int targetX = 8, targetY = 8;

        world.setTile(targetX, targetY, TileType.TARGET);
        world.setTile(5, 5, TileType.OBSTACLE);

        for (int step = 0; step < 100; step++) {
            // Nettoyage console (marche sur la plupart des terminaux modernes)
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Placement de l'agent sur la grille
            world.setTile(agentX, agentY, TileType.AGENT);

            System.out.println("Étape : " + step + " | Position : (" + agentX + "," + agentY + ")");
            world.display();

            if (agentX == targetX && agentY == targetY) {
                System.out.println("Cible atteinte ! 🎉");
                break;
            }

            // Décision de l'agent
            Direction move = agent.chooseAction(world, agentX, agentY);

            // On efface l'ancienne position pour le prochain tour
            world.setTile(agentX, agentY, TileType.EMPTY);

            // Mise à jour de la position
            agentX += move.dx;
            agentY += move.dy;

            Thread.sleep(300); // Pause pour avoir le temps de voir
        }
    }
}