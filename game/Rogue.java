package game;

import java.lang.Math;

import java.util.List;

public class Rogue extends Character {

    private int backstabChance = 20;// шанс ударить в спину двойным уроном в процентах

    public Rogue(String name, int x, int y) {
        super(name, 100, "human", "male", 2, 0, 5, x, y);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getInfo(){
        return "Rogue";
    }

    @Override
    // с вероятностью 20 % наносит двойной урон
    public void attack(Character character) {
        int chance = random.nextInt(fullPercent);// шанс ударить в спину двойным уроном
        if (chance < backstabChance) {
            if (this.status == "alive") {
                if (character.hp - 2 * this.damage + character.armor <= 0) {
                    character.hp = 0;
                    character.status = "dead";
                } else {
                    character.hp = character.hp - 2 * this.damage + character.armor;
                }
            }
        } else {
            if (this.status == "alive") {
                if (character.hp - this.damage + character.armor <= 0) {
                    character.hp = 0;
                    character.status = "dead";
                } else {
                    character.hp = character.hp - this.damage + character.armor;
                }
            }
        }
    }

    @Override
    public void step(List<Character> enemyTeam,List<Character> myTeam) {
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
