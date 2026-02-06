package fr.jeremy.tileworld.core;

import java.util.Arrays;

public class Grid {
    private final int width;
    private final int height;
    private final TileType[][] matrix;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new TileType[height][width];
        // Initialisation par défaut
        for (TileType[] row : matrix) {
            Arrays.fill(row, TileType.EMPTY);
        }
    }

    public void setTile(int x, int y, TileType type) {
        if (isInside(x, y)) {
            matrix[y][x] = type;
        }
    }

    public boolean isWalkable(int x, int y) {
        return isInside(x, y) && matrix[y][x] != TileType.OBSTACLE;
    }

    private boolean isInside(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void display() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                char symbol = switch (matrix[y][x]) {
                    case OBSTACLE -> '█';
                    case AGENT -> 'A';
                    case TARGET -> 'T';
                    default -> '.';
                };
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}