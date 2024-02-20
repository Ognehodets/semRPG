package game;

import java.util.List;

public class Rogue extends Character {

    private int backstabChance = 20;// шанс ударить в спину двойным уроном в процентах

    public Rogue(String name, int x, int y) {
        super(name, 10, "human", "male", 2, 0, 5, x, y);
    }

    @Override
    public String toString() {
        return "Class: Rogue, " + super.toString();
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
    public void step(List<Character> enemyTeam) {
        
    }
}
