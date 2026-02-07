package fr.jeremy.tileworld.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MazeGenerator {

    public static void generate(Grid world, int width, int height) {

        //We fill everything with walls at start
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                world.setTile(x, y, TileType.OBSTACLE);
            }
        }

        //Then we start carving paths from the location (1, 1)
        carvePassage(1, 1, world, width, height);
    }

    private static void carvePassage(int cx, int cy, Grid world, int width, int height) {
        Direction[] dirs = {Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT};
        List<Direction> dirList = Arrays.asList(dirs); //Random to never get the same maze
        Collections.shuffle(dirList);

        for(Direction dir : dirList) {
            //In a perfect maze, we skip two nodes to leave a wall between the paths
            int nx = cx + (dir.dx * 2);
            int ny = cy + (dir.dy * 2);

            if(isInside(nx, ny, width, height) && world.getTile(nx, ny) == TileType.OBSTACLE){
                //We break the tile between the wall between the two
                world.setTile(cx + dir.dx, cy + dir.dy, TileType.EMPTY);
                //We break the target tile
                world.setTile(nx, ny, TileType.EMPTY);

                //We keep going recursively
                carvePassage(nx, ny, world, width, height);
            }
        }
    }

    private static boolean isInside(int x, int y, int width, int height) {
        return x > 0 && x < width - 1 && y > 0 && y < height - 1;
    }
}
