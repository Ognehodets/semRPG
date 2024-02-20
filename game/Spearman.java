package game;

import java.util.List;

public class Spearman extends Character {
    private int hp;

    public Spearman(String name, int x, int y) {
        super(name, 35, "orc", "male", 2, 1, 2, x, y);
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
    public void step(List<Character> enemyTeam) {
       
    }

}
