package game;

import java.util.List;

/*Доработать классы лучников. Лучник должен во первых проверить жив ли он и есть ли у него стрелы, если нет то завершить метод.
Если всё да, то найти ближайшего противника и выстрелить по немы и, соответственно потратить одну стрелу.
Реализовать весь функционал лучников в методе step(). */

public class Crossbowman extends Character {
    private int arrows = 15;
    private int ingureChance = 20; // шанс увернуться при побеге в процентах

    public Crossbowman(String name, int x, int y) {
        super(name, 15, "human", "male", 3, 0, 6, x, y);
    }

    @Override
    public String toString() {
        return "Class: Crossbowman, " + super.toString();
    }

    @Override
    // при получении урона в спину может увернуться
    public void getDamage(Character character) {
        int chance = random.nextInt(fullPercent);
        if (chance < ingureChance) {
            System.out.println(this.name + " dodged from backstub when retreating!");
        } else {
            System.out.println(this.name + " got backstub when retreating!");
            if (this.hp - character.damage <= 0) {
                this.hp = 0;
                this.status = "dead";
            } else {
                this.hp -= character.damage;
            }
        }
    }

    @Override
    public void step(List<Character> enemyTeam,List<Character> myTeam) {
        if ((this.status != "alive") || (this.arrows == 0)) {
            return;
        } else {
            Character enemy = getTarget(enemyTeam);
            this.attack(enemy);
            this.arrows--;
        }
    }
}
