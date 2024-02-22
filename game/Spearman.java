package game;

import java.util.List;

public class Spearman extends Character {
    private int hp;

    public Spearman(String name, int x, int y) {
        super(name, 100, "orc", "male", 2, 1, 2, x, y);
    }

    @Override
    public String toString() {
        return "Class: Spearman, " + super.toString();
    }

    @Override
    // при побеге использует броню
    public void getDamage(Character character) {
        System.out.println(this.name + " got reduced damage when retreating!");
        if (this.hp - character.damage + this.armor <= 0) {
            this.hp = 0;
            this.status = "dead";
        } else {
            this.hp = this.hp - character.damage + this.armor;
        }
    }

    @Override
    public void step(List<Character> enemyTeam, List<Character> myTeam) {
        if (this.status != "alive") {
            return;
        } else {
            Character enemy = getTarget(enemyTeam);
            if ((this.position.getDistance(enemy.position)) < 2) {
                this.attack(enemy);
                return;
            }
            Position newPosition = new Position(position.x, position.y);
            Position dif = position.getDifference(enemy.position);
            if (Math.abs(dif.x) > Math.abs(dif.y)) {
                newPosition.x += dif.x > 0 ? -1 : 1;
            } else {
                newPosition.y += dif.y > 0 ? -1 : 1;

            }
            for (Character friend : myTeam) {
                if ((friend.position.x == newPosition.x) && (friend.position.y == newPosition.y)) {
                    return;
                }
                
            }
            position.x = newPosition.x;
            position.y = newPosition.y;

        }
    }

}
