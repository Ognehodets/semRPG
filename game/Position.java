package game;

import java.lang.Math;

public class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDistance(Position enemyPosition) {
        return (double) Math.sqrt((this.x - enemyPosition.x) * (this.x - enemyPosition.x)
                + (this.y - enemyPosition.y) * (this.y - enemyPosition.y));
    }

    public Position getDifference(Position target) {
        Position dif = new Position(x - target.x, y - target.y);
        return dif;
    }

    // почему-то не хочет этот метод переопределять

    // @Override
    // public boolean equals(Position target) {
    // return x == target.x && y == target.y;
    // }

}
