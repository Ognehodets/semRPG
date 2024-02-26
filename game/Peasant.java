package game;

import java.util.List;

public class Peasant extends Character {

    public Peasant(String name, int x, int y) {
        super(name, 5, "human", "male", 0, 0, 1, x, y);

    }

    // ничего не умеет кроме копания огорода, быстро умирает

    @Override
    public String toString() {
        return super.toString();
    }

    public String getInfo() {
        return "Peasant";
    }

    @Override
    public void step(List<Character> enemyTeam, List<Character> myTeam) {

    }
}
