package game;

/*Доработать классы лучников. Лучник должен во первых проверить жив ли он и есть ли у него стрелы, если нет то завершить метод.
Если всё да, то найти ближайшего противника и выстрелить по немы и, соответственно потратить одну стрелу.
Реализовать весь функционал лучников в методе step(). */

import java.util.List;

public class Sniper extends Character {

    public int arrows = 15;
    private double minHpToPowerShot = 0.2;// минимальный уровень hp в процентах для усиленной атаки
    private int maxPowerMultiplier = 3; // максимальный множитель усиления атаки

    public Sniper(String name, int x, int y) {
        super(name, 20, "elf", "female", 3, 0, 7, x, y);
    }

    @Override
    public String toString() {
        return super.toString() + ", arrows: " + arrows;
    }

    public String getInfo() {
        return "Sniper";
    }

    // при снижении хп ниже 20 % наносит от 2 до 3-кратного урона
    public void powerShot() {
        int powerMultiplier = random.nextInt(1, maxPowerMultiplier) + 1;
        System.out.println(this.name + "'s attack grows " + powerMultiplier + " times!!");
        this.damage = powerMultiplier * this.damage;
    }

    @Override
    public void attack(Character character) {
        if ((this.hp < this.maxHp * minHpToPowerShot) && (this.status == "alive")) {
            this.powerShot();
        } else {
            super.attack(character);
        }
    }

    @Override
    public void step(List<Character> enemyTeam, List<Character> myTeam) {
        if ((this.status != "alive") || (this.arrows == 0)) {
            return;
        } else {
            Character enemy = getTarget(enemyTeam);
            this.attack(enemy);
            
        }
        for (Character friend : myTeam) {
            if (friend.getInfo().equals("Peasant")&&(!((Peasant)friend).isBusy)) {
                ((Peasant) friend).isBusy = true;
                return;
            }
        }
        this.arrows--;
    }

}
