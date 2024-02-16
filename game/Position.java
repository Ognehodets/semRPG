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

public double getDistance (Position enemyPosition){
    return (double) Math.sqrt((this.x-enemyPosition.x)*(this.x-enemyPosition.x)+(this.y-enemyPosition.y)*(this.y-enemyPosition.y));
} 

}
